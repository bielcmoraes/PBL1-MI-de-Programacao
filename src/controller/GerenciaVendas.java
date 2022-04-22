package controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Prato;
import model.Venda;
import model.VendaCopyable;
import view.VendaView;
/**Classe responsável por implementar os metódos de cadastrar, editar e excluir vendas da classe VendaCopyable.
 * 
 * @author Gabriel Moraes e Luis Fernando Cintra
 *
 */
public class GerenciaVendas implements VendaCopyable {
	/**
	 * O método é responsável por cadastrar um objeto do tipo Venda em uma ArrayList<Venda>.
	 * Esse cadastro só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente.
	 * @param listaVendas Lista de Vendas
	 * @param listaIds Lista de IDs
	 * @param cardapio Lista de Pratos
	 * @param info Lista com as entradas do usuario
	 * @return true caso o cadastro ocorra corretamente, false caso ocorra algum problema durante o processo.
	 */
	@Override
	public boolean cadastrarVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, ArrayList<Prato> cardapio, String [] info) {
	
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data;
		try {
			data = LocalDate.parse(info[0], formatoData);
		} catch (java.time.format.DateTimeParseException a) {
			return false;
		}
		
		DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime horario;
		try {
			horario = LocalTime.parse(info[1], formatoHorario);
		} catch (java.time.format.DateTimeParseException a) {
			return false;
		}
		
		ArrayList<Prato> pratos = new ArrayList<Prato>();
		for (String pratoNome : info[2].split(", ")) {
			for (Prato prato : cardapio) {
				if (pratoNome.equals(prato.getNome())) {
					pratos.add(prato);
				}
			}
		}
		
		if (pratos.size() != info[2].split(", ").length) {
			return false;
		}
		
		Double precoTotal = 0.0;
		for (Prato prato : pratos) {
			precoTotal += prato.getPreco();
		}
		
		Venda novaVenda = new Venda(listaIds, data, horario, pratos, precoTotal, info[3]);
		
		try {
			listaVendas.add(novaVenda);
			return true;
		} 
		catch(ArrayIndexOutOfBoundsException a){
			return false;
		}
	}
	/**
	 * O método é responsável por editar um objeto do tipo Venda em uma ArrayList<Venda>.
	 * Essa edição só ocorre caso todos os dados passados atraves da String []
	 * possam ser convertidos para seus respectivos tipos correspondente
	 * e a venda a ser editada possa ser encontrada na lista de vendas.
	 * @param listaVendas Lista de Vendas
	 * @param cardapio Lista de Pratos
	 * @param codigoVenda Codigo da Venda a ser editada
	 * @param info Lista com as entradas do usuario
	 * @return true caso a edição ocorra corretamente, false caso ocorra algum problema durante o processo.
	 */
	@Override
	public boolean editarVenda(ArrayList<Venda> listaVendas, ArrayList<Prato> cardapio, String codigoVenda, String [] info) {
		
		try {
			for(Venda venda : listaVendas) {
				if(codigoVenda.equals(venda.getId())) {
					
					DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate data;
					try {
						data = LocalDate.parse(info[0], formatoData);
					} catch (java.time.format.DateTimeParseException a) {
						return false;
					}
					
					DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
					LocalTime horario;
					try {
						horario = LocalTime.parse(info[1], formatoHorario);
					} catch (java.time.format.DateTimeParseException a) {
						return false;
					}
					
					ArrayList<Prato> pratos = new ArrayList<Prato>();
					for (String pratoNome : info[2].split(", ")) {
						for (Prato prato : cardapio) {
							if (pratoNome.equals(prato.getNome())) {
								pratos.add(prato);
							}
						}
					}
					
					if (pratos.size() != info[2].split(", ").length) {
						return false;
					}
					
					Double precoTotal = 0.0;
					for (Prato prato : pratos) {
						precoTotal += prato.getPreco();
					}
						
					venda.setData(data);
					venda.setHorario(horario);
					venda.setPratos(pratos);
					venda.setPrecoTotal(precoTotal);
					venda.setMetodoDePagamento(info[3]);
					
					return true;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException a){
			return false;
		}
		return false;
	}
	/**
	 * O método é responsável por excluir um objeto do tipo Venda em uma ArrayList<Venda>.
	 * Essa exclusão só ocorre caso a venda a ser excluido possa ser encontrada na lista de vendas.
	 * @param listaVendas Lista de Vendas
	 * @param listaIds Lista de IDs
	 * @param codigoVenda Codigo da Venda a ser excluida
	 * @return true caso a exclusão ocorra corretamente, false caso ocorra algum problema durante o processo.
	 */
	@Override
	public boolean excluirVenda(ArrayList<Venda> listaVendas, ArrayList<String> listaIds, String codigoVenda) {
		
		try {
			for(Venda venda : listaVendas) {
				if(codigoVenda.equals(venda.getId())) {
					int index = listaVendas.indexOf(venda);
					listaVendas.remove(index);
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
