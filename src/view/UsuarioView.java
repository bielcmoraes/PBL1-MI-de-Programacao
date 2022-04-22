package view;

import java.util.Scanner;

import model.UsuarioCopyable;

/**Classe reponsável por se comunicar com o usuário do sistema sobre a classes de gerenciamento de usuários, através da exibição de mensagens
 * e da captura de inputs.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class UsuarioView {
	
	/**Método responsável por capturar e retornar as informações utilizadas para cadastrar um produto no sistema.
	 * 
	 * @return Vetor de strings com as informações correspondentes ao nome do usuário, tipo de usuário, login do usuário e senha do usuário nas posições
	 * 0, 1, 2 e 3, respectivamente.
	 */
	public static String[] cadastraUsuario() {
		System.out.println("\n");
		System.out.println("=====================");
		System.out.println("= CADASTRAR USUARIO =");
		System.out.println("=====================");
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o nome do usuario");
		String nome = input.nextLine();
		System.out.println("Digite 1 para cadastrar um gerente e 2 para cadastrar um funcionario");
		String cargo = input.nextLine();
		System.out.println("Digite um login para o usuario");
		String login = input.nextLine();
		System.out.println("Digite a senha do Usuario");
		String senha = input.nextLine();

		String[] infoUsuario = new String[4];
		infoUsuario[0] = nome;
		infoUsuario[1] = cargo;
		infoUsuario[2] = login;
		infoUsuario[3] = senha;
		return infoUsuario;
	}
	
	/**Método responsável por capturar, do usuário, e retornar o id de um usuário.
	 * 
	 * @return Código do usuário
	 */
	public static String buscaUsuario() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o codigo do usuario que deseja buscar");
		String codigo = input.nextLine();
		return codigo;
	}
	
	/**Método responsável por capturar e retornar os inputs que serão utilizados para editar um usuário da lista de usuários.
	 * 
	 * @return Vetor de strings com as novas informações correspondentes ao nome do usuário e senha do usuário nas posições 0 e 1, respectivamente.
	 */
	public static String[] editaUsuario() {
		System.out.println("\n");
		System.out.println("==================");
		System.out.println("= EDITAR USUARIO =");
		System.out.println("==================");
		//Edita nome e senha (Não é possivel modificar o login)
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o novo nome do usuario");
		String novoNome = input.nextLine();
		System.out.println("Digite a nova senha de usuario");
		String novaSenha = input.nextLine();
		
		String [] infoUsuario = new String [2];
		infoUsuario[0] = novoNome;
		infoUsuario[1] = novaSenha;
		return infoUsuario;
	}
	
	/**Método responsável por capturar e retornar as informações necessárias para excluir um usuário da lista de usuários.
	 * 
	 * @return Método buscaUsuario
	 */
	public static String excluiUsuario() {
		System.out.println("\n");
		System.out.println("===================");
		System.out.println("= EXCLUIR USUARIO =");
		System.out.println("===================");
		return buscaUsuario();
	}

}
