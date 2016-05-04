package services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import daos.FornecedorDAO;
import entities.Fornecedor;

public class FornecedorService extends AbstractService {

	public static void inserir(Fornecedor fornecedor) {

		EntityManager manager = fac.createEntityManager();

		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO(manager);
			manager.getTransaction().begin();
			fornecedorDAO.inserir(fornecedor);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static void atualizar(Fornecedor fornecedor) {

		EntityManager manager = fac.createEntityManager();

		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO(manager);
			manager.getTransaction().begin();
			fornecedorDAO.atualizar(fornecedor);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static List<Fornecedor> listar() {
		EntityManager manager = fac.createEntityManager();
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO(manager);
			fornecedores = fornecedorDAO.listar();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return fornecedores;
	}

	public static void remover(Fornecedor fornecedor) {
		EntityManager manager = fac.createEntityManager();

		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO(manager);
			manager.getTransaction().begin();
			fornecedorDAO.remover(fornecedor);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public static Fornecedor buscarPorId(Long id) {
		EntityManager manager = fac.createEntityManager();
		Fornecedor fornecedor = new Fornecedor();
		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO(manager);
			fornecedor = fornecedorDAO.buscarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return fornecedor;
	}

	
	public static List<Fornecedor> buscar(Fornecedor filtro){
		EntityManager  manager =  fac.createEntityManager();
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try{
			FornecedorDAO fornecedorDAO = new FornecedorDAO(manager);
			fornecedores = fornecedorDAO.buscar(filtro);
		}
		finally{
			manager.close();
		}
		return fornecedores;
	}
	
}
