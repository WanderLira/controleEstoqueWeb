package services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import daos.ProdutoDAO;
import entities.Produto;

public class ProdutoService extends AbstractService {

	public static void inserir(Produto produto) {

		EntityManager manager = fac.createEntityManager();

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(manager);
			manager.getTransaction().begin();
			produtoDAO.inserir(produto);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static void atualizar(Produto produto) {

		EntityManager manager = fac.createEntityManager();

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(manager);
			manager.getTransaction().begin();
			produtoDAO.atualizar(produto);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	public static List<Produto> listar() {
		EntityManager manager = fac.createEntityManager();
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(manager);
			produtos = produtoDAO.listar();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return produtos;
	}

	public static void remover(Produto produto) {
		EntityManager manager = fac.createEntityManager();

		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(manager);
			manager.getTransaction().begin();
			produtoDAO.remover(produto);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	public static Produto buscarPorId(Long id) {
		EntityManager manager = fac.createEntityManager();
		Produto produto = new Produto();
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO(manager);
			produto = produtoDAO.buscarPorId(id);
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return produto;
	}
	public static List<Produto> buscar(Produto filtro){
		EntityManager  manager =  fac.createEntityManager();
		List<Produto> produtos = new ArrayList<Produto>();
		try{
			ProdutoDAO produtoDAO = new ProdutoDAO(manager);
			produtos = produtoDAO.buscar(filtro);
		}
		finally{
			manager.close();
		}
		return produtos;
	}
}
