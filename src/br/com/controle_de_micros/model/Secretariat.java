package br.com.controle_de_micros.model;

public class Secretariat {
	
	private long idSecretariat;
	private String name;
	private Address address;
	private Phone phone;
	
	
	
	
	
	
	
	
	
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
