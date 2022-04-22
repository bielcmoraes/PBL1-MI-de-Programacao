package testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.BancoDeDados;
import controller.GerenciaProdutos;

class GerenciaProdutoTest {

	@Test
	void cadastrandoProdutoComDadosValidos() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		info[0] = "Frango";
		info[1] = "10.5";
		info[2] = "28/07/2022";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		assertEquals(1, bancoDeDados.getListaProdutos().size(), "Tamanho de listaProdutos apos cadastro de 1 produto");
	}
	
	@Test
	void cadastrandoProdutoComOPrecoInvalido() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		info[0] = "Frango";
		info[1] = "a";
		info[2] = "28/07/2022";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		assertEquals(0, bancoDeDados.getListaProdutos().size(), "Tamanho de listaProdutos apos cadastro de 1 produto");
	}
	
	@Test
	void cadastrandoProdutoComAValidadeInvalida() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		info[0] = "Frango"; 
		info[1] = "10.5"; 
		info[2] = "50/99/02"; 
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		assertEquals(0, bancoDeDados.getListaProdutos().size(), "Tamanho de listaProdutos apos cadastro de 1 produto");
	}
	
	@Test
	void cadastrandoDoisProdutoComDadosValidos() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		
		info[0] = "Frango"; 
		info[1] = "10.5"; 
		info[2] = "01/01/1999"; 
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		
		info[0] = "Macarrao"; 
		info[1] = "20"; 
		info[2] = "30/12/2000"; 
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		
		assertEquals(2, bancoDeDados.getListaProdutos().size(), "Tamanho de listaProdutos apos cadastro de 2 produtos");
	}
	
	@Test
	void EditandoProdutoNaoCadastrado() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		info[0] = "Frango";
		info[1] = "9.99"; 
		info[2] = "10/10/2022";
		assertFalse(gerenciaProduto.editarProduto(bancoDeDados.getListaProdutos(), "999", info), "Editando 1 produto não cadastrado");
	}
	
	@Test
	void EditandoProdutoCadastrado() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		
		info[0] = "Peixe";
		info[1] = "10.99"; 
		info[2] = "11/11/2021";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		String id = bancoDeDados.getListaProdutos().get(0).getId();
		
		info[0] = "Frango";
		info[1] = "9.99"; 
		info[2] = "10/10/2022";
		
		assertTrue(gerenciaProduto.editarProduto(bancoDeDados.getListaProdutos(), id, info), "Editando 1 produto cadastrado");
	}
	
	@Test
	void EditandoProdutoCadastradoEmListaComDoisProdutosJaCadastrados() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		
		info[0] = "Peixe";
		info[1] = "10.99"; 
		info[2] = "11/11/2021";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		
		info[0] = "Massa";
		info[1] = "13.0"; 
		info[2] = "12/12/2020";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		String id = bancoDeDados.getListaProdutos().get(1).getId();
		
		info[0] = "Frango";
		info[1] = "9.99"; 
		info[2] = "10/10/2022";
		
		assertTrue(gerenciaProduto.editarProduto(bancoDeDados.getListaProdutos(), id, info), "Editando 1 produto cadastrado");
	}
	
	@Test
	void EditandoProdutoCadastradoComNovosDadosInvalidos() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		
		info[0] = "Peixe";
		info[1] = "10.99"; 
		info[2] = "11/11/2021";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		
		String id = bancoDeDados.getListaProdutos().get(0).getId();
		
		info[0] = "Frango";
		info[1] = "a"; 
		info[2] = "3000/3000/1";
		
		assertFalse(gerenciaProduto.editarProduto(bancoDeDados.getListaProdutos(), id, info), "Editando 1 produto cadastrado com novos dados invalidos");
	}
	
	@Test
	void ExcluindoProdutoNaoCadastrado() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
	
		assertFalse(gerenciaProduto.excluirProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(),"999"), "Excluindo 1 produto não cadastrado");
	}
	
	@Test
	void ExcluindoProdutoCadastrado() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		
		info[0] = "Peixe";
		info[1] = "10.99"; 
		info[2] = "11/11/2021";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		String id = bancoDeDados.getListaProdutos().get(0).getId();

		assertTrue(gerenciaProduto.excluirProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), id), "Excluindo 1 produto cadastrado");
	}
	
	@Test
	void ExcluindoProdutoCadastradoEmListaComDoisProdutosCadastrados() {
		BancoDeDados bancoDeDados = new BancoDeDados();
		GerenciaProdutos gerenciaProduto = new GerenciaProdutos();
		String [] info = new String[3] ;
		
		info[0] = "Peixe";
		info[1] = "10.99"; 
		info[2] = "11/11/2021";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		
		info[0] = "Massa";
		info[1] = "13.0"; 
		info[2] = "12/12/2020";
		gerenciaProduto.cadastrarProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), info);
		String id = bancoDeDados.getListaProdutos().get(0).getId();

		gerenciaProduto.excluirProduto(bancoDeDados.getListaProdutos(), bancoDeDados.getListaIds(), id);
		assertEquals("Massa", bancoDeDados.getListaProdutos().get(0).getNome(), "Exclusão do produto correto");
	}
}


