package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
		
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto (By.xpath("/html/body/div[1]"));
	}
	
	public String obterMensagemErro() {
		return obterTexto (By.xpath("/html/body/div[1]"));
	}
	
	public void clicarAlterarConta(String string) {
		obterCelula("Conta", "Conta do Teste", "Ações", "tabelaContas")
			.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/a[1]/span")).click();		
	}

	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']")).click();		
	}

}


