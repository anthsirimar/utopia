package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	public AirplaneTypeDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(AirplaneType type) throws ClassNotFoundException, SQLException{
		save("insert into airplane_type values (?,?)",
				new Object[] {type.getId(), type.getMaxCapacity()});
	}
	
	public void update(AirplaneType type)throws ClassNotFoundException, SQLException{
		save("update airplane_type set max_capacity=? where id=?",
				new Object[] {type.getId(), type.getMaxCapacity()});
	}
	
	public void delete(AirplaneType type)throws ClassNotFoundException, SQLException{
		save("delete from airplane_type where id=?",
				new Object[] {type.getId()});
	}
	
	public List<AirplaneType> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from airplane_type", new Object[] {});
	}

	@Override
	public List<AirplaneType> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<AirplaneType> types = new ArrayList<AirplaneType>();
		while(rs.next()) {
			AirplaneType type = new AirplaneType();
			type.setId(rs.getInt("id"));
			type.setMaxCapacity(rs.getInt("max_capacity"));
		}
		return types;
	}

}
