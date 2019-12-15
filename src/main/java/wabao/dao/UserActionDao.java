package wabao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserActionDao {
	public int selectKey();
	public int insertData(@Param("tablename") String tableName,@Param("fields") List<String> fields,@Param("values") List<String> values);
	public int deleteAddress(Integer aid);
	public int[] selectSM(Integer uid);

}
