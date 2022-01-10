import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioCadastroComSucesso {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After 
	public void finaliza() {
		//driver.quit();
	}

	@Test
	public void DesafioCadastroComSucesso() {
		page.setNome("Charles");
		page.setSobrenome("Batista Veiga");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEscolaridade("Superior");
		page.setEsporte("Futebol");
		page.cadastrar();
		
		Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
		Assert.assertEquals("Charles", page.obterNomeCadastro());
		Assert.assertEquals("Batista Veiga", page.obterSobrenomeCadastro());
		Assert.assertEquals("Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Carne", page.obterComidaCadastro());
		Assert.assertEquals("superior",page.obterEscolaridadeCadastro());
		Assert.assertEquals("Futebol", page.obterEsportesCadastro());
	}

	@Test
	public void DeveValidarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void DeveValidarSobreNomeObrigatorio() {
		page.setNome("Nome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio",  dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void DeveValidarSexoObrigatorio() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio",  dsl.alertaObterTextoEAceita());
		}
	
	@Test
	public void DeveValidarComidaVegetariana() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		}
		
	@Test
	public void DeveValidarEsportistaIndeciso() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsporte("Futebol", "O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
		}
}
