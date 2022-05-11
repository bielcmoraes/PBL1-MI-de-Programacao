package view;

import java.util.Scanner;

/**Classe reponsável por se comunicar com o usuário sobre o login, através da exibição de mensagens e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class LoginView {
	
	/**Método responsável por capturar e retornar as informações utilizadas para logar no sistema.
	 * 
	 * @return Vetor de strings com as informações correspondentes ao login e senha nos index's 0 e 1, respectivamente.
	 */
	public static String[] logar() {
		System.out.println("\n");
		System.out.println("=========");
		System.out.println("= LOGIN =");
		System.out.println("=========");
		Scanner input = new Scanner(System.in);
		System.out.println("Login: ");
		String login = input.nextLine();
		System.out.println("\nSenha: ");
		String senha = input.nextLine();
		
		String validacao[] = new String[2];
		validacao[0] = login;
		validacao[1] = senha;
		return validacao;
	}
}
