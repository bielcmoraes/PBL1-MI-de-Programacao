package view;

import java.util.Scanner;

/**Classe reponsável por se comunicar com o usuário sobre o cardápio através da exibição de mensagens e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class CardapioView {
	
	/**Método responsável por capturar e retornar as informações utilizadas para cadastrar um prato no cardápio.
	 * 
	 * @return Vetor de strings com as informações correspondentes ao nome do prato, preço do prato, descrição do prato, categoria do prato
	 * e os produtos que compõem o prato nas posições 0,1,2,3 e 4, respectivamente.
	 */
	public static String[] cadastrarPrato() {
		System.out.println("\n");
		System.out.println("===================");
		System.out.println("= CADASTRAR PRATO =");
		System.out.println("===================");
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do prato");
		String nome = input.nextLine();
		
		System.out.println("Digite o preco do prato");
		String preco = input.nextLine();
		
		System.out.println("Digite a descricao");
		String descricao = input.nextLine();
		
		System.out.println("Digite a categoria");
		String categoria = input.nextLine();
		
		System.out.println("Digite os produtos");
		String produtos = input.nextLine();
		
		String [] info = new String[5];
		
		info[0] = nome;
		info[1] = preco;
		info[2] = descricao;
		info[3] = categoria;
		info[4] = produtos;
		
		return info;
	}
	
	/**Método responsável por capturar, do usuário, e retornar o código do prato.
	 * 
	 * @return Código do prato
	 */
	public static String buscaPrato() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("Digite o codigo do prato que deseja buscar");
		String codigo = input.nextLine();
		return codigo;
	}
	
	/**Método responsável por capturar e retornar os inputs que serão utilizados para editar um prato cadastrado no sistema.
	 * 
	 * @return Vetor de strings com as novas informações correspondentes ao nome do prato, preço do prato, descrição do prato, categoria do prato
	 * e os produtos que compõem o prato nas posições 0,1,2,3 e 4, respectivamente.
	 */
	public static String[] editarPrato() {
		System.out.println("\n");
		System.out.println("================");
		System.out.println("= EDITAR PRATO =");
		System.out.println("================");
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o novo nome do prato");
		String nome = input.nextLine();
		
		System.out.println("Digite o novo preco do prato");
		String preco = input.nextLine();
		
		System.out.println("Digite a nova descricao");
		String descricao = input.nextLine();
		
		System.out.println("Digite a nova categoria");
		String categoria = input.nextLine();
		
		System.out.println("Digite os produtos");
		String produtos = input.nextLine();
		
		String [] info = new String[5];
		
		info[0] = nome;
		info[1] = preco;
		info[2] = descricao;
		info[3] = categoria;
		info[4] = produtos;
		
		return info;
		
	}
	
	/**Método responsável por capturar e retornar as informações necessárias para excluir um prato do cardápio.
	 * 
	 * @return Método buscaPrato
	 */
	public static String excluirPrato() {
		System.out.println("\n");
		System.out.println("=================");
		System.out.println("= EXCLUIR PRATO =");
		System.out.println("=================");
		
		return buscaPrato();
		
	}

}
