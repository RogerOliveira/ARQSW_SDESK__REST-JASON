package br.usjt.arqsw.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Usuario;

/**
 * 
 * @author roger.oliveira-816117932
 *
 */
@Repository
public class UsuarioDAO {

	@PersistenceContext
	EntityManager manager;

	public String buscarLogin(Usuario usuario) throws Exception {
		Query query = manager
				.createQuery("select u from Usuario u where u.username = :username and u.password = :password");
		query.setParameter("username", usuario.getUsername());
		query.setParameter("password", usuario.getPassword());
		return query.getSingleResult() != null ? "Valido" : "Invalido";
	}

}
