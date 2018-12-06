package cn.edu.sdust.service;

import java.util.*;
import org.apache.ibatis.session.SqlSession;

import cn.edu.sdust.mapper.UserMapper;
import cn.edu.sdust.pojo.User;
import cn.edu.sdust.utils.DBTools;

public class UserService {
	

	public static void main(String[] args){
	   insertUser();	
	   selectAllUser();
	   selectUserById(1);
	}
// 插入一个User信息
	private static void insertUser(){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("test111");
        try{
        	mapper.insertUser(user);
        	session.commit();
        }catch(Exception e){
        	session.rollback();
        }
	}
//	查询所有User信息
	private static void selectAllUser(){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userlist = new ArrayList<User>();
        try{
        	userlist = mapper.selectAllUser();
        	System.out.println("ok.");
        	session.commit();
        }catch(Exception e){
        	session.rollback();
        }
        for (User user : userlist) {
            System.out.println(user);
        }
	}
	
//	按照ID查询User信息
	private static void selectUserById(int id){
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        try{
        	user = mapper.selectUserById(id);
        	System.out.println("ok.");
        	session.commit();
        }catch(Exception e){
        	session.rollback();
        }
        System.out.println(user);
	}
	
}
