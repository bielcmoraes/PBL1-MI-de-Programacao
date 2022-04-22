package view;

import java.util.Scanner;

/**Classe reponsável por se comunicar com o usuário do sistema sobre as opções dos sub-menus, através da exibição de mensagens e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class SubMenuView {
	
	/**Método responsável por capturar e retornar a escolha do usuário do sistema em relação aos menus de gerenciamentos.
	 * 
	 * @return String correspondentes a escolha do usuário.
	 */
	public static String telaMenuGerenciamentos() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("=========================");
		System.out.println("= MENU DE GERENCIAMENTO =");
		System.out.println("=========================");
		System.out.println("Digite 1 para cadastrar");
		System.out.println("Digite 2 para editar");
		System.out.println("Digite 3 para excluir");
		System.out.println("Digite 4 para sair");
		String resposta = input.nextLine();
		return resposta;
	}
	
	/**Método responsável por exibir mensagem de erro ao usuário do sistema.
	 * 
	 */
	public static void erroGerenciamentos() {
		System.out.println("Operacao não concluida!");
		System.out.println("Tente novamente!");
	}
	
	/**Método responsável por capturar e retornar a escolha do usuário do sistema em relação ao menu de listagem.
	 * 
	 * @return String correspondentes a escolha do usuário.
	 */
	public static String telaMenuListagem() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("====================");
		System.out.println("= MENU DE LISTAGEM =");
		System.out.println("====================");
		System.out.println("Digite 1 para mostrar o cardapio");
		System.out.println("Digite 2 para listar produtos");
		System.out.println("Digite 3 para listar vendas");
		System.out.println("Digite 4 para listar fornecedores");
		System.out.println("Digite 5 para listar usuarios");
		System.out.println("Digite 7 para sair");
		String resposta = input.nextLine();
		return resposta;
		
	}
}
