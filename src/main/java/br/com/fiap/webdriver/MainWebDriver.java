package br.com.fiap.webdriver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface MainWebDriver {
	public static WebDriver AutenticaMock() {
		WebDriver driver = ConfigNavDrive();
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/");
		driver.findElement(By.name("username")).sendKeys("fiap");
		driver.findElement(By.name("password")).sendKeys("mpsp");
		driver.findElement(By.className("btn-primary")).click();
		
		return driver;
	}
	
	public static WebDriver ConfigNavDrive() {
		System.setProperty("webdriver.gecko.driver", "C://Program Files//Selenium//geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		return (driver);
	}
	
}
