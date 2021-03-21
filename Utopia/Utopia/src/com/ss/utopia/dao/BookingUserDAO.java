package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	//booking_user columns
	//booking_id
	//user_id
	
	public BookingUserDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(BookingUser user) throws ClassNotFoundException, SQLException{
		save("insert into booking_user values(?,?)",
				new Object[] {user.getBookingId(), user.getUserId()});
	}
	
	public void update(BookingUser user) throws ClassNotFoundException, SQLException{
		save("update booking_user set user_id=? where booking_id=?",
				new Object[] {user.getUserId(), user.getBookingId()});
	}
	
	public void delete(BookingUser user) throws ClassNotFoundException, SQLException{
		save("delete from booking_user where booking_id=?",
				new Object[] {user.getBookingId()});
	}
	
	public List<BookingUser> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from booking_id", new Object[] {});
	}

	@Override
	public List<BookingUser> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingUser> users = new ArrayList<BookingUser>();
		while(rs.next()) {
			BookingUser user = new BookingUser();
			user.setBookingId(rs.getInt("booking_id"));
			user.setUserId(rs.getInt("user_id"));
			users.add(user);
		}
		return users;
	}

}
