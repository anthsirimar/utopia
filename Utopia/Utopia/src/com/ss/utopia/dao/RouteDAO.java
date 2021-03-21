package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Route;

public class RouteDAO extends BaseDAO<Route> {
	//route columns
	//id
	//origin_id
	//destination_id

	public RouteDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(Route route) throws ClassNotFoundException, SQLException{
		save("insert into route values(?,?,?)",
				new Object[] {route.getId(), route.getOriginAirport().getAirportCode(),
						route.getDestinationAirport().getAirportCode()});
	}
	
	public void update(Route route) throws ClassNotFoundException, SQLException{
		save("update route set origin_id=?, destination_id=? where id=?",
				new Object[] {route.getOriginAirport().getAirportCode(),
						route.getDestinationAirport().getAirportCode(),route.getId()});
	}
	
	public void delete(Route route) throws ClassNotFoundException, SQLException{
		save("delete from route where id=?",
				new Object[] {route.getId()});
	}
	
	public List<Route> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from route where id=?",
				new Object[] {});
	}

	@Override
	public List<Route> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<Route>();
		while(rs.next()) {
			Route route = new Route();
			route.setId(rs.getInt("id"));
			
			Airport originAirport = new AirportDAO(connection).readAirportsById(rs.getString("origin_id"));
			Airport destAirport = new AirportDAO(connection).readAirportsById(rs.getString("destination_id"));
			
			route.setOriginAirport(originAirport);
			route.setDestinationAirport(destAirport);
			routes.add(route);
		}
		
		return routes;
	}

}
