package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.BancoDeDados;
import controller.GerenciaFornecedor;
import model.Fornecedor;

class GerenciaFornecedorTest {
	
	@Test
	void cadastrandoFornecedorEmListaNaoInstanciada() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Fornecedor1";
		info[1] = "373746667";
		info[2] = "Rua Bonita";
		assertFalse(gf.cadastrarFornecedor(null, bd.getListaIds(), info));
	}
	
	@Test
	void adicionandoUmFornecedorNaListaVazia() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Fornecedor1";
		info[1] = "373746667";
		info[2] = "Rua Bonita";
		assertTrue(gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info));
	}
	
	@Test
	void cadastrandoVariosFornecedores() {
		
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String [] info = new String[3] ;
		info[0] = "Gabriel";
		info[1] = "40028922";
		info[2] = "Rua de cima";
		gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info);
		gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info);
		gf.cadastrarFornecedor(bd.getListaFornecedores(), bd.getListaIds(), info);
		
		assertSame(3, bd.getListaFornecedores().size(), "Cadastrando 3 fornecedores");
	}
	
	@Test
	void editandoFornecedorEmListaDeFornecedoresNaoInstanciada() {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertFalse(gf.editarFornecedor(null, codigoFornecedor, info), "Tentando cadastrar fornecedor em lista não instanciada");
	}
	
	@Test
	void editandoFornecedorVetorInfoNull() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.editarFornecedor(bd.getListaFornecedores(), codigoFornecedor, null), "Tentando cadastrar fornecedor com vetor de informações null");
	}
	
	@Test
	void editandoFornecedorListaFornecedoresEVetorInfoNull() {
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.editarFornecedor(null, codigoFornecedor, null), "Tentando cadastrar fornecedor com lista de fornecedores e vetor de informações null");
	}
	
	@Test
	void editandoFonecedorComCodigoFornecedorIncorreto() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Menino Maluquinho", "989876765", "Rua da esquerda");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = "99999999999";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertFalse(gf.editarFornecedor(bd.getListaFornecedores(), codigoFornecedor, info), "Tentando editar fornecedor com codigo de fornecedor incorreto");
	}
	@Test
	void editanfoFornecedorComSucesso() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Menino Maluquinho", "989876765", "Rua da esquerda");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = bd.getListaFornecedores().get(0).getId();
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertTrue(gf.editarFornecedor(bd.getListaFornecedores(), codigoFornecedor, info), "Editando Fornecedor com sucesso");
	}
	
	@Test
	void excluindoFornecedorEmListaDeFornecedoreNaoInstanciada() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.excluirFornecedor(null, bd.getListaIds(), codigoFornecedor),"Excluindo fornecedor com lista de fornecedores não instanciada");
	}
	
	@Test
	void excluindoFornecedorListaIdsNull() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		String codigoFornecedor = "88778";
		assertFalse(gf.excluirFornecedor(bd.getListaFornecedores(), null, codigoFornecedor), "Excluindo fornecedor com lista de ids null");
	}
	
	@Test
	void excluindoFornecedorCodigoFornecedorIncorreto() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Bruxa do 71", "893373485", "Vila do Chaves");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = "99999999999";
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertFalse(gf.excluirFornecedor(bd.getListaFornecedores(), bd.getListaIds(), codigoFornecedor));
		
	}
	
	@Test
	void excluindoFornecedorComSucesso() {
		BancoDeDados bd = new BancoDeDados();
		GerenciaFornecedor gf = new GerenciaFornecedor();
		Fornecedor f1 = new Fornecedor(bd.getListaIds(), "Bruxa do 71", "893373485", "Vila do Chaves");
		bd.getListaFornecedores().add(f1);
		String codigoFornecedor = bd.getListaFornecedores().get(0).getId();
		String [] info = new String[3] ;
		info[0] = "Alteracao";
		info[1] = "00000";
		info[2] = "Rua de baixo";
		assertTrue(gf.excluirFornecedor(bd.getListaFornecedores(), bd.getListaIds(), codigoFornecedor), "Excluindo fornecedor com sucesso");
	}
}
