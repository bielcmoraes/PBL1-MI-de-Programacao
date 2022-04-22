package model;

import java.util.ArrayList;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de produto e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public interface ProdutoCopyable {
	
	/**Assinatura do metódo cadastrarProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuário
	 * @return true se o produto for cadastrado com sucesso e false se o produto não for cadastrado com sucesso
	 */
	public boolean cadastrarProduto(ArrayList<Produto> listaProdutos, ArrayList<String> listaIds, String [] info);
	
	/**Assinatura do metódo editarProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 * @param codigoProduto Id do produto que deseja editar
	 * @param info Entrada do usuário
	 * @return true se o produto for editado com sucesso e false se o produto não for editado com sucesso
	 */
	public boolean editarProduto(ArrayList<Produto> listaProdutos, String codigoProduto, String [] info);
	
	/**Assinatura do metódo excluirProduto
	 * 
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param codigoProduto Id do produto que deseja excluir
	 * @return true se o produto for excluido da lista de produtos com sucesso e false se o produto não for excluido da lista de produtos com sucesso
	 */
	public boolean excluirProduto(ArrayList<Produto> listaProdutos, ArrayList<String> listaIds, String codigoProduto);
}
