package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.BancoDeDados;
import controller.GerenciaCardapio;
import controller.GerenciaProdutos;
import controller.GerenciaVendas;

class GerenciaVendaTest {

	@Test
	void CadastrarVendaComDadosValidos() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		assertEquals(1, bancoDeDados.getListaVendas().size(),"Tamanho de listaVendas apos cadastro de 1 venda");
	}
	
	@Test
	void CadastrarVendaComDataInvalida() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "3000/3000/3000"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		assertEquals(0, bancoDeDados.getListaVendas().size(),"Tamanho de listaVendas apos cadastro de 1 venda");
	}
	
	@Test
	void CadastrarVendaComHorarioInvalido() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "30:70"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		assertEquals(0, bancoDeDados.getListaVendas().size(),"Tamanho de listaVendas apos cadastro de 1 venda");
	}
	
	@Test
	void CadastrarVendaComPratoInvalido() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		assertEquals(0, bancoDeDados.getListaVendas().size(),"Tamanho de listaVendas apos cadastro de 1 venda");
	}

	@Test
	void VerificarPrecoTotalDaVendaAposCadastro() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola, Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		assertEquals(11.0, bancoDeDados.getListaVendas().get(0).getPrecoTotal(),"precoTotal da venda apos o cadastro");
	}
	
	@Test
	void EditarVendaNaoCadastrada() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		
		assertFalse(gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), "999", infoVenda),"Editando 1 venda não cadastrada da listaVendas");
	}
	
	@Test
	void EditarVendaCadastradaComDadosNovosValidos() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Fanta"; // Nome
		infoProduto[1] = "3.5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Fanta"; // Nome
		infoPrato[1] = "4"; // Preco;
		infoPrato[2] = "Uma Fanta geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Fanta"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		infoVenda[0] = "12/05/2022"; // Data
		infoVenda[1] = "15:15"; // Horario
		infoVenda[2] = "Fanta";// Pratos
		infoVenda[3] = "Debito";// MetodoDePagamento
		
		assertTrue(gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), id, infoVenda),"Editando 1 venda cadastrada da listaVendas");
	}
	
	@Test
	void EditarVendaCadastradaComDataNovaInvalida() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Fanta"; // Nome
		infoProduto[1] = "3.5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Fanta"; // Nome
		infoPrato[1] = "4"; // Preco;
		infoPrato[2] = "Uma Fanta geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Fanta"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		infoVenda[0] = "300/3000/3000"; // Data
		infoVenda[1] = "15:15"; // Horario
		infoVenda[2] = "Fanta";// Pratos
		infoVenda[3] = "Debito";// MetodoDePagamento
		
		assertFalse(gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), id, infoVenda),"Editando 1 venda cadastrada da listaVendas");
	}
	
	@Test
	void EditarVendaCadastradaComHorarioNovoInvalido() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Fanta"; // Nome
		infoProduto[1] = "3.5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Fanta"; // Nome
		infoPrato[1] = "4"; // Preco;
		infoPrato[2] = "Uma Fanta geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Fanta"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		infoVenda[0] = "12/05/2022"; // Data
		infoVenda[1] = "30:70"; // Horario
		infoVenda[2] = "Fanta";// Pratos
		infoVenda[3] = "Debito";// MetodoDePagamento
		
		assertFalse(gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), id, infoVenda),"Editando 1 venda cadastrada da listaVendas");
	}
	
	@Test
	void EditarVendaCadastradaComPratoInvalido() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);

		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		infoVenda[0] = "12/05/2022"; // Data
		infoVenda[1] = "15:15"; // Horario
		infoVenda[2] = "Fanta";// Pratos
		infoVenda[3] = "Debito";// MetodoDePagamento
		
		assertFalse(gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), id, infoVenda),"Editando 1 venda cadastrada da listaVendas");
	}
	
	@Test
	void VerificarPrecoTotalDaVendaAposEdicao() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Fanta"; // Nome
		infoProduto[1] = "3.5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Fanta"; // Nome
		infoPrato[1] = "4"; // Preco;
		infoPrato[2] = "Uma Fanta geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Fanta"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		infoVenda[0] = "12/05/2022"; // Data
		infoVenda[1] = "15:15"; // Horario
		infoVenda[2] = "Fanta, Fanta";// Pratos
		infoVenda[3] = "Debito";// MetodoDePagamento
		gerenciaVendas.editarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getCardapio(), id, infoVenda);
		
		assertEquals(8.0, bancoDeDados.getListaVendas().get(0).getPrecoTotal(),"precoTotal da venda apos o edicao");
	}
	
	@Test
	void ExcluirVendaNaoCadastrada() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		assertFalse(gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), "999"),"Excluindo 1 venda nao cadastrada");
	}
	
	@Test
	void ExcluirVendaCadastrada() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), id);
		assertEquals(0, bancoDeDados.getListaVendas().size(),"Excluindo 1 venda cadastrada");
	}
	
	@Test
	void ExcluirUmaVendaCadastradaEmListaComDuasVendasCadastradas() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		GerenciaVendas gerenciaVendas = new GerenciaVendas();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Coca-Cola"; // Nome
		infoProduto[1] = "5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Fanta"; // Nome
		infoProduto[1] = "3.5"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Coca-Cola"; // Nome
		infoPrato[1] = "5.5"; // Preco;
		infoPrato[2] = "Uma Coca-Cola geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Coca-Cola"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Fanta"; // Nome
		infoPrato[1] = "4"; // Preco;
		infoPrato[2] = "Uma Fanta geladinha"; // Descricao
		infoPrato[3] = "Bebida"; // Categoria
		infoPrato[4] = "Fanta"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String [] infoVenda = new String[4];
		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Coca-Cola";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);

		infoVenda[0] = "11/04/2022"; // Data
		infoVenda[1] = "14:14"; // Horario
		infoVenda[2] = "Fanta";// Pratos
		infoVenda[3] = "Credito";// MetodoDePagamento
		gerenciaVendas.cadastrarVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), bancoDeDados.getCardapio(), infoVenda);
		
		String id = bancoDeDados.getListaVendas().get(0).getId();
		
		gerenciaVendas.excluirVenda(bancoDeDados.getListaVendas(), bancoDeDados.getListaIds(), id);
		assertEquals("Fanta", bancoDeDados.getListaVendas().get(0).getPratos().get(0).getNome(),"Excluindo 1 venda cadastrada");
	}
	
}
