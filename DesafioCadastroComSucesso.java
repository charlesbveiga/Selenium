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
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver); 
	}
	
	@After 
	public void finaliza() {
		//driver.quit();
	}

	@Test
	public void DesafioCadastroComSucesso() {
		dsl.escreve("elementosForm:nome", "Charles");
		dsl.escreve("elementosForm:sobrenome", "Batista Veiga");
		dsl.clicarRadio("elementosForm:sexo:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		dsl.selecionarCombo("elementosForm:esportes","Futebol");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
		Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Charles"));
		Assert.assertEquals("Sobrenome: Batista Veiga", dsl.obterTexto("descSobrenome"));
		Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
		Assert.assertEquals("Comida: Carne", dsl.obterTexto("descComida"));
		Assert.assertEquals("Escolaridade: superior",dsl.obterTexto("descEscolaridade"));
		Assert.assertEquals("Esportes: Futebol", dsl.obterTexto("descEsportes"));
	}

	@Test
	public void DeveValidarNomeObrigatorio() {
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void DeveValidarSobreNomeObrigatorio() {
		dsl.escreve("elementosForm:nome", "Charles");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio",  dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void DeveValidarSexoObrigatorio() {
		dsl.escreve("elementosForm:nome", "Charles");
		dsl.escreve("elementosForm:sobrenome", "Batista Veiga");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio",  dsl.alertaObterTextoEAceita());
		}
	
	@Test
	public void DeveValidarComidaVegetariana() {
		dsl.escreve("elementosForm:nome", "Charles");
		dsl.escreve("elementosForm:sobrenome", "Batista Veiga");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
		}
		
	@Test
	public void DeveValidarEsportistaIndeciso() {
		dsl.escreve("elementosForm:nome", "Charles");
		dsl.escreve("elementosForm:sobrenome", "Batista Veiga");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
		}
}