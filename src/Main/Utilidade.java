package Main;

/**
 * Utilidades para auxílio na validação.
 * 
 * Laboratório de Programação 2 - Laboratório 4
 *
 * @author Gustavo Henrique Dias Ventura - 119110971
 */

public class Utilidade {
	/** Verifica se um valor é nulo
	 *  Recebe uma mensagem para a exceção
	 *  
	 *  @param (String) mensagem
	 *  @param (String) valor
	 */
	public static void validarStringNull(String mensagem, String valor) {
		if (valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
	/** Verifica se um valor é vazio
	 *  Recebe uma mensagem para a exceção
	 *  
	 *  @param (String) mensagem
	 *  @param (String) valor
	 */
	public static void validarStringEmpty(String mensagem, String valor) {
		if (valor.trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
