package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Categoria;

public class CategoriaDAO extends AbstractDAO<Categoria> {

	public CategoriaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Categoria> entityClass() {
		return Categoria.class;
	}

	public List<Categoria> buscar(Categoria filtro) {
		String str = "select c from Categoria c where upper(nome) like upper(:nome)";
		if (filtro.getNome() == null) {
			filtro.setNome("");
		}

		Query query = manager.createQuery(str);

		query.setParameter("nome", "%" + filtro.getNome() + "%");

		return query.getResultList();
	}

}
