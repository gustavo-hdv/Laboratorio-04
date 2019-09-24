package Main;
/**
 * Representação de um aluno:
 *  Recebe: matrícula, nome e curso.
 * 
* Laboratório de Programação 2 - Laboratório 4
*
* @author Gustavo Henrique Dias Ventura - 119110971
*/
public class Aluno {
	//Atributos
	/** Matrícula do aluno*/
	private String matricula;
	/** Nome do aluno*/
	private String nome;
	/** Curso do aluno*/
	private String curso;
	//Fim dos atributos
	
	//Construtor
	/** Construtor da classe:
	 *   Recebe matricula, nome e curso de um aluno
	 *  Tratamento de erros:
	 *   Parâmetros nulos ou vazios
	 *   
	 *  @param (String) matricula do aluno
	 *  @param (String) nome do aluno
	 *  @param (String) curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		Utilidade.validarStringNull("Não é permitido matricula nulo!", matricula);
		Utilidade.validarStringEmpty("Não é permitido matricula vazio", matricula);
		Utilidade.validarStringNull("Não é permitido nome nulo!", nome);
		Utilidade.validarStringEmpty("Não é permitido nome vazio", nome);
		Utilidade.validarStringNull("Não é permitido curso nulo!", curso);
		Utilidade.validarStringEmpty("Não é permitido curso vazio", curso);

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	//Fim do Construtor
	
	//Métodos
	/** Representação de um aluno em forma de texto
	 *   Estilo: "matricula - nome - curso"
	 * 
	 * @return (String) representação de um aluno.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}
	
	/** HashCode do atributo: "matrícula"
	 * 
	 * @return (int) hash.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/** equals do atributo: "matrícula"
	 * 
	 * @param (Object) recebe um object para comparação
	 * 
	 * @return (boolean) true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	//Fim dos métodos
}
