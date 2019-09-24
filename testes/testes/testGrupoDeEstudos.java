package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import Main.GrupoDeEstudos;
import Main.Aluno;
/**
 * Representação de testes da classe GrupoDeEstudos.
 * 
* Laboratório de Programação 2 - Laboratório 4
*
* @author Gustavo Henrique Dias Ventura - 119110971
*/


class testGrupoDeEstudos {
	private static GrupoDeEstudos grupo1 = new GrupoDeEstudos("Inocentes");
	private static GrupoDeEstudos grupo2 = new GrupoDeEstudos("Displicentes");
	private static GrupoDeEstudos grupo3 = new GrupoDeEstudos("Culpados");
	private static GrupoDeEstudos grupo4 = new GrupoDeEstudos("Inocentes");
	
	@Test
	void testHashCode() {
		assertEquals(grupo1.hashCode(), grupo4.hashCode());
	}

	@SuppressWarnings("unused")
	@Test
	public void testConstrutor() {
		try {
			GrupoDeEstudos grupo5 = new GrupoDeEstudos("Estudando");
		} catch (Exception e) {
			fail("Não era esperado falhar.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testNull() {
		try {
			GrupoDeEstudos grupo1 = new GrupoDeEstudos(null);
			fail("Era esperado uma exceção de nome nulo.");
		} catch (NullPointerException npe) {
			
		}
	}

	@SuppressWarnings("unused")
	@Test
	public void testEmpty() {
		try {
			GrupoDeEstudos grupo3 = new GrupoDeEstudos(" ");
			fail("Era esperado um exceção de nome vazio");
		} catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testCadastraAluno() {
		HashSet<Aluno> alunos = new HashSet<>();
		Aluno aluno1 = new Aluno("119110971", "Gustavo", "Ciência da Computação");
		alunos.add(aluno1);
		assertEquals(alunos.contains(aluno1), true);
		
	}

	@Test
	void testToString() {
		assertEquals(grupo1.toString(), "Alunos do grupo Inocentes: \n");
		assertEquals(grupo1.toString(), grupo4.toString());
	}

	@Test
	void testEqualsObject() {
		assertEquals(grupo1, grupo4);
		assertNotEquals(grupo2, grupo3);
	}

}
