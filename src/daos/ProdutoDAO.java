package daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entities.Produto;

public class ProdutoDAO extends AbstractDAO<Produto> {

	public ProdutoDAO(EntityManager manager) {
		super(manager);

	}

	@Override
	public Class<Produto> entityClass() {
		return Produto.class;
	}

	public List<Produto> buscar(Produto filtro) {
		String str = "select p from Produto p where upper(nome) like upper(:nome)";
		if (filtro.getNome() == null) {
			filtro.setNome("");
		}

		Query query = manager.createQuery(str);

		query.setParameter("nome", "%" + filtro.getNome() + "%");

		return query.getResultList();
	}

}
