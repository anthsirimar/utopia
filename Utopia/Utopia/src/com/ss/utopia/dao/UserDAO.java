package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.User;

public class UserDAO extends BaseDAO<User> {
	//user columns
	//id
	//role_id
	//given_name
	//family_name
	//username
	//email
	//password
	//phone

	public UserDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException{
		save("insert into user values(?,?,?,?,?,?,?,?)",
				new Object[] {user.getId(), user.getRoleId(), user.getGivenName(), user.getFamilyName(),user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone()});
	}
	
	public void update(User user) throws ClassNotFoundException, SQLException{
		save("update user set role_id=?, given_name=?, family_name=?, username=?, email=?, password=?, phone=? where id=?",
				new Object[] {user.getRoleId(), user.getGivenName(), user.getFamilyName(),user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getId()});
	}
	
	public void delete(User user) throws ClassNotFoundException, SQLException{
		save("delete from user where id=?",
				new Object[] {user.getId()});
	}
	
	public List<User> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from user", new Object[] {});
	}

	@Override
	public List<User> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setRoleId(rs.getInt("role_id"));
			user.setGivenName(rs.getString("given_name"));
			user.setFamilyName(rs.getString("family_name"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			users.add(user);
		}
		
		return users;
	}

}
