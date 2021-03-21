package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Airport;

public class AirportDAO extends BaseDAO<Airport> {

	public AirportDAO(Connection connection) {
		super(connection);
	}

	public void add(Airport airport) throws ClassNotFoundException, SQLException {
		save("insert into airport values (?, ?)",
				new Object[] {airport.getAirportCode(), airport.getCity()});
	}

	public void update(Airport airport) throws ClassNotFoundException, SQLException {
		save("update airport set city=? where iata_id=?",
				new Object[] {airport.getCity() ,airport.getAirportCode()});
	}
	
	public void delete(Airport airport) throws ClassNotFoundException, SQLException{
		save("delete from airport where where iata_id=?",
				new Object[] {airport.getAirportCode()});
	}

	public List<Airport> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from airport", new Object[] {});
	}
	
	public Airport readAirportsById(String id) throws ClassNotFoundException, SQLException{
		return read("select * from airport where iata_id=" + id,
				new Object[] {}).get(0);
	}
	
	@Override
	public List<Airport> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while(rs.next()) {
			Airport airport = new Airport();
			airport.setAirportCode(rs.getString("iata_id"));
			airport.setCity(rs.getString("city"));
			airports.add(airport);
		}
		return airports;
	}

}
