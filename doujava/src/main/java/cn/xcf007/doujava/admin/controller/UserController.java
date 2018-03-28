package cn.xcf007.doujava.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.xcf007.doujava.admin.entity.User;
import cn.xcf007.doujava.admin.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);// ��־�ļ�
	
	@Resource
    private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user, HttpServletRequest request) {
        String md5Password = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(md5Password);
        User resultUser = userService.login(user);
        if (resultUser == null) {
            request.setAttribute("user", user);
            request.setAttribute("errorMsg", "用户不存在或密码错误！");
            return new ModelAndView("/login");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", resultUser);
            return new ModelAndView("index");
        }
    }	
}
