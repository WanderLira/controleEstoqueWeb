package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import daos.CategoriaDAO;
import entities.Categoria;

public class CategoriaService extends AbstractService {

	public static void inserir(Categoria categoria) {

		EntityManager manager = fac.createEntityManager();

		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			manager.getTransaction().begin();
			categoriaDAO.inserir(categoria);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static void atualizar(Categoria categoria) {

		EntityManager manager = fac.createEntityManager();

		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			manager.getTransaction().begin();
			categoriaDAO.atualizar(categoria);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static List<Categoria> listar() {
		EntityManager manager = fac.createEntityManager();
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			categorias = categoriaDAO.listar();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return categorias;
	}

	public static void remover(Categoria categoria) {
		EntityManager manager = fac.createEntityManager();

		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			manager.getTransaction().begin();
			categoriaDAO.remover(categoria);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public static Categoria buscarPorId(Long id) {
		EntityManager manager = fac.createEntityManager();
		Categoria categoria = new Categoria();
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			categoria = categoriaDAO.buscarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return categoria;
	}

	
	public static List<Categoria> buscar(Categoria filtro){
		EntityManager  manager =  fac.createEntityManager();
		List<Categoria> categorias = new ArrayList<Categoria>();
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			categorias = categoriaDAO.buscar(filtro);
		}
		finally{
			manager.close();
		}
		return categorias;
	}
	
}
