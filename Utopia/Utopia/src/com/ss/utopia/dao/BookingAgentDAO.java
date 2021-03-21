package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingAgent;

public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(BookingAgent agent) throws ClassNotFoundException, SQLException{
		save("insert into booking_agent values(?,?)",
				new Object[] {agent.getBookingId(), agent.getAgentId()});
	}
	
	public void update(BookingAgent agent) throws ClassNotFoundException, SQLException{
		save("update booking_agent set agent_id-? where booking_id=?",
				new Object[] {agent.getAgentId(), agent.getBookingId()});
	}
	
	public void delete(BookingAgent agent) throws ClassNotFoundException, SQLException{
		save("delete from booking_agent where booking_id=?",
				new Object[] {agent.getBookingId()});
	}
	
	public List<BookingAgent> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from booking_agent", new Object[] {});
	}

	@Override
	public List<BookingAgent> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingAgent> agents = new ArrayList<>();
		while(rs.next()) {
			BookingAgent agent = new BookingAgent();
			agent.setBookingId(rs.getInt("booking_id"));
			agent.setAgentId(rs.getInt("agent_id"));
			agents.add(agent);
		}
		
		return agents;
	}

}
