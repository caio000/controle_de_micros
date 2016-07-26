package br.com.controle_de_micros.control;

import br.com.controle_de_micros.model.User;

public final class SessionControl {

	// ATRIBUTOS
	
	private static final SessionControl INSTANCE = new SessionControl();
	private static User USER;
	
	// CONSTRUTOR
	public SessionControl() {
		
	}
	
	
	// M�TODOS
	public static SessionControl getInstance() {
		return INSTANCE;
	}
	
	public void setUser (User user) {
		SessionControl.USER = user;
	}
	
	public User getUser () {
		return USER;
	}
}
