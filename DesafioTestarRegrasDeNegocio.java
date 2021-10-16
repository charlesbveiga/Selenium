	import static org.junit.Assert.assertEquals;

	import org.junit.Assert;
	import org.junit.Test;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class DesafioTestarRegrasDeNegocio {

		
		@Test
		public void DeveValidarNomeObrigatorio() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Nome eh obrigatorio", alert.getText());
		}
		
		@Test
		public void DeveValidarSobreNomeObrigatorio() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Charles");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		}
		
		@Test
		public void DeveValidarSexoObrigatorio() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Charles");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Batista Veiga");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
		}
		
		@Test
		public void DeveValidarComidaObrigatorio() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Charles");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Batista Veiga");
			driver.findElement(By.id("elementosForm:sexo:1")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
		}
		
		@Test
		public void DeveValidarPraticadeEsporte() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Charles");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Batista Veiga");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
			combo.selectByVisibleText("Futebol");
			combo.selectByVisibleText("O que eh esporte?");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
		
		}
		
	}


