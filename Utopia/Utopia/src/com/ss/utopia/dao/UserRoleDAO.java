package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole> {
	//user_role columns
	//id
	//name

	public UserRoleDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(UserRole role) throws ClassNotFoundException, SQLException{
		save("insert into user_role values(?,?)",
				new Object[] {role.getId(), role.getName()});
	}
	
	public void update(UserRole role) throws ClassNotFoundException, SQLException{
		save("update user_role set name=? where id=?",
				new Object[] {role.getName(), role.getId()});
	}
	
	public void delete(UserRole role) throws ClassNotFoundException, SQLException{
		save("delete from user_role where id=?",
				new Object[] {role.getId()});
	}
	
	public List<UserRole> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from user_role", new Object[] {});
	}

	@Override
	public List<UserRole> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<UserRole> roles = new ArrayList<UserRole>();
		while(rs.next()) {
			UserRole role = new UserRole();
			role.setId(rs.getInt("id"));
			role.setName(rs.getString("name"));
			roles.add(role);
		}
		
		return roles;
	}

}
