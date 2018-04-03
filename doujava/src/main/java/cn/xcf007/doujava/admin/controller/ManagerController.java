package cn.xcf007.doujava.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cn.xcf007.doujava.admin.entity.User;
import cn.xcf007.doujava.admin.service.UserService;

@Controller
public class ManagerController {
	
	@Resource
    private UserService userService;
	
	@GetMapping("/manager")
	public String initPage(HttpServletRequest request) {
		List<User> users = userService.list();
		request.setAttribute("users", users);
		return "manager";
	}
}
