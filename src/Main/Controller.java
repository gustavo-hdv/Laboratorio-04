package Main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um Controller
 * 
 * Laboratório de Programação 2 - Laboratório 4
 *
 * @author Gustavo Henrique Dias Ventura - 119110971
 */


public class Controller {
	//Atributos
		/** Dicionário de Alunos: acessados pela matrícula.*/
		private HashMap<String, Aluno> dicionarioMatriculas = new HashMap<>();
		/** Dicionário de Grupos: acessados pelo nome.*/
		private HashMap<String, GrupoDeEstudos> dicionarioGrupos= new HashMap<>();
		/** ArrayList de alunos que responderam questões no quadro.*/
		private ArrayList<Aluno> alunosRespondeu = new ArrayList<>(); // alunos que responderam questões no quadro
		//Fim dos atributos
		
		//Métodos
		/** Cadastra um aluno do dicionário com matrículas
		 * 
		 * @param (String) matrícula do aluno
		 * @param (String) nome do aluno
		 * @param (String) curso do aluno
		 * 
		 * @return (String) "Matrícula já cadastrada! ou Cadastro realizado!"
		 */
		public String cadastrarAluno(String matricula, String nome, String curso) {
			if (this.dicionarioMatriculas.containsKey(matricula)) {
				return "MATRÍCULA JÁ CADASTRADA!\n";
			}
			this.dicionarioMatriculas.put(matricula, new Aluno(matricula, nome, curso));
			return "CADASTRO REALIZADO!\n";
		}
		
		/** Exibe informações sobre um aluno pela sua matrícula
		 *  Estilo: "Aluno: matricula - nome - curso"
		 * 
		 * @param (String) matrícula do aluno
		 * 
		 * @return (String) "Informações do aluno ou Aluno não cadastro."
		 */
		public String exibirAluno(String matricula) {
			if (this.dicionarioMatriculas.containsKey(matricula)) {
				return "Aluno: " + this.dicionarioMatriculas.get(matricula) + System.lineSeparator();
			}
			return "Aluno não cadastrado." + System.lineSeparator();
		}
		
		/** Cadastra um grupo de estudos:
		 *   Recebe: um nome para o grupo.
		 *   
		 *   @param (String) nome do grupo.
		 *   
		 *   @return (String) "Grupo já cadastrado! ou Cadastro realizado!"
		 */
		public String cadastrarGrupo(String nomeGrupo) {
			if (existeGrupo(nomeGrupo)) {
				return "GRUPO JÁ CADASTRADO!" + System.lineSeparator();
			}
			this.dicionarioGrupos.put(nomeGrupo, new GrupoDeEstudos(nomeGrupo));
			return "CADASTRO REALIZADO!" + System.lineSeparator();
		}
		
		/** Aloca alunos para um grupo de estudos.
		 *  Recebe a matrícula de um aluno e o nome do grupo.
		 *  
		 *  @param (String) matrícula do aluno.
		 *  @param (String) nome do grupo.
		 *  
		 *  @return (String) "ALUNO ALOCADO! ou Aluno não cadastrado. ou Grupo não cadastrado".
		 */
		public String alocarAluno(String matricula, String nomeGrupo) {
			if (!(this.dicionarioMatriculas.containsKey(matricula))) {
				return "Aluno não cadastrado." + System.lineSeparator();
			}
			if (!(this.existeGrupo(nomeGrupo))) {
				return "Grupo não cadastrado." + System.lineSeparator();
			}
			
			for (String nomeChave: this.dicionarioGrupos.keySet()) {
				if (nomeGrupo.equalsIgnoreCase(nomeGrupo)) {
					this.dicionarioGrupos.get(nomeChave).cadastraAluno(this.dicionarioMatriculas.get(matricula));
					return "ALUNO ALOCADO!" + System.lineSeparator();
				}
			}
			return "ALUNO ALOCADO!" + System.lineSeparator();
		}
		
		/** Imprime a representação de um grupo de estudos:
		 *   Contém: Nome do grupo.
		 *   Contém: Nome de todos os alunos.
		 *   
		 *   @param (String) nome do grupo.
		 *   
		 *  @return (String) Representação de um grupo.
		 */
		public String imprimirGrupo(String nomeGrupo) {
			for (String nomeChave: this.dicionarioGrupos.keySet()) {
				if (nomeGrupo.equalsIgnoreCase(nomeChave)) {
					return System.lineSeparator() + this.dicionarioGrupos.get(nomeChave).toString();
				}
			}
			return "Grupo não cadastrado." + System.lineSeparator();
		}
		
		/** Cadastra alunos que responderam questões no quadro
		 * 
		 *  @param (String) matrícula do aluno
		 *  
		 *  @return (String) ALUNO REGISTRADO ou Aluno não cadastrado.
		 */
		public String registrarResposta(String matricula) {
			if (this.dicionarioMatriculas.containsKey(matricula)) {
				this.alunosRespondeu.add(this.dicionarioMatriculas.get(matricula));
				return "ALUNO REGISTRADO!" + System.lineSeparator();
			}
			return "Aluno não cadastrado." + System.lineSeparator();
		}
		
		/** Imprime a lista de alunos que responderam alguma questão no quadro
		 *  Estilo: "Alunos: 1. matrícula - nome - curso
		 *                   2.         ...
		 *                   n.         ...              "
		 *                            
		 * @return (String) (Todos os alunos que responderam alguma questão)
		 */
		public String exibirAlunosRespostas() {
			String alunos = "Alunos: \n";
			if (this.alunosRespondeu.size() == 0) {
				return "Nenhum aluno respondeu alguma questão no quadro!\n";
			}
			for (int indice=1; indice <= this.alunosRespondeu.size(); indice++)
				alunos += indice + ". " + this.alunosRespondeu.get(indice-1) + System.lineSeparator();
			return alunos;
		}
		
		/** Verifica a matricula de algum aluno existe
		 * 
		 * @param (String) matricula
		 * 
		 * @return (boolean) true or false
		 */
		public boolean existeMatricula(String matricula) {
			if (this.dicionarioMatriculas.containsKey(matricula)) {
				return true;
			}
			return false;
		}
		
		/** Verifica se o nome de alguma grupo existe
		 *  
		 *  @param (String) nome do grupo
		 *  
		 *  @return (boolean) true or false
		 */
		public boolean existeGrupo(String nomeGrupo) {
			for (String nome: this.dicionarioGrupos.keySet()) {
				if (nomeGrupo.equalsIgnoreCase(nome)) {
					return true;
				}
			}
			return false;
		}
		//Fim dos métodos
}
