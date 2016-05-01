package daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entities.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> {

	protected EntityManager manager;

	public AbstractDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void inserir(T entity) {
		manager.persist(entity);
	}

	public void atualizar(T entity) {
		manager.merge(entity);
	}

	public void remover(T entity) {
		entity = manager.find(entityClass(), entity.getId());
		manager.remove(entity);

	}

	public T buscarPorId(Long id) {
		return manager.find(entityClass(), id);
	}

	public List<T> listar() {
		Query query = manager.createQuery("select p from "
				+ entityClass().getSimpleName() + " p");
		return  query.getResultList();
	}

	public abstract Class<T> entityClass();

}
