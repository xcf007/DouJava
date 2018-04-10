package cn.xcf007.doujava.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xcf007.doujava.admin.dao.UserDao;
import cn.xcf007.doujava.admin.entity.User;
import cn.xcf007.doujava.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}

	public List<User> list() {
		return userDao.list();
	}

	@Override
	public void add(User user) {
		if(user != null) {
			userDao.add(user);
		}
	}

}
