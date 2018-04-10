package cn.xcf007.doujava.admin.controller;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;

import cn.xcf007.doujava.admin.entity.User;
import cn.xcf007.doujava.admin.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);

	@Resource
	private com.google.code.kaptcha.impl.DefaultKaptcha captchaProducer; 
	
	@Resource
    private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user, String captcha, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object objCaptcha = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(null != objCaptcha) {
			if(objCaptcha.toString().equalsIgnoreCase(captcha)) {
				//验证码相等
		        String md5Password = DigestUtils.md5Hex(user.getPassword());
		        user.setPassword(md5Password);
		        User resultUser = userService.login(user);
		        if (resultUser == null) {
		        	session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
					ModelAndView mv = new ModelAndView("/msg");
					mv.addObject("out", "out");
					mv.addObject("msgTitle","用户不存在或密码错误！");
					mv.addObject("skipText","将在 3 秒后跳转到上一个链接地址!");
					mv.addObject("url",request.getRequestURI());	            
		            return mv;
		        } else {
		        	session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
		            session.setAttribute("currentUser", resultUser);
		            return new ModelAndView("redirect:index");
		        }			
			}else{
				ModelAndView mv = new ModelAndView("/msg");
				mv.addObject("out", "out");
				mv.addObject("msgTitle","您输入的验证码不正确!");
				mv.addObject("skipText","将在 3 秒后跳转到上一个链接地址!");
				mv.addObject("url",request.getRequestURI());
				return mv;
			}
		}
		return new ModelAndView("login");
    }	
	
	@RequestMapping(value = "/login/captcha")
	public ModelAndView getCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Cache-Control", "max-age=1, s-maxage=1, no-cache, must-revalidate");
		response.setContentType("image/png;charset=utf-8");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}	
}
