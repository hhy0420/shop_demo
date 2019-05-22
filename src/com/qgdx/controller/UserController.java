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

	//���ӵ�service,ͨ�������ҵ�service��
	@Resource(name="userService")
	UserService service;
	
	/*
	 *����
	 *
	 * ��ȡ�������ж�
	 * ��½�ɹ�����ת��userlistҳ��
	 * ��ҳ����ʾ�����ݿ�������Ϣ
	 * ��¼ʧ�ܣ�����ͣ���ڵ�¼ҳ��
	 * 
	 * ������ݿ��ж�����Ϣ�����᲻������⣿����
	 */
	
	//��¼
	@RequestMapping("login.do")
	public String dologin(HttpServletRequest request,String name,String password){
		System.out.println("����login.do����");
		//��һ������¼������Ҫ��ȡ��ǰ��������˺ţ�����
		//�ⶨһ�����ݿ���ڵ�id

		//�ڶ�����ͨ���˺ŷ������ݿ⣬���������˺ŵ�����
		//���������õ����˺ŵ����ݣ��������
		//���Ĳ����жϣ�����˺�������Գɹ�������ת���µ�ҳ��
		//���岽������˺ź��������ʧ�ܣ�ͣ���ڵ�½ҳ��
		
		//service.dologin();
		//service.dologin(id);
		User user=service.dologin(name);
		if(user==null){
			System.out.println("�޷��鵽���˺�");
			return "redirect:index.html";
		}else{
//			System.out.println(user);
//			System.out.println("service����ִ�н���");
//			return null;
			if(name.equals(user.getName())&&password.equals(user.getPassword())){
				//����һ������������ݿ����������ݵļ���
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
	
	//ע��
	@RequestMapping("regist.do")
	public String doregist(HttpServletRequest request,User user){		

		System.out.println(user);
		service.doregist(user);
		return "redirect:index.html";
	}
	
	//�鿴
	@RequestMapping("selectUser.do")
	public String doselectUser( HttpServletRequest request, int id){
		System.out.println("�鿴ʱ��������id:"+id);
		User user=service.doselectUser(id);
		System.out.println(user);
		request.setAttribute("user",user);
		return "SelectUser";
	}
	
	//�޸�
	@RequestMapping("update.do")
	public String doupdate(HttpServletRequest request,int id){
		User user=service.doupdate(id);
		request.setAttribute("user", user);
		return "UserUpdate";
	}
	//���
	
	@RequestMapping("updateaf.do")
	public String doupdateaf(HttpServletRequest request,User user){
		System.out.println(user);
		service.updateaf(user);
		List<User> users=new ArrayList<User>();
		users=service.findAllUser();
		request.setAttribute("users", users);
		return "userlist";
	}
	
	//ɾ��
	@RequestMapping("delete.do")
	public String dodelete(HttpServletRequest request,int id){
		service.dodelete(id);
		List<User> users=new ArrayList<User>();
		users=service.findAllUser();
		request.setAttribute("users", users);
		return "userlist";
	}
}
