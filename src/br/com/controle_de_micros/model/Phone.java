package br.com.controle_de_micros.model;

public class Phone {
	
	// Atributos
	
	private long idPhone;
	private String number;
	
	
	
	// Contrutor
	
	public Phone(long idPhone, String number) {
		this.idPhone = idPhone;
		this.number = number;
	}
	
	public Phone(String number){
		this.number = number;
	}
	
	
	
	// Métodos
	
	public long getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(long idPhone) {
		this.idPhone = idPhone;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
