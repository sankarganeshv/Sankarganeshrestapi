package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.bean.User;

public class UserDao implements IUserDao{
	//setting the Template
			JdbcTemplate template;
			public void setTemplate(JdbcTemplate template)
			{
				this.template=template;
			}
			public UserDao() {
				// TODO Auto-generated constructor stub
			}


		@Override
		public List<User> getAllDetails()
		{
			// TODO Auto-generated method stub
			
			return template.query("select rollid,username,password from login",new RowMapper<User>()
					{
					
				

					public User mapRow(ResultSet rs, int row) throws SQLException {
					// TODO Auto-generated method stub
					User  user=new User();
					user.setRollId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setPassword(rs.getString(3));
					return user;
					
				}
	});
					};
		

		@Override
		public User searchUserDetails(String userName,String password) {
			
			// TODO Auto-generated method stub
			String sql ="select rollid, userName,password from login where username=? and password =?";
			return template.queryForObject(sql, new Object[]{userName,password},
					new BeanPropertyRowMapper<User>(User.class));
			
		}

		@Override
		public User getUserById(int uId) {
			// TODO Auto-generated method stub
			String sql="select rollid,username,password from Login where rollid=?";
			return template.queryForObject(sql, new Object[]{uId},
					new BeanPropertyRowMapper<User>(User.class));
		}



		@Override

			public int insertUserDetails(User user) {
				String sqlOne = "insert into login(rollid,username,password values('"
						+ user.getRollId()
						+ "','"
						+ user.getUserName()
						+ "','"
						+ user.getPassword()
						
						+ ")";
				
				return template.update(sqlOne);
		}

		@Override
		public int updateUserDetails(User user) {
			// TODO Auto-generated method stub
			String sqlOne = "update login set rollid='" + user.getRollId()
			+ "',rollId='" + user.getUserName()+ "',username='" + user.getPassword()
			+ "',password=" 
			+ " where rollid=?";
			return template.update(sqlOne, new Object[] { user.getRollId() });
		}

}
