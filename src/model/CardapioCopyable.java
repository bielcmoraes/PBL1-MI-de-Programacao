package model;

import java.util.ArrayList;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento do cardápio e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public interface CardapioCopyable {
	
	/**Assinatura do metódo cadastrarPrato
	 * 
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param listaProdutos Lista de Produtos
	 * @param info Entradas do usuário
	 * @return true se o prato for cadastrado com sucesso e false se o prato não for cadastrado com sucesso
	 */
	public boolean cadastrarPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, ArrayList<Produto> listaProdutos, String [] info);
	
	/**Assinatura do metódo editarPrato
	 * 
	 * @param cardapio Lista de pratos
	 * @param listaProdutos Lista de Produtos
	 * @param codigoPrato Id do prato que deseja editar
	 * @param info Entradas do usuário
	 * @return true se o prato for editado com sucesso e false se o prato não for editado com sucesso
	 */
	public boolean editarPrato(ArrayList<Prato> cardapio, ArrayList<Produto> listaProdutos, String codigoPrato, String [] info);
	
	/**Assinatura do metódo excluirPrato
	 * 
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param codigoPrato Id do prato que deseja excluir
	 * @return true se o prato for excluido do cardápio com sucesso e false se o prato não for excluido do cardápio com sucesso
	 */
	public boolean excluirPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, String codigoPrato);
}
