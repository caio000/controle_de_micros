package br.com.controle_de_micros.model;

public class Address {

	// Atributos
	
	private long idAddress;
	private String publicPlace;
	private String neighborhood;
	private long number;
	
	
	
	// Construtor
	
	public Address(long idAddress, String publicPlace, String neighborhood, long number) {
		this.idAddress = idAddress;
		this.publicPlace = publicPlace;
		this.neighborhood = neighborhood;
		this.number = number;
	}
	
	public Address (String publicPlace, String neighborhood, long number) {
		this.publicPlace = publicPlace;
		this.neighborhood = neighborhood;
		this.number = number;
	}
	
	
	
	// Métodos
	
	public long getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(long idAddress) {
		this.idAddress = idAddress;
	}
	public String getPublicPlace() {
		return publicPlace;
	}
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
}
