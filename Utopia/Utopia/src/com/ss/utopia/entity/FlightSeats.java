package com.ss.utopia.entity;

public class FlightSeats {
	private int id;
	private Flight flight = new Flight();
	private int firstTotal;
	private int firstReserved;
	private int firstPrice;
	private int businessTotal;
	private int businessReserved;
	private int businessPrice;
	private int economyTotal;
	private int economyReserved;
	private int economyPrice;
	
	
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
	public int getFirstPrice() {
		return firstPrice;
	}
	public void setFirstPrice(int firstPrice) {
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
	public int getBusinessPrice() {
		return businessPrice;
	}
	public void setBusinessPrice(int businessPrice) {
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
	public int getEconomyPrice() {
		return economyPrice;
	}
	public void setEconomyPrice(int economyPrice) {
		this.economyPrice = economyPrice;
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
		return "FlightSeats [id=" + id + ", firstTotal=" + firstTotal + ", firstReserved=" + firstReserved
				+ ", firstPrice=" + firstPrice + ", businessTotal=" + businessTotal + ", businessReserved="
				+ businessReserved + ", businessPrice=" + businessPrice + ", economyTotal=" + economyTotal
				+ ", economyReserved=" + economyReserved + ", economyPrice=" + economyPrice + "]";
	}
}
