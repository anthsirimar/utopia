package com.ss.utopia.entity;

public class Route {
	private Integer id;
	private Airport originAirport;
	private Airport destinationAirport;
	
//-------Getters and setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
//----------------------
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Route other = (Route) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport
				+ "]";
	}
	


	
	

}
