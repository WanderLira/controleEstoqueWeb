package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import entities.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario> {

	public UsuarioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Usuario> entityClass() {
		return Usuario.class;
	}
	
	public Usuario efetuarLogin(String login, String senha){
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios = query.getResultList();
		if(usuarios != null && !usuarios.isEmpty()){
			return usuarios.get(0);
		}
		return null;
	}
	public List<Usuario> buscar(Usuario filtro) {
		String str = "select c from Usuario c where upper(nome) like upper(:nome)";
		if (filtro.getNome() == null) {
			filtro.setNome("");
		}

		Query query = manager.createQuery(str);

		query.setParameter("nome", "%" + filtro.getNome() + "%");

		return query.getResultList();
	}
	

}
