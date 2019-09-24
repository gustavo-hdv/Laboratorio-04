package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.Utilidade;

/**
 * Representação de testes da classe Utilidade.
 * 
* Laboratório de Programação 2 - Lab 4
*
* @author Gustavo Henrique Dias Ventura - 119110971
*/
class testUtilidade {
	
	@Test
	void testValidarStringNull() {
		try {
			Utilidade.validarStringNull("nulo", null);
			fail("Não era esperado dar certo.");
		} catch (NullPointerException npe){
			
		}
	}

	@Test
	void testValidarStringEmpty() {
		try {
			Utilidade.validarStringEmpty("vazio", "  ");
			fail("Não era esperado dar certo.");
		} catch (IllegalArgumentException iae){
			
		}
	}

}
