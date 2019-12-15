package wabao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wabao.pojo.Student;
import wabao.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	  // @ResponseBody
	@RequestMapping(value = "SearchStudent",method = RequestMethod.GET)
	public String SearchUser(Model model) {
		
		List<Student> list = new ArrayList<Student>();
	    list = studentService.selectAll();
		model.addAttribute("code", 1);
		model.addAttribute("studentdatas", list);
	  	return "student-list";
	}

}
