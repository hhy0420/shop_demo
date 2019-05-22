package com.qgdx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qgdx.entity.User;
import com.qgdx.service.UserService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class UserController {

	//连接到service,通过别名找到service层
	@Resource(name="userService")
	UserService service;
	
	/*
	 *需求
	 *
	 * 获取到密码判断
	 * 登陆成功，跳转到userlist页面
	 * 该页面显示出数据库所有信息
	 * 登录失败，继续停留在登录页面
	 * 
	 * 如果数据库有多条信息，看会不会出问题？？？
	 */
	
	//登录
	@RequestMapping("login.do")
	public String dologin(HttpServletRequest request,String name,String password){
		System.out.println("进入login.do请求");
		//第一步：登录请求，需要获取到前段输入的账号，密码
		//拟定一个数据库存在的id

		//第二步：通过账号访问数据库，并调出该账号的数据
		//第三步：拿到该账号的数据，配对密码
		//第四步：判断，如果账号密码配对成功，则跳转到新的页面
		//第五步：如果账号和密码配对失败，停留在登陆页面
		
		//service.dologin();
		//service.dologin(id);
		User user=service.dologin(name);
		if(user==null){
			System.out.println("无法查到此账号");
			return "redirect:index.html";
		}else{
//			System.out.println(user);
//			System.out.println("service方法执行结束");
//			return null;
			if(name.equals(user.getName())&&password.equals(user.getPassword())){
				//创建一个用来存放数据库中所有数据的集合
				List<User> users=new ArrayList<User>();
				users=service.findAllUser();
				request.setAttribute("users", users);
				
				return "userlist";
			}
			else{
				return "redirect:index.html";
			}
		}
	}
	
	//注册
	@RequestMapping("regist.do")
	public String doregist(HttpServletRequest request,User user){		

		System.out.println(user);
		service.doregist(user);
		return "redirect:index.html";
	}
	
	//查看
	@RequestMapping("selectUser.do")
	public String doselectUser( HttpServletRequest request, int id){
		System.out.println("查看时，传来的id:"+id);
		User user=service.doselectUser(id);
		System.out.println(user);
		request.setAttribute("user",user);
		return "SelectUser";
	}
	
	//修改
	@RequestMapping("update.do")
	public String doupdate(HttpServletRequest request,int id){
		User user=service.doupdate(id);
		request.setAttribute("user", user);
		return "UserUpdate";
	}
	//完成
	
	@RequestMapping("updateaf.do")
	public String doupdateaf(HttpServletRequest request,User user){
		System.out.println(user);
		service.updateaf(user);
		List<User> users=new ArrayList<User>();
		users=service.findAllUser();
		request.setAttribute("users", users);
		return "userlist";
	}
	
	//删除
	@RequestMapping("delete.do")
	public String dodelete(HttpServletRequest request,int id){
		service.dodelete(id);
		List<User> users=new ArrayList<User>();
		users=service.findAllUser();
		request.setAttribute("users", users);
		return "userlist";
	}
}
