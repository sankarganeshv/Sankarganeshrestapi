package com.faith.dao;

import java.util.List;

import com.faith.bean.User;

public interface IUserDao 
		{
		public abstract List<User> getAllDetails();
		public abstract User searchUserDetails(String userName,String password);
		public abstract User getUserById(int uId);
		public abstract int insertUserDetails(User user);
		public abstract int updateUserDetails(User user);
		
		}



