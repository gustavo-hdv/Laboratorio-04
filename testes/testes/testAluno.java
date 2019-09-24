package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Aluno;

/**
 * Representação de testes da classe Aluno
 * 
 * Laboratório de Programação 2 - Laboratório 4
 *
 * @author Gustavo Henrique Dias Ventura - 119110971
 */

class testAluno {
	private static Aluno aluno1 = new Aluno("119110971", "Gustavo", "Ciência da Computação");
	private static Aluno aluno2 = new Aluno("999999999", "TwoSouls", "ProPlayer");
	private static Aluno aluno3 = new Aluno("119110971", "Ovatsug", "Computer Science");
	
	@SuppressWarnings("unused")
	@Test
	public void construtor() {
		try {
			Aluno aluno4 = new Aluno("119110971", "Gustavo", "CC");
		} catch (Exception e) {
			fail("Não era esperado nenhum error.");
		}
	}
	
	@SuppressWarnings("unused")
	@Test
	 public void testNull() {
		try {
			Aluno aluno1 = new Aluno(null, "Gustavo", "Ciência da Computação");
			fail("Era esperado exceção ao passar matrícula nulo.");
		} catch (NullPointerException npe) {
			
		}
		try {
			Aluno aluno1 = new Aluno("119110971", null, "Ciência da Computação");
			fail("Era esperado exceção ao passar nome nulo.");
		} catch (NullPointerException npe) {
			
		}
		try {
			Aluno aluno1 = new Aluno("119110971", "Gustavo", null);
			fail("Era esperado exceção ao passar curso nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	@SuppressWarnings("unused")
	@Test
	public void testEmpty() {
		try {
			Aluno aluno1 = new Aluno(" ", "Gustavo", "Ciência da Computação");
			fail("Era esperado exceção ao passar matrícula vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
		try {
			Aluno aluno1 = new Aluno("119110971", "", "Ciência da Computação");
			fail("Era esperado exceção ao passar nome vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
		try {
			Aluno aluno1 = new Aluno("119110971", "Gustavo", "");
			fail("Era esperado exceção ao passar curso vazio.");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	@Test
	void testToString() {
		assertEquals(aluno1.toString(), "119110971 - Gustavo - Ciência da Computação");
		assertNotEquals(aluno1.toString(), aluno3.toString());
	}

	@Test
	void testEqualsObject() {
		assertEquals(aluno1, aluno3);
		assertNotEquals(aluno2, aluno3);
	}
	
	@Test
	void testHashCode() {
		assertEquals(aluno1.hashCode(), aluno3.hashCode());
	}

}
