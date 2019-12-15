package wabao.service;

import java.util.List;
import java.util.Map;

public interface UniversalService {
	public void insertData(String tableName,Object obj) throws Exception;
	public int updateData(String tableName,String key,Object obj);
	public List<Map<String,Object>> selectData(String tableName,String key,String keyValue);
	public int updateDefault(int uid);
}
