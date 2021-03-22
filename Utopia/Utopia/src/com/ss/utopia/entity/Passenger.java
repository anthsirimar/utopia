package com.ss.utopia.entity;

public class Passenger {
	private int id;
	private int bookingId;
	private String givenName;
	private String familyName;
	private String dateOfBirth;
	private String gender;
	private String address;
	private String seatType;
	private Booking booking;


	// ------Getters and setters-------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

//-----------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", bookingId=" + bookingId + ", givenName=" + givenName + ", familyName="
				+ familyName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address
				+ ", seatType=" + seatType + ", booking=" + booking + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
