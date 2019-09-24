package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import Main.Controller;

/**
 * Representação de testes da classe Controller.
 * 
* Laboratório de Programação 2 - Lab 4
*
* @author Gustavo Henrique Dias Ventura - 119110971
*/
class testController {
	private Controller controller = new Controller();
	
	@Test
	void testCadastrarAluno() {
		try {
			controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		} catch (Exception e) {
			fail("Não era esperado falhar.");
		}
	}

	@Test
	void testExibirAluno() {
		controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		assertEquals(controller.exibirAluno("119110971"), "Aluno: 119110971 - Gustavo Henrique - Ciência da Computação\n");
		assertEquals(controller.exibirAluno("243949144"), "Aluno não cadastrado.\n");
	}

	@Test
	void testCadastrarGrupo() {
		try {
			controller.cadastrarGrupo("TwoSouls");
		} catch (Exception e) {
			fail("Não era esperado falhar.");
		}
	}

	@Test
	void testAlocarAluno() {
		controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		controller.cadastrarGrupo("NYC");
		
		assertEquals(controller.alocarAluno("119110971", "NYC"), "ALUNO ALOCADO!\n");
		assertEquals(controller.alocarAluno("135341244", "NYC"), "Aluno não cadastrado.\n");
		assertEquals(controller.alocarAluno("135341244", "CYN"), "Aluno não cadastrado.\n");
		assertEquals(controller.alocarAluno("119110971", "CYN"), "Grupo não cadastrado.\n");
	}

	@Test
	void testImprimirGrupo() {
		controller.cadastrarGrupo("NYC");
		assertEquals(controller.imprimirGrupo("NYC"), "\nAlunos do grupo NYC: \n");
		
		controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		controller.alocarAluno("119110971", "NYC");
		assertEquals(controller.imprimirGrupo("NYC"), "\nAlunos do grupo NYC: \n* 119110971 - Gustavo Henrique - Ciência da Computação\n");
		
		assertEquals(controller.imprimirGrupo("CYN"), "Grupo não cadastrado.\n");
	}

	@Test
	void testRegistrarResposta() {
		controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		assertEquals(controller.registrarResposta("119110971"), "ALUNO REGISTRADO!\n");
		assertEquals(controller.registrarResposta("179011911"), "Aluno não cadastrado.\n");
	}

	@Test
	void testExibirAlunosRespostas() {
		assertEquals(controller.exibirAlunosRespostas(), "Nenhum aluno respondeu alguma questão no quadro!\n");
		
		controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		controller.registrarResposta("119110971");
		assertEquals(controller.exibirAlunosRespostas(), "Alunos: \n1. 119110971 - Gustavo Henrique - Ciência da Computação\n");
		
	}

	@Test
	void testExisteMatricula() {
		controller.cadastrarAluno("119110971", "Gustavo Henrique", "Ciência da Computação");
		
		assertEquals(controller.existeMatricula("119110971"), true);
		assertEquals(controller.existeMatricula("179011911"), false);
	}

	@Test
	void testExisteGrupo() {
		controller.cadastrarGrupo("NYC");
		
		assertEquals(controller.existeGrupo("NYC"), true);
		assertEquals(controller.existeGrupo("CYN"), false);
	}

}
