package view;

import java.util.Scanner;

import model.Fornecedor;

/**Classe reponsável por se comunicar com o usuário sobre a classe Fornecedor através da exibição de mensagens e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class FornecedorView{
	
	/**Método responsável por capturar e retornar as informações utilizadas para cadastrar um fornecedor no sistema.
	 * 
	 * @return Vetor de strings com as informações correspondentes ao nome do fornecedor, CNPJ do fornecedor, endereço do fornecedor nas posições
	 * 0,1 e 2, respectivamente.
	 */
	public static String[] cadastrarFornecedor() {
		System.out.println("\n");
		System.out.println("========================");
		System.out.println("= CADASTRAR FORNECEDOR =");
		System.out.println("========================");
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do fornecedor");
		String nome = input.nextLine();
		
		System.out.println("Digite o CNPJ do fornecedor");
		String cnpj = input.nextLine();
		
		System.out.println("Digite o endereço do fornecedor");
		String endereco = input.nextLine();
		
		String [] info = new String[3];
		
		info[0] = nome;
		info[1] = cnpj;
		info[2] = endereco;
		
		return info;
	}
	
	/**Método responsável por capturar, do usuário, e retornar o código do fornecedor.
	 * 
	 * @return Código do fornecedor
	 */
	public static String buscaFornecedor() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o codigo do fornecedor que deseja buscar");
		String codigo = input.nextLine();
		return codigo;
	}
	
	/**Método responsável por capturar e retornar os inputs que serão utilizados para editar um fornecedor cadastrado no sistema.
	 * 
	 * @return Vetor de strings com as novas informações correspondentes ao nome do fornecedor, CNPJ do fornecedor, endereço do fornecedor
	 * nas posições 0,1 e 2, respectivamente.
	 */
	public static String[] editarFornecedor() {
		System.out.println("\n");
		System.out.println("========================");
		System.out.println("= EDITAR FORNECEDOR =");
		System.out.println("========================");
		Scanner input = new Scanner(System.in);
		System.out.println("Digite um novo nome de fornecedor");
		String nome = input.nextLine();
		
		System.out.println("Digite um novo CNPJ de fornecedor");
		String cnpj = input.nextLine();
		
		System.out.println("Digite um novo endereço de fornecedor");
		String endereco = input.nextLine();
		
		String [] info = new String[3];
		
		info[0] = nome;
		info[1] = cnpj;
		info[2] = endereco;
		
		return info;
	}
	
	/**Método responsável por capturar e retornar as informações necessárias para excluir um fornecedor da lista de fornecedores.
	 * 
	 * @return Método buscaFornecedor
	 */
	public static String excluirFornecedor() {
		System.out.println("\n");
		System.out.println("======================");
		System.out.println("= EXCLUIR FORNECEDOR =");
		System.out.println("======================");
		return buscaFornecedor();
	}

}
