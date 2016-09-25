package com.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.UserService;
import com.util.Result;
import com.util.ResultCode;
import com.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 2016/6/29.
 */
@Controller
@Scope("prototype")
public class HelloWorld {
	
	@Autowired
	private UserService userService;
	
	
    //查看课程列表
    @RequestMapping(value = "/test")
    @ResponseBody
    public String subject(HttpServletResponse response) {
        return "HelloWorld";
    }
    
    @RequestMapping(value = "/getUser.work")
    @ResponseBody
    public Result getUserInfo(HttpServletResponse response, int id) {
    	Result result = new Result();
    	result.setObject(userService.getUserInfo(id));
    	result.setCode(ResultCode.SUCCESS);
    	System.out.println(result.getObject());
    	return result;
    }

    @RequestMapping(value = "/index.jspx")
    public ModelAndView index(HttpServletRequest request , HttpServletResponse response, int id) {
    	ModelAndView view = new ModelAndView("forward:/public/index.jsp");
    	UserVO user = userService.getUserInfo(id);
    	
    	view.addObject("userinfo", user);
    	
    	return view;
    }

}
