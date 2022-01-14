package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TestePrime {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		DriverFactory.getDriver();
	}

	@Test
	public void deveInteragirComRadioPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//*[@id=\"j_idt312:console:0\"]/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=df50e");
		dsl.selecionarComboPrime("j_idt311:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt311:option_label"));
	}
}
