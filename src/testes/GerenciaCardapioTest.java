package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.BancoDeDados;
import controller.GerenciaCardapio;
import controller.GerenciaProdutos;

class GerenciaCardapioTest {
	
	@Test
	void cadastrarPratoComDadosValidos() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		assertEquals(1, bancoDeDados.getCardapio().size(), "Tamanho da lista cardapio apos cadastro de 1 prato");
	}
	
	@Test
	void cadastrarPratoComPrecoInvalido() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "a"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		assertEquals(0, bancoDeDados.getCardapio().size(), "Tamanho da lista cardapio apos cadastro de 1 prato");
	}
	
	@Test
	void cadastrarPratoComUmProdutoInvalido() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "a"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		assertEquals(0, bancoDeDados.getCardapio().size(), "Tamanho da lista cardapio apos cadastro de 1 prato");
	}
	
	@Test
	void cadastrarPratoComTodosProdutosInvalidos() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "a"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		assertEquals(0, bancoDeDados.getCardapio().size(), "Tamanho da lista cardapio apos cadastro de 1 prato");
	}
	
	@Test
	void EditarPratoNaoCadastrado() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Duplo"; // Nome
		infoPrato[1] = "15.99"; // Preco;
		infoPrato[2] = "Um delicioso hamburger com 2x mais carne"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		
		assertFalse(gerenciaCardapio.editarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaProdutos(), "999", infoPrato), "Editando 1 prato do cardapio");
	}

	@Test
	void EditarPratoCadastradoComDadosNovosValidos() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);

		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		String id = bancoDeDados.getCardapio().get(0).getId();
		
		infoPrato[0] = "Hamburguer Duplo"; // Nome
		infoPrato[1] = "15.99"; // Preco;
		infoPrato[2] = "Um delicioso hamburger com 2x mais carne"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		
		assertTrue(gerenciaCardapio.editarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaProdutos(), id, infoPrato), "Editando 1 prato do cardapio");
	}
	
	@Test
	void EditarPratoCadastradoComPrecoNovoInvalido() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);

		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		String id = bancoDeDados.getCardapio().get(0).getId();
		
		infoPrato[0] = "Hamburguer Duplo"; // Nome
		infoPrato[1] = "a"; // Preco;
		infoPrato[2] = "Um delicioso hamburger com 2x mais carne"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		
		assertFalse(gerenciaCardapio.editarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaProdutos(), id, infoPrato), "Editando um prato do cardapio");
	}
	
	@Test
	void EditarPratoCadastradoComUmProdutoNovoInvalido() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);

		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		String id = bancoDeDados.getCardapio().get(0).getId();
		
		infoPrato[0] = "Hamburguer Duplo"; // Nome
		infoPrato[1] = "15.99"; // Preco;
		infoPrato[2] = "Um delicioso hamburger com 2x mais carne"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate, Elemento X"; // Produtos
		
		assertFalse(gerenciaCardapio.editarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaProdutos(), id, infoPrato), "Editando um prato do cardapio");
	}
	
	@Test
	void EditarPratoCadastradoComTodosProdutosNovosInvalidos() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);

		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		String id = bancoDeDados.getCardapio().get(0).getId();
		
		infoPrato[0] = "Hamburguer Duplo"; // Nome
		infoPrato[1] = "15.99"; // Preco;
		infoPrato[2] = "Um delicioso hamburger com 2x mais carne"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Bloco, Cimento, Brita"; // Produtos
		
		assertFalse(gerenciaCardapio.editarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaProdutos(), id, infoPrato), "Editando 1 prato do cardapio");
	}
	
	@Test
	void ExcluirPratoNaoCadastrado() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		assertFalse(gerenciaCardapio.excluirPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), "999"), "Excluindo 1 prato do cardapio");
	}
	
	@Test
	void ExcluirPratoCadastrado() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String id = bancoDeDados.getCardapio().get(0).getId();
		
		gerenciaCardapio.excluirPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), id);
		assertEquals(0, bancoDeDados.getCardapio().size(), "Excluindo 1 prato do cardapio");
	}
	
	@Test
	void ExcluirPratoCadastradoEmListaComDoisPratosCadastrados() {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProdutos = new GerenciaProdutos();
		GerenciaCardapio gerenciaCardapio = new GerenciaCardapio();
		
		String [] infoProduto = new String[3] ;
		infoProduto[0] = "Carne de Hamburger"; // Nome
		infoProduto[1] = "2"; // Preco
		infoProduto[2] = "10/10/2022"; // Validade
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Alface";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "Tomate";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		infoProduto[0] = "P�o";
		infoProduto[1] = "2";
		infoProduto[2] = "10/10/2022";
		gerenciaProdutos.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), infoProduto);
		
		String [] infoPrato = new String[5] ;
		infoPrato[0] = "Hamburguer Comum"; // Nome
		infoPrato[1] = "10.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger comum"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		infoPrato[0] = "Hamburguer Duplo"; // Nome
		infoPrato[1] = "12.5"; // Preco;
		infoPrato[2] = "Um delicioso hamburger com o dobro de carne"; // Descricao
		infoPrato[3] = "Lanche"; // Categoria
		infoPrato[4] = "Carne de Hamburger, P�o, Alface, Tomate"; // Produtos
		gerenciaCardapio.cadastrarPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), bancoDeDados.getListaProdutos(), infoPrato);
		
		String id = bancoDeDados.getCardapio().get(0).getId();
		
		gerenciaCardapio.excluirPrato(bancoDeDados.getCardapio(), bancoDeDados.getListaIds(), id);
		assertEquals("Hamburguer Duplo", bancoDeDados.getCardapio().get(0).getNome(), "Excluindo 1 prato do cardapio");
	}
}
