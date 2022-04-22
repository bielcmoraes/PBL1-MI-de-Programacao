package view;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Fornecedor;
import model.ListagemCopyable;
import model.Prato;
import model.Produto;
import model.Usuario;
import model.Venda;

/**Classe responsável por implementar os metódos de mostrarCardapio, listarFornecedor, listarProduto, listarUsuario e listarVenda que foram especificados 
 * na classe ListagemCopyable.
 * 
 * @author Gabriel Moraes
 * @author Luis Fernando Cintra
 */
public class ListagemView implements ListagemCopyable {
	
	/**O método percorre a lista de pratos (cardápio) e exibe para o usuário do sistema as informações de id, nome, preço, descrição, categoria e produtos
	 * de cada prato que compõe o cardápio.
	 */
	@Override
	public void mostrarCardapio(ArrayList<Prato> cardapio) {		
		System.out.println("\n");
		System.out.println("============");
		System.out.println("= CARDAPIO =");
		System.out.println("============");
		System.out.format("%-15s %-30s %-15s %-50s %-15s %-50s\n", "ID", "NOME","PRECO", "DESCRICAO", "CATEGORIA", "PRODUTOS");
		for(Prato prato: cardapio) {
			String produtos = "";
			for(Produto produto : prato.getProdutos()) {
				produtos += produto.getNome() + ", ";
			}
			produtos = produtos.substring(0, produtos.length()-2);
			System.out.format("%-15s %-30s R$ %-12.2f %-50s %-15s %-50s\n", 
					prato.getId(), 
					prato.getNome(), 
					prato.getPreco(),
					prato.getDescricao(),
					prato.getCategoria(),
					produtos);
		}
		
	}
	
	/**O método percorre a lista de fornecedores e exibe ao usuário do sistema as informações de id, nome, CNPJ e endereço de todos os fornecedores
	 * da lista de fornecedores.
	 */
	@Override
	public void listarFornecedor(ArrayList<Fornecedor> listaFornecedores) {
		System.out.println("\n");
		System.out.println("================");
		System.out.println("= FORNECEDORES =");
		System.out.println("===============");
		System.out.format("%-15s %-50s %-30s %-30s\n", "ID", "NOME", "CNPJ", "ENDERECO");
		for(Fornecedor fornecedor: listaFornecedores) {
			System.out.format("%-15s %-50s %-30s %-50s\n", 
					fornecedor.getId(), 
					fornecedor.getNome(),
					fornecedor.getCnpj(),
					fornecedor.getEndereco());
		}
	}

	/**O método percorre o ArrayList de produtos e exibe ao usuário do sistema as informações de id, nome, preço e validade de todos os produtos
	 * cadastrados no sistema.
	 */
	@Override
	public void listarProduto(ArrayList<Produto> listaProdutos) {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("\n");
		System.out.println("============");
		System.out.println("= PRODUTOS =");
		System.out.println("============");
		System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "NOME","PRECO", "VALIDADE");
		for(Produto produto: listaProdutos) {
			System.out.format("%-15s %-15s R$ %-12.2f %-15s\n", 
					produto.getId(), 
					produto.getNome(), 
					produto.getPreco(),
					produto.getValidade().format(formatoData));
		}
		
	}
	
	/**Pecorre a lista de usuários e exibe o id e o nome de todos os usuários cadastrados no sistema.
	 */
	@Override
	public void listarUsuario(ArrayList<Usuario> listaUsuarios) {
		System.out.println("\n");
		System.out.println("============");
		System.out.println("= USUARIOS =");
		System.out.println("============");
		System.out.format("%-15s %-50s\n", "ID", "NOME");
		for(Usuario usuario: listaUsuarios) {
			System.out.format("%-15s %-50s\n", 
					usuario.getId(), 
					usuario.getNome());
		}
	}
	
	/**O método percorre a lista de vendas e exibe ao usuário do sistema as informações de id, data, horario, pratos vendidos, preço total da venda e o
	 * método de pagamento de todas as vendas cadastradas no sistema.
	 */
	@Override
	public void listarVenda(ArrayList<Venda> listaVendas) {
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("\n");
		System.out.println("==========");
		System.out.println("= VENDAS =");
		System.out.println("==========");
		System.out.format("%-15s %-15s %-15s %-50s %-15s %-15s\n", "ID", "DATA","HORARIO", "PRATOS", "PRECO TOTAL", "METODO DE PAGAMENTO");
		for(Venda venda: listaVendas) {
			String pratos = "";
			for(Prato prato : venda.getPratos()) {
				pratos += prato.getNome() + ", ";
			}
			pratos = pratos.substring(0, pratos.length()-2);
			System.out.format("%-15s %-15s %-15s %-50s R$ %-12.2f %-15s\n", 
					venda.getId(), 
					venda.getData().format(formatoData), 
					venda.getHorario(),
					pratos,
					venda.getPrecoTotal(),
					venda.getMetodoDePagamento());
		}
		
	}

}
