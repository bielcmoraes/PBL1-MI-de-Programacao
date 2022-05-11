package view;

import java.util.Scanner;

/**Classe reponsável por se comunicar com o usuário do sistema sobre as vendas, através da exibição de mensagens e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class VendaView {
	
	/**Método responsável por capturar e retornar as informações utilizadas para cadastrar uma venda no sistema.
	 * 
	 * @return Vetor de strings com as informações correspondentes a data da venda, horário da venda, pratos vendidos e método de pagamento nas posições
	 * 0, 1, 2 e 3, respectivamente.
	 */
	public static String[] cadastrarVenda() {
		System.out.println("\n");
		System.out.println("===================");
		System.out.println("= CADASTRAR VENDA =");
		System.out.println("===================");
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite os pratos da venda");
		String pratos = input.nextLine();
		
		System.out.println("Digite o metodo de pagamento");
		String metodoDePagamento = input.nextLine();
		
		String [] info = new String[2];
		
		info[0] = pratos;
		info[1] = metodoDePagamento;
		
		return info;
	}
	
	/**Método responsável por capturar, do usuário, e retornar o id de uma venda.
	 * 
	 * @return Código da venda
	 */
	public static String buscaVenda() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o codigo da venda que deseja buscar");
		String codigo = input.nextLine();
		return codigo;
	}
	
	/**Método responsável por capturar e retornar os inputs que serão utilizados para editar uma venda da lista de usuários.
	 * 
	 * @return Vetor de strings com as novas informações correspondentes a data da venda, horário da venda, pratos vendidos e método de pagamento
	 * nas posições 0, 1, 2 e 3, respectivamente.
	 */
	public static String[] editarVenda() {
		System.out.println("\n");
		System.out.println("================");
		System.out.println("= EDITAR VENDA =");
		System.out.println("================");
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a nova data da venda");
		String data = input.nextLine();
		
		System.out.println("Digite o novo horario da venda");
		String horario = input.nextLine();
		
		System.out.println("Digite os novos pratos da venda");
		String pratos = input.nextLine();
		
		System.out.println("Digite o novo metodo de pagamento da venda");
		String metodoDePagamento = input.nextLine();
		
		String [] info = new String[4];
		
		info[0] = data;
		info[1] = horario;
		info[2] = pratos;
		info[3] = metodoDePagamento;
		
		return info;
		
	}
	
	/**Método responsável por capturar e retornar as informações necessárias para excluir uma venda da lista de vendas.
	 * 
	 * @return Método buscaVenda
	 */
	public String excluirVenda() {
		System.out.println("\n");
		System.out.println("=================");
		System.out.println("= EXCLUIR VENDA =");
		System.out.println("=================");
		return buscaVenda();
		
	}
}
