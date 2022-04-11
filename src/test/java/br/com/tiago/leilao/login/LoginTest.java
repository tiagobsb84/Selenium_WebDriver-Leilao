package br.com.tiago.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tiago.leilao.lance.LancesPage;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
	    paginaDeLogin.efetuarLogin();
	    Assert.assertFalse(paginaDeLogin.isPaginaAtual());
	    Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
}
	
	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencherFormularioDeLogin("invalido", "1233");
		paginaDeLogin.efetuarLogin();

		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.isPaginaAtual());
		Assert.assertTrue(paginaDeLogin.isMensagemDeLoginInvalidoVisivel());
	}
	
	@Test
	public void naoDeveriaAcessarUrlRestritaSemEstarLogado() {
		LancesPage paginaDeLances = new LancesPage();

		Assert.assertFalse(paginaDeLances.isPaginaAtual());
		Assert.assertFalse(paginaDeLances.isTituloLeilaoVisivel());

		paginaDeLances.fechar();
	}
}
