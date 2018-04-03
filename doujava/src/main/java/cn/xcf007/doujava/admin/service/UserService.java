package cn.xcf007.doujava.admin.service;

import java.util.List;

import cn.xcf007.doujava.admin.entity.User;

public interface UserService {
	User login(User user);
	List<User> list();
}
