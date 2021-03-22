package com.ss.utopia.entity;

public class Flight {
	private int id;
	
	private int routeId;
	private Route route;
	
	private int airplaneId;
	private String departureTime;
	private String arrivalTime;
	
	private FlightSeats seats;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
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
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public void setSeats(FlightSeats seats) {
		this.seats = seats;
	}
	
	public FlightSeats getSeats() {
		return seats;
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
	
	
	public String departureDate() {
		return departureTime.split(" ")[0];
	}
	public String departureTime() {
		return departureTime.split(" ")[1];
	}
	
	public String arrivalDate() {
		return arrivalTime.split(" ")[0];
	}
	public String arrivalTime() {
		return arrivalTime.split(" ")[1];
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", routeId=" + routeId + ", route=" + route + ", airplaneId=" + airplaneId
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", seats=" + seats + "]";
	}
}
