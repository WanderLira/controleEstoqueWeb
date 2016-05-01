package services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import daos.UsuarioDAO;
import entities.Usuario;

public class UsuarioService extends AbstractService {

	public static Usuario efetuarLogin(String login, String senha){
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		return usuarioDAO.efetuarLogin(login, senha);
	}
	public static void inserir(Usuario usuario) {

		EntityManager manager = fac.createEntityManager();

		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
			manager.getTransaction().begin();
			usuarioDAO.inserir(usuario);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static void atualizar(Usuario usuario) {

		EntityManager manager = fac.createEntityManager();

		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
			manager.getTransaction().begin();
			usuarioDAO.atualizar(usuario);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static List<Usuario> listar() {
		EntityManager manager = fac.createEntityManager();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
			usuarios = usuarioDAO.listar();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return usuarios;
	}

	public static void remover(Usuario usuario) {
		EntityManager manager = fac.createEntityManager();

		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
			manager.getTransaction().begin();
			usuarioDAO.remover(usuario);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public static Usuario buscarPorId(Long id) {
		EntityManager manager = fac.createEntityManager();
		Usuario usuario = new Usuario();
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
			usuario = usuarioDAO.buscarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return usuario;
	}
	public static List<Usuario> buscar(Usuario filtro){
		EntityManager  manager =  fac.createEntityManager();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
			usuarios = usuarioDAO.buscar(filtro);
		}
		finally{
			manager.close();
		}
		return usuarios;
	}
	
}
