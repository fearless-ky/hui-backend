package wabao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wabao.dao.StudentDao;
import wabao.pojo.Student;


@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public List<Student> selectAll(){
		
		return studentDao.selectStudentAll();
		
	}
	

}
