package com.wjw.lifecircle.action;

import java.util.List;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.wjw.lifecircle.dao.UserDAO;
import com.wjw.lifecircle.model.User;
import com.wjw.lifecircle.util.IOUtil;


public class UserAction extends ActionSupport 
{
	private String email;
	private String userName;
	private String password;
	private UserDAO userDAO;
	
	
	
	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public UserDAO getUserDAO() {
		return userDAO;
	}




	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	

	public String login()
	{
		String errorMsg = "";
		User user = null;
		if(email!=null && password!=null &&email.length()!=0 && password.length() != 0 )
		{
			List list = userDAO.findByEmail(email);
		    
			if(list.size() !=0 )
			{
				user  = (User) list.get(0);
				if(user.getPassword().equals(password))
				{
					errorMsg = "";
					
				}else
				{
					errorMsg = "密码不正确";
				}
			}else{
				errorMsg = "该邮箱未注册";
			}
			
		}else
		{
			errorMsg = "邮箱和密码不能为空";
		}
		
		String[] excludes= {"password","orders"};
		JSONObject obj = IOUtil.getJsonObject(excludes, "user", user, errorMsg);
		IOUtil.responseJson(obj);
		
		return NONE;
	}
	
	
	public String regist()
	{
		String errorMsg = "";
		
		if(email!=null && password!=null && userName!=null &&email.length()!=0 && password.length() != 0 &&userName.length()!=0)
		{
			List list = userDAO.findByEmail(email);
		    
			if(list.size() !=0 )
			{
				errorMsg = "该邮箱已注册";
				
			}else{
				User user = new User(userName,email,password,"",null);
				userDAO.save(user);
			}
			
		}else
		{
			errorMsg = "用户名、邮箱和密码不能为空";
		}
		
		
		JSONObject obj = IOUtil.getJsonObject(errorMsg);
		IOUtil.responseJson(obj);
		
		return NONE;
	}
	
	
	
}
