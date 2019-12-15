package wabao.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wabao.pojo.tb_User;
import wabao.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	  // @ResponseBody
	@RequestMapping(value = "SearchUser",method = RequestMethod.GET)
	public String SearchUser(Model model) {
		
		List<tb_User> list = new ArrayList<tb_User>();
	    list = userService.selectAll();
		model.addAttribute("code", 1);
		model.addAttribute("datas", list);
	  	return "";
	}
	
	
}
