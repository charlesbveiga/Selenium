package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteAjax {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=f76a3");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		//DriverFactory.killDriver();
	}

	@Test
	public void testAjax(){
		dsl.escrever("j_idt311:name", "Teste");	
		dsl.clicarBotao("j_idt311:j_idt315");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Teste"));
		wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
	}
}
