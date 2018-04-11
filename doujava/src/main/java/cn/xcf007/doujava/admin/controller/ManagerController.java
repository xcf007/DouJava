package cn.xcf007.doujava.admin.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import cn.xcf007.doujava.admin.entity.UserFormBean;
import cn.xcf007.doujava.util.Check;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cn.xcf007.doujava.admin.entity.User;
import cn.xcf007.doujava.admin.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerController {

    @Resource
    private UserService userService;

    public class ActionLink {
        private String text;
        private String href;

        public ActionLink(String text, String href) {
            this.text = text;
            this.href = href;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    @GetMapping("/manager")
    public String initPage(HttpServletRequest request) {
        List<User> users = userService.list();
        request.setAttribute("action", "default");
        request.setAttribute("users", users);
        request.setAttribute("actionLink", new ActionLink("添加管理员", request.getContextPath() + "/manager/add"));
        return "manager";
    }

    @GetMapping("/manager/add")
    public String addPage(HttpServletRequest request) {
        request.setAttribute("action", "add");
        request.setAttribute("actionLink", new ActionLink("返回列表", request.getContextPath() + "/manager"));
        return "manager";
    }

    @PostMapping("/manager/add")
    public ModelAndView add(final UserFormBean userFormBean, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/msg");
        mv.addObject("urHere", "信息提示");
        mv.addObject("skipText", "将在 3 秒后跳转到上一个链接地址!");
        if (!Check.isUserName(userFormBean.getUserName())) {
            mv.addObject("msgTitle", "用户名不能为空且至少包含4个字符，需以字母开头。只能使用字母、数字、下划线!");
            return mv;
        }
        if (!Check.isPassword(userFormBean.getPassword())) {
            mv.addObject("msgTitle", "密码不能为空，且至少包含6个字符!");
            return mv;
        }
        if (!userFormBean.getConfirmPassword().equals(userFormBean.getPassword())) {
            mv.addObject("msgTitle", "确认密码输入不对!");
            return mv;
        }

        //添加管理员
        User user = new User();
        user.setUserName(userFormBean.getUserName());
        user.setEmail(userFormBean.getEmail());
        user.setPassword(DigestUtils.md5Hex(userFormBean.getPassword()));
        user.setAddTime(new Date());
        user.setActionList("ADMIN");
        userService.add(user);
        mv.addObject("msgTitle", "填加管理员成功!");
        return mv;
    }

    @GetMapping("/manager/edit/{id}")
    public String editPage(@PathVariable("id") Integer userId, HttpServletRequest request) {
        request.setAttribute("action", "edit");
        request.setAttribute("actionLink", new ActionLink("返回列表", request.getContextPath() + "/manager"));
        return "manager";
    }

}
