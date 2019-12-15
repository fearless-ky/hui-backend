package wabao.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wabao.dao.UserDao;
import wabao.pojo.tb_User;


@Service
public class UserService {
	
	
	@Autowired
	private UserDao userDao;
	
	public List<tb_User> selectAll(){
		
		return userDao.selectUserAll();
		
	}

}
