package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Unidade;

public class UnidadeDAO extends AbstractDAO<Unidade> {

	public UnidadeDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Unidade> entityClass() {
		return Unidade.class;
	}

	public List<Unidade> buscar(Unidade filtro) {
		String str = "select u from Unidade u where upper(nome) like upper(:nome)";
		if (filtro.getNome() == null) {
			filtro.setNome("");
		}

		Query query = manager.createQuery(str);

		query.setParameter("nome", "%" + filtro.getNome() + "%");

		return query.getResultList();
	}

}
