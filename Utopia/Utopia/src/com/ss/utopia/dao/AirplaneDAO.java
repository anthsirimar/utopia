package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airplane;

public class AirplaneDAO extends BaseDAO<Airplane> {

	public AirplaneDAO(Connection connection) {
		super(connection);
	}
	
	public void add(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("insert into airplane values (?, ?)",
				new Object[] {airplane.getId() ,airplane.getTypeId()});
	}

	public void update(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("update airplane set type_id=? where id=?",
				new Object[] {airplane.getTypeId() ,airplane.getId()});
	}
	
	public void delete(Airplane airplane) throws ClassNotFoundException, SQLException{
		save("delete from airplane where where id=?",
				new Object[] {airplane.getId()});
	}

	public List<Airplane> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from airplane", new Object[] {});
	}
	
	@Override
	public List<Airplane> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<Airplane>();
		while(rs.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(rs.getInt("id"));
			airplane.setTypeId(rs.getInt("type_id"));
			airplanes.add(airplane);
		}
		return airplanes;
	}

}
