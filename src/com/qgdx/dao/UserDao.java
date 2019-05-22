package com.qgdx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qgdx.entity.User;

@Repository("userDao")
public interface UserDao {

	//User叫数据类型
	User dologin(String name);

	List<User> findAllUser();

	void doregist(User user);

	User doselectUser(int id);

	User doupdate(int id);

	void updateaf(User user);

	void dodelete(int id);

	

	

	
}
