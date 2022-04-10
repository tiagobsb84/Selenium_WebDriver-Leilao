package br.com.tiago.leilao.leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tiago.leilao.login.LoginPage;

public class LeiloesTest {

private LeiloesPage paginaDeLeiloes;
	
	@AfterEach
	public void afterEach() {
		paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastraLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
		CadastroLeilaoPage cadastroDeCadastro = paginaDeLeiloes.carregarFormulario();
	}
}
