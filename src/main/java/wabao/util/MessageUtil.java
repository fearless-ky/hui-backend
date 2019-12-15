package wabao.util;

import java.util.HashMap;
import java.util.Map;

public class MessageUtil {
	public static Map<String,Object> getMsgData(String code,String msg){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}
	public static Map<String,Object> getMsgData(String code,String msg,Object data){
		Map<String,Object> map = getMsgData(code,msg);
		map.put("data", data);
		return map;
	}
	public static Map<String,Object> getMsgData(String code,String msg,Object data,String dataKey){
		Map<String,Object> map = getMsgData(code,msg);
		map.put(dataKey, data);
		return map;
	}
}
