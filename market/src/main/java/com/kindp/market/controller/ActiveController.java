package com.kindp.market.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/active")
public class ActiveController {
	
	@RequestMapping("toSayGreet")
	@ResponseBody
	public ModelAndView toSayGreet(HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/active/sayGreet");
		return mv;
	}
	
	@RequestMapping("sayGreet")
	@ResponseBody
	public void sayGreet(String content,HttpServletResponse response){
		System.out.println(content);
	}
}
