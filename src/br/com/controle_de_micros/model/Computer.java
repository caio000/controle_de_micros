package br.com.controle_de_micros.model;

public class Computer {

	
	private long ctis;
	private Secretariat secretariat;
	private String hostname;
	private String ip;
	private String macAddress;
	private String serial;
	private String model;
	private boolean isActive;
	
	
	// Construtores
	
	public Computer() {
		
	}
	
	public Computer(long ctis, Secretariat secretariat, String hostname, String ip, String macAddress, String serial, String model, boolean isActive) {
		this.ctis = ctis;
		this.secretariat = secretariat;
		this.hostname = hostname;
		this.ip = ip;
		this.macAddress = macAddress;
		this.serial = serial;
		this.model = model;
		this.isActive = isActive;
	}
	
	public Computer(long ctis, Secretariat secretariat, String hostname, String ip, String macAddress, String serial, String model) {
		this(ctis, secretariat, hostname, ip, macAddress, serial, model, true);
	}
	
	
	// Métodos
	
	public long getCtis() {
		return ctis;
	}
	public void setCtis(long ctis) {
		this.ctis = ctis;
	}
	public Secretariat getSecretariat() {
		return secretariat;
	}
	public void setSecretariat(Secretariat secretariat) {
		this.secretariat = secretariat;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
