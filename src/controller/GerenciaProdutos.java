package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Produto;
import model.ProdutoCopyable;
import view.ProdutosView;
/**Classe responsável por implementar os metódos de cadastrar, editar e excluir produto que foram especificados na classe ProdutoCopyable.
 * 
 *  @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public class GerenciaProdutos implements ProdutoCopyable {
	/**
	 * O método é responsável por cadastrar um objeto do tipo Produto em uma ArrayList<Produto>.
	 * Esse cadastro só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente.
	 * @param listaProdutos Lista de Produtos
	 * @param listaIds Lista de IDs
	 * @param info Lista com as entradas do usuario
	 * @return true caso o cadastro ocorra corretamente, false caso ocorra algum problema durante o processo
	 */
	@Override
	public boolean cadastrarProduto(ArrayList<Produto> listaProdutos, ArrayList<String> listaIds, String [] info) {
		
		Double preco;
		try {
			preco = Double.parseDouble(info[1]);
		} catch (java.lang.NumberFormatException a) {
			return false;
		}
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate validade;
		try {
			validade = LocalDate.parse(info[2], formatoData);
		} catch (java.time.format.DateTimeParseException a) {
			return false;
		}
		
		Produto novoProduto = new Produto(listaIds, info[0], preco, validade);
		
		try {
			listaProdutos.add(novoProduto);
			return true;
		} 
		catch(ArrayIndexOutOfBoundsException a){
			return false;
		}
	}
	/**
	 * O método é reponsavel por editar as informações de um objeto do tipo Produto já cadastrado em uma ArrayList<Produto>.
	 * Essa edição só ocorre caso todos os dados passados atraves da String [] 
	 * possam ser convertidos para seus respectivos tipos correspondente
	 * e o produto a ser editado possa ser encontrado na lista de produtos.
	 * @param listaProdutos Lista de Produtos
	 * @param codigoProduto Código do Produto a ser editado
	 * @param info Lista com as entradas do usuario
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo
	 */
	@Override
	public boolean editarProduto(ArrayList<Produto> listaProdutos, String codigoProduto, String [] info) {
		
		try {
			for(Produto produto : listaProdutos) {
				if(codigoProduto.equals(produto.getId())) {
					
					produto.setNome(info[0]);
					Double preco;
					try {
						preco = Double.parseDouble(info[1]);
					} catch (java.lang.NumberFormatException a) {
						return false;
					}
					DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate validade;
					try {
						validade = LocalDate.parse(info[2], formatoData);
					} catch (java.time.format.DateTimeParseException a) {
						return false;
					}
					produto.setPreco(preco);
					produto.setValidade(validade);
		
					return true;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException a){
		}
		return false;
	}
	/**
	 * O método é reponsavel por excluir um objeto do tipo Produto já cadastrado em uma ArrayList<Produto>.
	 * Essa exclusão só ocorre caso o produto a ser excluido seja encontrado na lista de produtos.
	 * @param listaProdutos Lista de Produtos
	 * @param listaIds Lista de IDs
	 * @param codigoProduto Código do Produto a ser editado
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo
	 */
	@Override
	public boolean excluirProduto(ArrayList<Produto> listaProdutos, ArrayList<String> listaIds, String codigoProduto) {
		
		try {
			for(Produto produto : listaProdutos) {
				if(codigoProduto.equals(produto.getId())) {
					int index = listaProdutos.indexOf(produto);
					listaProdutos.remove(index);
					return true;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException a) {
			return false;
		}
		return false;
	}
}
