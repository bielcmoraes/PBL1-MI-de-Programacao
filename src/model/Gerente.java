package model;

import java.util.ArrayList;

import controller.GerenciaCardapio;
import controller.GerenciaFornecedor;
import controller.GerenciaProdutos;
import controller.GerenciaUsuario;
import controller.GerenciaVendas;
import view.ListagemView;
/**Classe para objetos do tipo Gerente, onde são contidos, valores e metódos necessários para a implementação da classe.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 * @see Usuario
 */
public class Gerente extends Usuario implements FornecedorCopyable, UsuarioCopyable, ProdutoCopyable, CardapioCopyable, VendaCopyable, ListagemCopyable{
	
	/**O construtor vazio inicializa o construtor vazio da classe herdada. Necessario para intanciar um representante da classe com informações de id, login e senha pré estabelecidas.
	 */
	public Gerente() {
		super();
	}
	
	/**O construtor inicializa o costrutor da classe herdada e atribui a cada variável da classe os respectivos valores fornecidos como parâmetro.
	 * 
	 * @param listaIds Lista de id's
	 * @param nome Nome do funcionário
	 * @param login Login do funcionário
	 * @param senha Senha do funcionário
	 */
	public Gerente(ArrayList<String> listaIds, String nome, String login, String senha) {
		super(listaIds, nome, login, senha);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaFornecedor e retornar o método cadastrarFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 * @param listaIds Lista de id's
	 * @param info Entradas do Usuario
	 * @return Boolean cadastrarFornecedor
	 */
	@Override
	public boolean cadastrarFornecedor(ArrayList<Fornecedor> listaFornecedores, ArrayList<String> listaIds, String[] info) {
		
		GerenciaFornecedor gerenciamentoFornecedor = new GerenciaFornecedor();
		return gerenciamentoFornecedor.cadastrarFornecedor(listaFornecedores, listaIds, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaFornecedor e retornar o método editarFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 * @param codigoFornecedor Id do fornecedor que deseja editar
	 * @param info Entradas do Usuario
	 * @return Boolean editarFornecedor
	 */
	@Override
	public boolean editarFornecedor(ArrayList<Fornecedor> listaFornecedores, String codigoFornecedor, String [] info) {
		
		GerenciaFornecedor gerenciamentoFornecedor = new GerenciaFornecedor();
		return gerenciamentoFornecedor.editarFornecedor(listaFornecedores, codigoFornecedor, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaFornecedor e retornar o método excluirFornecedor.
	 * @param listaFornecedores Lista de fornecedores
	 * @param listaIds Lista de id's
	 * @param codigoFornecedor Id do fornecedor que deseja excluir
	 * @return Boolean excluirFornecedor
	 */
	@Override
	public boolean excluirFornecedor(ArrayList<Fornecedor> listaFornecedores,ArrayList<String> listaIds, String codigoFornecedor) {
		
		GerenciaFornecedor gerenciamentoFornecedor = new GerenciaFornecedor();
		return gerenciamentoFornecedor.excluirFornecedor(listaFornecedores, listaIds, codigoFornecedor);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaUsuario e retornar o método cadastrarUsuario.
	 * @param listarFornecedores Lista de usuarios
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuario
	 * @return Boolean cadastrarUsuario
	 */
	@Override
	public boolean cadastrarUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String [] info) {
		GerenciaUsuario gerenciamentoUsuario = new GerenciaUsuario();
		return gerenciamentoUsuario.cadastrarUsuario(listaUsuarios, listaIds, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaUsuario e retornar o método editarUsuario.
	 * @param listarFornecedores Lista de usuarios
	 * @param codigoUsuario Id do usuario que deseja editar
	 * @param info Entradas do usuario
	 * @return Boolean editarUsuario
	 */
	@Override
	public boolean editarUsuario(ArrayList<Usuario> listaUsuarios, String codigoUsuario, String [] info) {
		
		//Istancia o gerenciamento de usuario
		GerenciaUsuario gerenciamentoUsuario = new GerenciaUsuario();
		return gerenciamentoUsuario.editarUsuario(listaUsuarios, codigoUsuario, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaUsuario e retornar o método excluirUsuario.
	 * @param listarFornecedores Lista de usuarios
	 * @param listaIds Lista de id's
	 * @param codigoUsuario Id do usuário que deseja excluir
	 * @return Boolean excluirUsuario
	 */
	@Override
	public boolean excluirUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<String> listaIds, String codigoUsuario) {
		GerenciaUsuario gerenciamentoUsuario = new GerenciaUsuario();
		return gerenciamentoUsuario.excluirUsuario(listaUsuarios, listaIds, codigoUsuario);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaProdutos e retornar o método cadastrarProduto.
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param info Entradas do usuário
	 * @return Boolean cadastrarProduto
	 */
	@Override
	public boolean cadastrarProduto(ArrayList<Produto> listaProdutos, ArrayList<String> listaIds, String [] info) {
		GerenciaProdutos gerenciamentoProdutos = new GerenciaProdutos();
		return gerenciamentoProdutos.cadastrarProduto(listaProdutos, listaIds, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaProdutos e retornar o método editarProduto.
	 * @param listaProdutos Lista de produtos
	 * @param codigoProduto Id do produto que deseja editar
	 * @param info Entradas do usuário
	 * @return Boolean editarProduto
	 */
	@Override
	public boolean editarProduto(ArrayList<Produto> listaProdutos,  String codigoProduto, String [] info) {
		GerenciaProdutos gerenciamentoProdutos = new GerenciaProdutos();
		return gerenciamentoProdutos.editarProduto(listaProdutos, codigoProduto, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaProdutos e retornar o método excluirProduto.
	 * @param listaProdutos Lista de produtos
	 * @param listaIds Lista de id's
	 * @param codigoProduto Id do produto que deseja excluir
	 * @return Boolean excluirProduto
	 */
	@Override
	public boolean excluirProduto(ArrayList<Produto> listaProdutos, ArrayList<String> listaIds, String codigoProduto) {
		GerenciaProdutos gerenciamentoProdutos = new GerenciaProdutos();
		return gerenciamentoProdutos.excluirProduto(listaProdutos, listaIds, codigoProduto);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaCardapio e retornar o método cadastrarPrato.
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param listaProdutos Lista de produtos
	 * @param info Entradas do usuário
	 * @return Boolean cadastrarPrato
	 */
	@Override
	public boolean cadastrarPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds,
			ArrayList<Produto> listaProdutos, String [] info) {
		GerenciaCardapio gerenciamentoCardapio = new GerenciaCardapio();
		return gerenciamentoCardapio.cadastrarPrato(cardapio, listaIds, listaProdutos, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaCardapio e retornar o método editarPrato.
	 * @param cardapio Lista de pratos
	 * @param listaProdutos Lista de produtos
	 * @param codigoPrato Id do prato que deseja editar
	 * @param info Entradas do usuário
	 * @return Boolean editarPrato
	 */
	@Override
	public boolean editarPrato(ArrayList<Prato> cardapio, ArrayList<Produto> listaProdutos, String codigoPrato, String [] info) {
		GerenciaCardapio gerenciamentoCardapio = new GerenciaCardapio();
		return gerenciamentoCardapio.editarPrato(cardapio, listaProdutos, codigoPrato, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaCardapio e retornar o método excluirPrato.
	 * @param cardapio Lista de pratos
	 * @param listaIds Lista de id's
	 * @param codigoPrato Id do prato que deseja editar
	 * @return Boolean excluirPrato
	 */
	@Override
	public boolean excluirPrato(ArrayList<Prato> cardapio, ArrayList<String> listaIds, String codigoPrato) {
		GerenciaCardapio gerenciamentoCardapio = new GerenciaCardapio();
		return gerenciamentoCardapio.excluirPrato(cardapio, listaIds, codigoPrato);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método cadastrarVenda.
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de id's
	 * @param cardapio Cardapio (lista de pratos)
	 * @param info Entradas do Usuario
	 * @return Boolean cadastrarVenda
	 */
	@Override
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio,
			String[] info) {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.cadastrarVenda(listaVendas, listaIds, cardapio, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método editarVenda.
	 * @param listaVendas Lista de vendas
	 * @param cardapio Cardapio (lista de pratos)
	 * @param codigoVenda Id da venda que deseja editar
	 * @param info Entradas do Usuario
	 * @return Boolean editarVenda
	 */
	@Override
	public boolean editarVenda(ArrayList<Venda> listaVendas, ArrayList<Prato> cardapio, String codigoVenda,
			String[] info) {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.editarVenda(listaVendas, cardapio, codigoVenda, info);
	}
	
	/**Metódo para instanciar um objeto do tipo GerenciaVendas e retornar o método excluirVenda.
	 * @param listaVendas Lista de vendas
	 * @param listaIds Lista de ids
	 * @param codigoVenda Id da venda que deseja editar
	 * @return Boolean excluirVenda
	 */
	@Override
	public boolean excluirVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, String codigoVenda) {
		GerenciaVendas gerenciamentoVendas = new GerenciaVendas();
		return gerenciamentoVendas.excluirVenda(listaVendas, listaIds, codigoVenda);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView.
	 * @param cardapio Cardapio (lista de pratos)
	 */
	@Override
	public void mostrarCardapio(ArrayList<Prato> cardapio) {
		ListagemView listagemView = new ListagemView();
		listagemView.mostrarCardapio(cardapio);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView.
	 * @param listarFornecedor Lista de Fornecedores
	 */
	@Override
	public void listarFornecedor(ArrayList<Fornecedor> listaFornecedores) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarFornecedor(listaFornecedores);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView.
	 * @param listarProduto Lista de produtos
	 */
	@Override
	public void listarProduto(ArrayList<Produto> listaProdutos) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarProduto(listaProdutos);	
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView e retornar o método listarUsuario.
	 * @param listaUsuarios Lista de usuários
	 */
	@Override
	public void listarUsuario(ArrayList<Usuario> listaUsuarios) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarUsuario(listaUsuarios);
	}
	
	/**Metódo para instanciar um objeto do tipo ListagemView e retornar o método listarVenda.
	 * @param listaVendas Lista de vendas
	 */
	@Override
	public void listarVenda(ArrayList<Venda> listaVendas) {
		ListagemView listagemView = new ListagemView();
		listagemView.listarVenda(listaVendas);
	}

}