package Main;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Representação de um grupo de estudos:
 *  Recebe: um conjunto de alunos.
 * 
 * Laboratório de Programação 2 - Laboratório 4
 *
 * @author Gustavo Henrique Dias Ventura - 119110971
 */
public class GrupoDeEstudos {
	//Atributos
	/** Nome do grupo de estudos */
	private String nome;
	/** Conjunto de alunos do grupo */
	private HashSet<Aluno> alunos = new HashSet<>();
	//Fim dos atributos
	
	//Construtor
	/** Construtor da classe:
	 *   Recebe um nome.
	 *  Tratamento de erros:
	 *   Nome vazio ou nulo.
	 *   
	 *  @param (String) nome do grupo.
	 */
	public GrupoDeEstudos(String nome) {
		Utilidade.validarStringNull("Não é permitido nome nulo!", nome);
		Utilidade.validarStringEmpty("Não é permitido nome vazio", nome);
		this.nome = nome;
	}
	//Fim do construtor
	
	//Métodos
	/** Cadastra um aluno do grupo
	 * 
	 * @param (Aluno) objeto aluno
	 */
	public void cadastraAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/** Representação de todos os alunos do grupo:
	 *   Estilo: "* Alunos do grupo: nome
	 *   		  * matricula - nome - curso
	 *   	 	  * 	  ...    -  ..  -  ...
	 *   		  * 	  ...    -  ..  -  ... "
	 *  
	 * @return (String) todos os alunos do grupo
	 */
	public String toString() {
		String grupo = "Alunos do grupo " + this.nome + ": " + System.lineSeparator();
		Iterator<Aluno> itr = alunos.iterator();
		while (itr.hasNext()) {
			grupo += "* " + itr.next().toString() + System.lineSeparator();
		}
		return grupo;
	}
	
	/** HashCode do atributo: nome */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/** equals do atribulo: nome */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeEstudos other = (GrupoDeEstudos) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	//Fim dos métodos
}
