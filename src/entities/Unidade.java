package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "unidade_id", sequenceName = "unidade_seq", allocationSize = 1)
public class Unidade extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unidade_id")
	private Long id;

	private String nome;

	public Unidade(Long id) {
		this.id = id;
	}

	public Unidade() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
