import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {
	@Test
	public void teste() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\charl\\Downloads\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\charl\\Downloads\\Chromedriver.exe");
		//System.setProperty("webdriver.msedge.driver", "C:\\Users\\charl\\Downloads\\msedgedriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new EdgeDriver();
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().setPosition(new Point(200,200));
		//driver.manage().window().setSize(new Dimension(100,100));
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.close();
	}
}