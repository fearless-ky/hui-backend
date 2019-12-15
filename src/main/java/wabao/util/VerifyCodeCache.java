package wabao.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VerifyCodeCache {

	private final static Map<String, Entity> map = new HashMap<>();
	private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	public synchronized static void put(String key, Object data) {
		VerifyCodeCache.put(key, data, 0);
	}

	public synchronized static void put(String key, Object data, long expire) {
		VerifyCodeCache.remove(key);
		// 设置过期时间
		if (expire > 0) {
			Future future = executor.schedule(new Runnable() {
				@Override
				public void run() {
					// 过期后清除该键值对
					synchronized (VerifyCodeCache.class) {
						map.remove(key);
					}
				}
			}, expire, TimeUnit.MILLISECONDS);
			map.put(key, new Entity(data, future));
		} else {
			// 不设置过期时间
			map.put(key, new Entity(data, null));
		}
	}

	public synchronized static Object get(String key) {
		Entity entity = map.get(key);
		return entity == null ? null : entity.getValue();
	}

	public synchronized static <T> T get(String key, Class<T> clazz) {
		return clazz.cast(VerifyCodeCache.get(key));
	}

	public synchronized static Object remove(String key) {
		// 清除原缓存数据
		Entity entity = map.remove(key);
		if (entity == null)
			return null;
		// 清除原键值对定时器
		Future future = entity.getFuture();
		if (future != null)
			future.cancel(true);
		return entity.getValue();
	}

	public synchronized static int size() {
		return map.size();
	}

	private static class Entity {
		private Object value;
		private Future future;

		public Entity(Object value, Future future) {
			this.value = value;
			this.future = future;
		}

		public Object getValue() {
			return value;
		}

		public Future getFuture() {
			return future;
		}
	}
}
