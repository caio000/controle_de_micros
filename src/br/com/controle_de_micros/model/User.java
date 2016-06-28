package br.com.controle_de_micros.model;

public class User {
	
	// Atributos
	
	private long registration;
	private String name;
	private String password;
	private boolean isAdmin;
	private boolean isActive;
	
	
	// Construtor
	
	public User(long registration, String name, String password, boolean isAdmin, boolean isActive) {
		this.registration = registration;
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}
	
	public User(long registration, String name, String password) {
		this(registration, name, password, false, true);
	}
	
	
	// Métodos
	
	public long getRegistration() {
		return registration;
	}
	public void setRegistration(long registration) {
		this.registration = registration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
