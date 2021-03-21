package com.ss.utopia.entity;

public class Flight {
	private int id;
	
	private int routeId;
	private Route route;
	
	private int airplaneId;
	private String departureTime;
	private int reservedSeats;
	private float seatPrice;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(int airplaneId) {
		this.airplaneId = airplaneId;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public float getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Flight other = (Flight) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
