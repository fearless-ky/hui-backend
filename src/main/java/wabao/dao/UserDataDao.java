package wabao.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userDataDao")
public interface UserDataDao {
	public Map<String,Object> selectCenterData(@Param("uid") int uid);
	public List<Map<String, Object>> selectAddressList(@Param("uid") int uid);
	public Map<String, Object> selectAddress(@Param("aid") int aid);
}
