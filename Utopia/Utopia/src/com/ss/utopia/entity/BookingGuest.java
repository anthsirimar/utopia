package com.ss.utopia.entity;

public class BookingGuest {
	private int bookingId;
	private String contactEmail;
	private String contactPhone;
	
//------Getters and setters-------
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contectPhone) {
		this.contactPhone = contectPhone;
	}
//--------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
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
		BookingGuest other = (BookingGuest) obj;
		if (bookingId != other.bookingId)
			return false;
		return true;
	}
}
