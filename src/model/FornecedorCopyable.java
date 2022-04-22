package model;

import java.util.ArrayList;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de fornecedor e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public interface FornecedorCopyable {
	
	/**Assinatura do metódo cadastrarFornecedor
	 * 
	 * @param listaFornecedores Lista de Fornecedores
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuário
	 * @return true se o fornecedor for cadastrado com sucesso e false se o fornecedor não for cadastrado com sucesso
	 */
	public boolean cadastrarFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String [] info);
	
	/**Assinatura do metódo editarFornecedor
	 * 
	 * @param listaFornecedores Lista de Fornecedores
	 * @param codigoFornecedor Id do fornecedor que deseja editar
	 * @param info Entradas do usuário
	 * @return true se o fornecedor for editado com sucesso e false se o fornecedor não for editado com sucesso
	 */
	public boolean editarFornecedor(ArrayList<Fornecedor> listaFornecedores, String codigoFornecedor, String [] info);
	
	/**Assinatura do metódo editarFornecedor
	 * 
	 * @param listaFornecedores Lista de Fornecedores
	 * @param listaIds Lista de id's
	 * @param codigoFornecedor Id do fornecedor que deseja excluir
	 * @return true se o fornecedor for excluido com sucesso e false se o fornecedor não for excluido com sucesso
	 */
	public boolean excluirFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String codigoFornecedor);
}
