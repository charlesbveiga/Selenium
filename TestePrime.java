import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TestePrime {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		dsl = new DSL(driver);
	}
	
	@After 
	public void finaliza() {
		//driver.quit();
	}

	@Test
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//*[@id=\"j_idt312:console:0\"]/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime( ) {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=df50e");
		dsl.selecionarComboPrime("j_idt311:option", "Option3");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt311:option_label"));
	}
}
