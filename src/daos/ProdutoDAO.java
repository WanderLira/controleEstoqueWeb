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
		String str = "select p from Produto p where p.nome = :nome and "
				+ "p.precovenda = :precovenda and p.qtdeestoque = :qtdeestoque and "
				+ "p.id_categoria = :id_categoria and p.id_unidade = :id_unidade and "
				+ "p.id_fornecedor = :id_fornecedor order by nome";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		if(filtro.getPrecoVenda() == 0){
			filtro.setPrecoVenda(0);
		}
		
		if(filtro.getQtde_estoque() == 0){
			filtro.setQtdeEstoque(0);
		}
		if(filtro.getCategoria() == null){
			filtro.setCategoria(null);
		}
		if(filtro.getUnidade() == null){
			filtro.setUnidade(null);
		}
		
		if(filtro.getFornecedor() == null){
			filtro.setFornecedor(null);
		}
		
		if(filtro.getPrecoVenda() != 0 && filtro.getPrecoVenda() > 0){
			str+=" and p.precoVenda = :precoVenda";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getPrecoVenda() != 0 && filtro.getPrecoVenda() > 0){
			query.setParameter("preco", filtro.getPrecoVenda());
		}
		return query.getResultList();
	}

}