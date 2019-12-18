package wabao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wabao.dao.UserDao;
import wabao.pojo.user;

@Service
public class UserService {
	
	
	@Autowired
	private UserDao userDao;
	
	public user  selectAll(String username){
		
		return userDao.selectUserAll(username);
	}

	public int  insertuser(String username,String password){

		return userDao.insertuser(username,password);
	}

}
