package com.ss.utopia.entity;

public class FlightBooking {
	private int flightId;
	private int bookingId;
	
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + flightId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightBooking other = (FlightBooking) obj;
		if (bookingId != other.bookingId)
			return false;
		if (flightId != other.flightId)
			return false;
		return true;
	}
}
