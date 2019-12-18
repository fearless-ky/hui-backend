package wabao.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import wabao.pojo.user;

public interface UserDao {
	
	public user selectUserAll(String username);
	public int insertuser(@Param("username") String username, @Param("password") String password);
}
