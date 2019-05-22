package com.qgdx.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qgdx.dao.UserDao;
import com.qgdx.entity.User;

//给service层添加注解，加上别名（任意写，建议写类名，首字母小写）
@Service("userService")
public class UserService {

	@Resource(name="userDao")
	UserDao userDao;
	public User dologin(String username) {
		User user=userDao.dologin(username);
		return user;
	}
	public List<User> findAllUser() {
		List<User> users=new ArrayList<User>();
		users=userDao.findAllUser();
		return users;
	}
	public void doregist(User user) {
		userDao.doregist(user);
		
	}
	public User doselectUser(int id) {
		User user=userDao.doselectUser(id);
		return user;
	}
	public User doupdate(int id) {
		User user=userDao.doupdate(id);
		return user;
	}
	public void updateaf(User user) {
		userDao.updateaf(user);
	}
	public void dodelete(int id) {
		userDao.dodelete(id);
	}

	
	

}
