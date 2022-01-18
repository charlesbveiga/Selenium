package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial(){
		getDriver().get("https://seubarriga.wcaquino.me");
	}

	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha (String senha) {
		escrever("senha", senha);
	}
	
	public void entrar () {
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha ) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
}