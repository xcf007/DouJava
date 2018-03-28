package cn.xcf007.doujava.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	private static final Logger log = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String index() {
		return "Hello,首页！";
	}
}
