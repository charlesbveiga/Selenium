import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {
	
	private WebDriver driver;
	private DSL dsl; 
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=f76a3");
		dsl = new DSL (driver);
	}
	
	@After 
	public void finaliza() {
		//driver.quit();
	}
	
	@Test
	public void testAjax() {
	dsl.escrever("j_idt311:name", "Teste");	
	dsl.clicarBotao("j_idt311:j_idt315");
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
	Assert.assertEquals("Teste", dsl.obterTexto("j_idt311:display"));
	}
}
