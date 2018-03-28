package cn.xcf007.doujava.admin.dao;

import org.springframework.stereotype.Repository;

import cn.xcf007.doujava.admin.entity.User;

public interface UserDao {
	User login(User user);
}
