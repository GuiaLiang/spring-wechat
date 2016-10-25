package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping(value = "/api/wx")
public class WechatConfig {
	
	private String token = "guia";

	@RequestMapping(value = "/handle.work", method = RequestMethod.GET)
	@ResponseBody
	public void wechatCofig(HttpServletRequest request, HttpServletResponse response) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		String[] str = new String[]{token, timestamp, nonce};
		Arrays.sort(str);
		
		StringBuffer sb = new StringBuffer();
		for(String s : str) {
			sb.append(s);
		}
		
		String res = DigestUtils.sha1Hex(sb.toString());
		PrintWriter write = null;
		try {
			write = response.getWriter();
			if(res.equals(signature)) {
				write.print(echostr);
				write.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			write.close();
		}
	}
	
	@RequestMapping(value = "/handle.work", method = RequestMethod.POST)
	@ResponseBody
	public void reply(HttpServletRequest request, HttpServletResponse response) {
	}
}
