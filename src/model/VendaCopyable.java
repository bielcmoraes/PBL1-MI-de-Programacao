package model;

import java.util.ArrayList;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de vendas e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public interface VendaCopyable {
	
	/**Assinatura do metódo cadastrarVenda
	 * 
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param cardapio Lista de pratos
	 * @param info Entradas do usuário
	 * @return true se a venda for cadastrada com sucesso e false se a venda não for cadastrada com sucesso
	 */
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio, String [] info);
	
	/**Assinatura do metódo editarVenda
	 * 
	 * @param listaVendas Lista de vendas
	 * @param cardapio Lista de pratos
	 * @param codigoVenda Id da venda que deseja editar
	 * @param info Entradas do usuário
	 * @return true se a venda for editada com sucesso e false se a venda não for editada com sucesso	 
	 */
	public boolean editarVenda(ArrayList<Venda> listaVendas, ArrayList<Prato> cardapio, String codigoVenda, String [] info);
	
	/**Assinatura do metódo excluirVenda
	 * 
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param codigoVenda Id da venda que deseja excluir 
	 * @return true se a venda for excluida da lista de vendas com sucesso e false se a venda não for excluida da lista de vendas com sucesso	 
	 */
	public boolean excluirVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, String codigoVenda);
}
