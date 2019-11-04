package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IUserDao;
import com.faith.bean.User;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class UserController {

		@Autowired
		private IUserDao dao;
		
		//select
		//Get all users
		@RequestMapping(value="/userdetails",method =RequestMethod.GET)
		public List getUserDetails()
		{
			List list;
			System.out.println("Get all user details");
			list=dao.getAllDetails();
			return list;
		}
		//set by Name
		@RequestMapping(value="/{userName}/{password}",method =RequestMethod.GET)
		public User getUserdetails(@PathVariable("userName") String userName,@PathVariable("password") String password)
		{
		
			User user=(User)dao.searchUserDetails(userName,password);
			return user;
		}
		//get by id
		@RequestMapping(value="/rollId/{uId}", method=RequestMethod.GET)
		public User getUserdetails(@PathVariable("uId") int uId)
		{
			User user=dao.getUserById(uId);
			return user;
			
		}
		//Insert into vendor details
		@RequestMapping(value="/insertdetails", method =RequestMethod.POST)
		public void insertUserDetails(@RequestBody User user)
		{
			dao.insertUserDetails(user);
		}
		//Update Vendor details
		@RequestMapping(value="/updatedetails", method =RequestMethod.PUT)
		public void updateUserDetails(@RequestBody User user)
		{
			dao.updateUserDetails(user);
		}
		

}





