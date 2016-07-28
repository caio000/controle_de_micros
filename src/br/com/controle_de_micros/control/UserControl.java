package br.com.controle_de_micros.control;

import java.util.List;

import br.com.controle_de_micros.dao.UserDAO;
import br.com.controle_de_micros.database.Database;
import br.com.controle_de_micros.database.MariaDatabase;
import br.com.controle_de_micros.model.User;

public class UserControl {

	private UserDAO dao;
	
	
	public UserControl() {
		Database db = new MariaDatabase("root", "", "control");
		dao = new UserDAO(db);
	}
	
	
	// Métodos
	
	/**
	 * Essa função cadastra um novo usuario na base de dados
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/26
	 * 
	 * @param user: objeto com os dados do usuario.
	 * @return Retorna um Boolean true caso o usuario foi cadastrado com sucesso.
	 */
	public boolean insertUser(User user) {
		return dao.insert(user);
	}
	/**
	 * Essa função atualiza os dados de um usuario informado
	 * @author Caio de Freitas Adriano
	 * @since 2016/07/28
	 * @param user Objeto do tipo User que possui os dados do usuário
	 * @return Retorna um Boolean TRUE caso a alteração ocorra corretamente.
	 */
	public boolean updateUser(User user) {
		return dao.update(user);
	}
	/**
	 * Essa função "deleta" um usuário do sistema, alterando o seu status isActive para FALSE.
	 * @param user Objeto do tipo User que possui os dados o usuário.
	 * @return Retorna um boolean TRUE caso o usuário sejá deletado com sucesso.
	 */
	public boolean deleteUser(User user) {
		return dao.delete(user);
	}
	
	/**
	 * Essa função libera ou nao o acesso ao sistema para o usuario informado
	 * 
	 * @author Caio de Freitas Adriano
	 * @since 2016/06/29
	 * 
	 * @param user: objeto com os dados do usuario
	 * @return retorna um boolean True caso o usuario esteja cadastrado na base de dados
	 */
	public boolean makeLogin(User user){
		return dao.checkUser(user);
	}
	
	public List<User> listUsers() {
		return dao.listAll();
	}
	
	
	public User getUser (long idUser) {
		return dao.getUser(idUser);
	}
}
