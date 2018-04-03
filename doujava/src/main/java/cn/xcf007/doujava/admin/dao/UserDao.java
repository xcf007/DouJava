package cn.xcf007.doujava.admin.dao;

import java.util.List;

import cn.xcf007.doujava.admin.entity.User;

public interface UserDao {
	User login(User user);
	void add(User user);
	List<User> list();
}
