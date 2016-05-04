package daos;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Fornecedor;

public class FornecedorDAO extends AbstractDAO<Fornecedor> {

	public FornecedorDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Fornecedor> entityClass() {
		return Fornecedor.class;
	}
	
	
	public List<Fornecedor> buscar(Fornecedor filtro){
		String str = "select f from Fornecedor f where f.nome = :nome and f.cnpj = :cnpj and f.telefone = :telefone and f.email = :email ";
		
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getCnpj() == null){
			filtro.setCnpj("");
		}
		
		if(filtro.getTelefone() == null){
			filtro.setTelefone("");
		}
		if(filtro.getEmail() == null){
			filtro.setEmail("");
		}
		
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		query.setParameter("cnpj", "%"+filtro.getCnpj()+"%");
		query.setParameter("telefone", "%"+filtro.getTelefone()+"%");
		query.setParameter("email", "%"+filtro.getEmail()+"%");
		return query.getResultList();
	}

}
