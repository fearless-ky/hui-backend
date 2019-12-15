package wabao.dao;

import java.util.List;

import wabao.pojo.tb_User;

public interface UserDao {
	
	public List<tb_User> selectUserAll();

}
