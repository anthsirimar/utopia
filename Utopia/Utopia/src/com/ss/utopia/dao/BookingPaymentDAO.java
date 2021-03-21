package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {
	// booking_payment column names
	// booking_id
	// stripe_id
	// refunded

	public BookingPaymentDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public void add(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("insert into booking_payment values(?,?,?)",
				new Object[] { payment.getBookingId(), payment.getStripeId(), payment.isRefunded() });
	}

	public void update(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("update booking_payment set stripe_id=?, refunded=? where booking_id=?",
				new Object[] { payment.getStripeId(), payment.isRefunded(), payment.getBookingId() });
	}

	public void delete(BookingPayment payment) throws ClassNotFoundException, SQLException {
		save("delete from booking_payment where booking_id=?",
				new Object[] {payment.getBookingId()});
	}

	public List<BookingPayment> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from booking_payment", new Object[] {});
	}

	@Override
	public List<BookingPayment> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<BookingPayment> payments = new ArrayList<BookingPayment>();
		while(rs.next()) {
			BookingPayment payment = new BookingPayment();
			payment.setBookingId(rs.getInt("booking_id"));
			payment.setStripeId(rs.getString("stripe_id"));
			payment.setRefunded(rs.getBoolean("refunded"));
			payments.add(payment);
		}
		return payments;
	}

}
