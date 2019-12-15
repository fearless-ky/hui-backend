package wabao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


@Controller
public class testController {
	
	/* @RequestMapping(value = "/test1")
	    public String tes1(@RequestParam(value = "username") String username ) {
		 System.out.println("username = " + username);
	        return "six.jsp";
	    }*/
	@ResponseBody
	 @RequestMapping(value = "/test1",method = RequestMethod.POST)
	     public Object tes1(@RequestBody String username) {
		
		//把json字符串转换成json对象  然后调用   ..  jjj.getString("username")  用这个来获取key
		 JSONObject username1 = JSON.parseObject(username);  
		 
		 System.out.println("username = " + username1.getString("username"));
		 Map<Object, Object> map = new HashMap<Object, Object>();
		 map.put("code", "1");
		 map.put("message", "success");
	        return map;
	    }

}
