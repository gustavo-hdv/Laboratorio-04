package Main;

import java.util.Scanner;

/**
 * Representação de um controle de alunos
 * 
 * Laboratório de Programação 2 - Laboratório 4
 *
 * @author Gustavo Henrique Dias Ventura - 119110971
 */

public class ControleDeAlunos {
	/** Controlador com armazenamento dos alunos e grupos de estudo*/
	private static Controller controller = new Controller();
	/** Scanner para leitura de dados*/
	private static Scanner sc = new Scanner(System.in);
	
	/** Imprime um menu e lê os dados do usuário.
	 * 
	 * @param (String) menu para interação com usuário.
	 * 
	 * @return (String) dados lidos.
	 */
	public static String ler(String menu) {
		System.out.print(menu);
		String entrada = sc.nextLine();
		return entrada;
	}
	
	/** Trata os erros encontrados
	 *  Recebe uma mensagem de error (nome do valor)
	 *  Recebe uma variável para vericação (nulo ou vazio)
	 *  
	 *  @param (String) mensagem.
	 *  @param (String) valor.
	 *  
	 *  @return (boolean) true or false
	 */
	public static boolean tratarExcecao(String mensagem, String valor) {
		boolean erro = false;
		try {
			Utilidade.validarStringNull("Não é permitido " + mensagem + " nulo!", valor);
			Utilidade.validarStringEmpty("Não é permitido " + mensagem + " vazio!", valor);
		} catch (NullPointerException npe) {
			System.out.println(npe);
			erro = true;
		} catch (IllegalArgumentException iae) {
			System.out.println(iae);
			erro = true;
		}
		return erro;
	}
	
	//Main.
	/** (Main) para interação com o usuário*/
	public static void main(String args[]) {
		final String menu = "(C)adastrar Aluno\n" + 
			"(E)xibir Aluno\n" + 
			"(N)ovo Grupo\n" + 
			"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
			"(R)egistrar Aluno que Respondeu\n" + 
			"(I)mprimir Alunos que Responderam\n" + 
			"(O)ra, vamos fechar o programa!\n" + 
			"\n" + 
			"Opção> ";
			
		while (true) {
			String comando = ler(menu);

			if (comando.equals("C")) {
				String matricula = ler("Matrícula: ");
				if (tratarExcecao("matrícula", matricula)) break;
				
				String nome = ler("Nome: ");
				if (tratarExcecao("nome", nome)) break;
				
				String curso = ler("Curso: ");
				if (tratarExcecao("curso", curso)) break;
				
				System.out.println(controller.cadastrarAluno(matricula, nome, curso));

			} else if (comando.equals("E")) {
				String matricula = ler("Matrícula: ");
				System.out.println(controller.exibirAluno(matricula));

			} else if (comando.equals("N")) {
				String nomeGrupo = ler("Grupo: ");
				if (tratarExcecao("nome do grupo", nomeGrupo)) break;
				
				System.out.println(controller.cadastrarGrupo(nomeGrupo));

			} else if (comando.equals("A")) {
				String acao = ler("(A)locar Aluno ou (I)mprimir Grupo? ");
				if (acao.equals("A")) {
					String matricula = ler("Matrícula: ");
					if (!(controller.existeMatricula(matricula))) {
						System.out.println("Aluno não cadastrado.\n");
						continue;
					}
					
					String nomeGrupo = ler("Grupo: ");
					if (!(controller.existeGrupo(nomeGrupo))) {
						System.out.println("Grupo não cadastrado.\n");
						continue;
					}
					System.out.println(controller.alocarAluno(matricula, nomeGrupo));
					
				} else if (acao.equals("I")) {
					String nomeGrupo = ler("Grupo: ");
					System.out.println(controller.imprimirGrupo(nomeGrupo));
					
				} else {
					System.out.println("Comando inválido!\n");
				}
				
			} else if (comando.equals("R")) {
				String matricula = ler("Matrícula: ");
				System.out.println(controller.registrarResposta(matricula));
				
			} else if (comando.equals("I")) {
				System.out.println(controller.exibirAlunosRespostas());	
				
			} else if (comando.equals("O")) {
				System.out.println("Sistema desligado!");
				break;
				
			} else {
				System.out.println("!!!Comando inválido!!!\n");
			}
		}
	}
	//Fim do Main.
}
