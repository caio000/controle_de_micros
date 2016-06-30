package br.com.controle_de_micros.model;

public class Secretariat {
	
	private long idSecretariat;
	private String name;
	private Address address;
	private Phone phone;
	
	
	
	
	public Secretariat() {
	}
	
	public Secretariat(long idSecretariat, String name, Address address, Phone phone) {
		this.idSecretariat = idSecretariat;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public Secretariat(String name, Address address, Phone phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	
	// Métodos
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIdSecretariat() {
		return idSecretariat;
	}
	public void setIdSecretariat(long idSecretariat) {
		this.idSecretariat = idSecretariat;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Phone getPhone(){
		return phone;
	}
	public void setPhone(Phone phone){
		this.phone = phone;
	}

}
