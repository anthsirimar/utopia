package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	public BookingGuestDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public void add(BookingGuest guest) throws ClassNotFoundException, SQLException{
		save("insert into booking_guest values(?,?,?)",
				new Object[] {guest.getBookingId(), guest.getContactEmail(), guest.getContactPhone()});
	}
	
	public void update(BookingGuest guest) throws ClassNotFoundException, SQLException{
		save("update booking_guest set contact_email=?, contact_phone=? where booking_id=?",
				new Object[] {guest.getContactEmail(), guest.getContactPhone(), guest.getBookingId()});
	}
	
	public void delete(BookingGuest guest) throws ClassNotFoundException, SQLException{
		save("delete from booking_guest where booking_id=?",
				new Object[] {guest.getBookingId()});
	}
	
	public List<BookingGuest> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from booking_guest", new Object[] {});
	}

	@Override
	public List<BookingGuest> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingGuest> guests = new ArrayList<>();
		while(rs.next()) {
			BookingGuest guest = new BookingGuest();
			guest.setBookingId(rs.getInt("booking_id"));
			guest.setContactEmail(rs.getString("contact_email"));
			guest.setContactPhone(rs.getString("contact_phone"));
			guests.add(guest);
		}
		return guests;
	}

}
