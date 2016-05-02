package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import daos.UnidadeDAO;
import entities.Unidade;

public class UnidadeService extends AbstractService {

	public static void inserir(Unidade unidade) {

		EntityManager manager = fac.createEntityManager();

		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO(manager);
			manager.getTransaction().begin();
			unidadeDAO.inserir(unidade);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static void atualizar(Unidade unidade) {

		EntityManager manager = fac.createEntityManager();

		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO(manager);
			manager.getTransaction().begin();
			unidadeDAO.atualizar(unidade);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static List<Unidade> listar() {
		EntityManager manager = fac.createEntityManager();
		List<Unidade> unidades = new ArrayList<Unidade>();
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO(manager);
			unidades = unidadeDAO.listar();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return unidades;
	}

	public static void remover(Unidade unidade) {
		EntityManager manager = fac.createEntityManager();

		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO(manager);
			manager.getTransaction().begin();
			unidadeDAO.remover(unidade);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public static Unidade buscarPorId(Long id) {
		EntityManager manager = fac.createEntityManager();
		Unidade unidade = new Unidade();
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO(manager);
			unidade = unidadeDAO.buscarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return unidade;
	}

	
	public static List<Unidade> buscar(Unidade filtro){
		EntityManager  manager =  fac.createEntityManager();
		List<Unidade> unidades = new ArrayList<Unidade>();
		try{
			UnidadeDAO unidadeDAO = new UnidadeDAO(manager);
			unidades = unidadeDAO.buscar(filtro);
		}
		finally{
			manager.close();
		}
		return unidades;
	}
	
}
