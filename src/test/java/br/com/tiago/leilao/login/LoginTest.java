package br.com.tiago.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tiago.leilao.lance.LancesPage;

public class LoginTest {
	
	private LoginPage paginaLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		paginaLogin.fechar();
	}

	@Test
	public void deveriaEfetuarLoginComandosValidos() {
		paginaLogin.preencheFormularioDeLogin("fulano", "pass");
	    paginaLogin.efetuaLogin();
	    Assert.assertFalse(paginaLogin.isPaginaAtual());
	    Assert.assertEquals("fulano", paginaLogin.getNomeUsuarioLogado());
}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		paginaLogin.preencheFormularioDeLogin("invalido", "123");
	    paginaLogin.efetuaLogin();
		
	    Assert.assertTrue(paginaLogin.isPaginaDeLoginComDadosInvalido());
	    Assert.assertNull(paginaLogin.getNomeUsuarioLogado());
	    Assert.assertTrue(paginaLogin.contemTexto("Usuário e senha inválidos."));
	}
	
	@Test
	public void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
		LancesPage paginaDeLances = new LancesPage();
		
	    paginaLogin.navegaParaPaginaDeLances();
	    
	    Assert.assertTrue(paginaLogin.isPaginaAtual());
	    Assert.assertFalse(paginaLogin.contemTexto("Dados do Leilão"));
	}
}
