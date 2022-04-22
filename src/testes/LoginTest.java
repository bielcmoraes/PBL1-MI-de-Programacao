package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.BancoDeDados;
import controller.Login;
import model.Usuario;

class LoginTest {
	
	@Test
	void autenticaLoginListaUsuarioNull(){
		BancoDeDados bd = new BancoDeDados();
		Login lo = new Login(bd.getListaUsuarios());
		String[] info = new String[2];
		info[0] = "patati";
		info[1] = "patata";
		assertNull(lo.autenticarLogin(null, info), "Tentando logar com a lista de usuarios null");
	}
	
	@Test
	void falhaAutenticaLogin() {
		BancoDeDados bd = new BancoDeDados();
		Login lo = new Login(bd.getListaUsuarios());
		String[] info = new String[2];
		info[0] = "patati";
		info[1] = "patata";
		assertNull(lo.autenticarLogin(bd.getListaUsuarios(), info), "Tentando logar com informações incorretas");
	}
	
	@Test
	void logandoComSucesso() {
		BancoDeDados bd = new BancoDeDados();
		Login lo = new Login(bd.getListaUsuarios());
		String[] info = new String[2];
		info[0] = "admin";
		info[1] = "admin";
		Usuario logado = bd.getListaUsuarios().get(0);
		assertEquals(logado, lo.autenticarLogin(bd.getListaUsuarios(), info),"Logando com sucesso");
	}

}
