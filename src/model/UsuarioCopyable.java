package model;

import java.util.ArrayList;

/**Estrutura que contém as assinaturas dos metódos relacionados ao gerenciamento de usuário e utilizada para "resolver" o problema de herança multipla em Java.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public interface UsuarioCopyable {
	
	/**Assinatura do metódo cadastrarUsuario
	 * 
	 * @param listaUsuarios Lista de usuários
	 * @param listaIds Lista de id's
	 * @param info Entrada do usuário
	 * @return true se o usuário for cadastrado com sucesso e false se o usuário não for cadastrado com sucesso
	 */
	public boolean cadastrarUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String [] info);
	
	/**Assinatura do metódo editarUsuario
	 * 
	 * @param listaUsuarios Lista de usuários
	 * @param codigoUsuario Id do usuário que deseja editar
	 * @param info Entrada do usuário
	 * @return true se o usuário for editado com sucesso e false se o usuário não for editado com sucesso
	 */
	public boolean editarUsuario(ArrayList<Usuario> listaUsuarios, String codigoUsuario, String [] info);
	
	/**Assinatura do metódo excluirUsuario
	 * 
	 * @param listaUsuarios Lista de usuários
	 * @param listaIds Lista de id's
	 * @param codigoUsuario Id do usuário que deseja excluir
	 * @return true se o usuário for excluido da lista de usuários com sucesso e false se o usuário não for excluido da lista de usuários com sucesso
	 */
	public boolean excluirUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String codigoUsuario);
}
