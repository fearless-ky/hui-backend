package wabao.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wabao.pojo.user;
import wabao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


    @RequestMapping(value = "loginuser",method = RequestMethod.POST)
    public Object SearchUser(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password,
                             Model model,
                             HttpServletResponse response) {

        response.setContentType("text/html;charset=utf-8");
        user user1 = userService.selectAll(username);

        if(user1 != null && username.equals(user1.getUsername()) && password.equals(user1.getPassword()))
        {
            System.out.println("success!!");
            model.addAttribute("data","");
           return "welcome.html";
        }
        else {
            System.out.println("fail!!!");
            model.addAttribute("data","登录失败!!");
            return "login.html";
        }

    }

    @RequestMapping(value = "registeruser",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public Object register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "yanzhengma") String yanzhengma,
                           Model model,
                           HttpServletResponse response,
                           HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Map<Object,Object> map = new HashMap<>();
        user user1 = userService.selectAll(username);


        if(username == "")
        {
            model.addAttribute("data","用户名为空！");
            return "register";
        }
        if(password == "")
        {
            model.addAttribute("data","密码为空！");
            return "register";
        }

            //将StringBuffer转换成String
        String code =  request.getSession().getAttribute("code").toString();
        if(!(yanzhengma.equals(code)))
        {
            model.addAttribute("data","验证码不正确！！");
            return "register";
    }
        if(user1 == null && userService.insertuser(username,password) > 0)
    {
            model.addAttribute("data","注册成功！");
            return "login";
    }
        else{
            model.addAttribute("data","注册失败！用户名已存在！");
            return "register";
        }
    }

	/*@ResponseBody
	@RequestMapping(value = "loginuser",method = RequestMethod.POST)
	public Object SearchUser(@RequestBody String file1) {

        JSONObject file = JSON.parseObject(file1);
        Map<Object,Object> map = new HashMap<>();
        String username = file.getString("username");
        String password = file.getString("password");

        user user1 = userService.selectAll(username);

	    if(user1 != null && username.equals(user1.getUsername()) && password.equals(user1.getPassword()))
        {
            System.out.println("success!!");
            map.put("code","1");
            map.put("data","success");
        }
	    else {
            System.out.println("fail!!!");
            map.put("code","0");
            map.put("data","fail");
        }
	  	 return map;
	}*/


}
