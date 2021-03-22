package com.ss.utopia.entity;

public class FlightSeats {
	private int id;
	private int flightId;
	private Flight flight = new Flight();
	private int firstTotal;
	private int firstReserved;
	private float firstPrice;
	private int businessTotal;
	private int businessReserved;
	private float businessPrice;
	private int economyTotal;
	private int economyReserved;
	private float economyPrice;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public int getFirstTotal() {
		return firstTotal;
	}
	public void setFirstTotal(int firstTotal) {
		this.firstTotal = firstTotal;
	}
	public int getFirstReserved() {
		return firstReserved;
	}
	public void setFirstReserved(int firstReserved) {
		this.firstReserved = firstReserved;
	}
	public float getFirstPrice() {
		return firstPrice;
	}
	public void setFirstPrice(float firstPrice) {
		this.firstPrice = firstPrice;
	}
	public int getBusinessTotal() {
		return businessTotal;
	}
	public void setBusinessTotal(int businessTotal) {
		this.businessTotal = businessTotal;
	}
	public int getBusinessReserved() {
		return businessReserved;
	}
	public void setBusinessReserved(int businessReserved) {
		this.businessReserved = businessReserved;
	}
	public float getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(float businessPrice) {
		this.businessPrice = businessPrice;
	}
	public int getEconomyTotal() {
		return economyTotal;
	}

	public void setEconomyTotal(int economyTotal) {
		this.economyTotal = economyTotal;
	}
	public int getEconomyReserved() {
		return economyReserved;
	}
	public void setEconomyReserved(int economyReerved) {
		this.economyReserved = economyReerved;
	}
	public float getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(float economyPrice) {
		this.economyPrice = economyPrice;
	}
	
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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
		FlightSeats other = (FlightSeats) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FlightSeats [id=" + id + ", flightId=" + flightId + ", firstTotal=" + firstTotal + ", firstReserved=" + firstReserved
				+ ", firstPrice=" + firstPrice + ", businessTotal=" + businessTotal + ", businessReserved="
				+ businessReserved + ", businessPrice=" + businessPrice + ", economyTotal=" + economyTotal
				+ ", economyReserved=" + economyReserved + ", economyPrice=" + economyPrice + "]";
	}
}
