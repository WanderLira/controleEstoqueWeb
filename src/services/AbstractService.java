package services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractService {
	protected static EntityManagerFactory fac = Persistence.createEntityManagerFactory("cadastroEstoque");
}
