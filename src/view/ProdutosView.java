package view;

import java.util.Scanner;

/**Classe reponsável por se comunicar com o usuário sobre os produtos, através da exibição de mensagens e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class ProdutosView {
	
	/**Método responsável por capturar e retornar as informações utilizadas para cadastrar um produto no sistema.
	 * 
	 * @return Vetor de strings com as informações correspondentes ao nome do produto, preço do produto e validade do produto nas posições
	 * 0,1 e 2, respectivamente.
	 */
	public static String[] cadastrarProduto() {
		System.out.println("\n");
		System.out.println("=====================");
		System.out.println("= CADASTRAR PRODUTO =");
		System.out.println("=====================");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do produto");
		String nome = input.nextLine();
		
		System.out.println("Digite o preco do produto");
		String preco = input.nextLine();
		
		System.out.println("Digite a quantidade do produto (Ex: 10 kg)");
		String quantidade = input.nextLine();
		
		System.out.println("Digite a validade do produto");
		String validade = input.nextLine();
		
		System.out.println("Digite os fornecedores do produto");
		String fornecedores = input.nextLine();
		
		String [] info = new String[5];
		
		info[0] = nome;
		info[1] = preco;
		info[2] = quantidade;
		info[3] = validade;
		info[4] = fornecedores;
		
		return info;
	}
	
	/**Método responsável por capturar, do usuário, e retornar o código do produto.
	 * 
	 * @return Código do produto
	 */
	public static String buscaProduto() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o codigo do produto que deseja buscar");
		String codigo = input.nextLine();
		return codigo;
	}
	
	/**Método responsável por capturar e retornar os inputs que serão utilizados para editar um produto previamente cadastrado no sistema.
	 * 
	 * @return Vetor de strings com as novas informações correspondentes ao nome do produto, preço do produto, validade do produto
	 * nas posições 0,1 e 2, respectivamente.
	 */
	public static String[] editarProduto() {
		System.out.println("\n");
		System.out.println("==================");
		System.out.println("= EDITAR PRODUTO =");
		System.out.println("==================");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite um novo nome de produto");
		String nome = input.nextLine();
		
		System.out.println("Digite um novo preco de produto");
		String preco = input.nextLine();
		
		System.out.println("Digite uma nova quantidade de produto");
		String quantidade = input.nextLine();
		
		System.out.println("Digite uma nova validade de produto");
		String validade = input.nextLine();
		
		System.out.println("Digite os novos fornecedores do produto");
		String fornecedores = input.nextLine();
		
		String [] info = new String[5];
		
		info[0] = nome;
		info[1] = preco;
		info[2] = quantidade;
		info[3] = validade;
		info[4] = fornecedores;
		
		return info;
	}
	
	/**Método responsável por capturar e retornar as informações necessárias para excluir um produto da lista de produtos.
	 * 
	 * @return Método buscaProduto
	 */
	public String excluirProduto() {
		System.out.println("\n");
		System.out.println("===================");
		System.out.println("= EXCLUIR PRODUTO =");
		System.out.println("===================");
		return buscaProduto();
		
	}

}
