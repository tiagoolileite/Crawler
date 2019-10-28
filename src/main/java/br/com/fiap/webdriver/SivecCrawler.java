package br.com.fiap.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.PFJsonModel;

public class SivecCrawler {

	public boolean mainSivecFlow(PFJsonModel pfJson) {
		boolean ok = false;
			try {
			WebDriver driver = MainWebDriver.AutenticaMock();
			
			String urlSivec = driver.findElement(By.linkText("Sivec"))
					.getAttribute("href");
			driver.get(urlSivec);
			
			driver.findElement(By.id("nomeusuario")).sendKeys("fiap");
			driver.findElement(By.id("senhausuario")).sendKeys("mpsp");
			driver.findElement(By.id("Acessar")).click();
			
			driver.findElement(By.xpath("/html/body/nav/div[2]/ul/li[4]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			@SuppressWarnings("unused")
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("1")));
			driver.findElement(By.id("1")).click();
			String buscaMatricula = driver.findElement(By.linkText("Matrícula SAP"))
					.getAttribute("href");
			driver.get(buscaMatricula);
			
			driver.findElement(By.id("idValorPesq")).sendKeys(String.valueOf(pfJson.getMatriculaSapSivec()));
			
			driver.findElement(By.id("procurar")).click();
			
			String nrRg = driver.findElement(By.xpath("/html/body/form/div/div[3]/div/div/div[2]/table/tbody/tr[1]/td[1]/a"))
					.getAttribute("href");
			driver.get(nrRg);
			
			driver.quit();
			ok = true;
			}catch (Exception e) {
				ok = false;
				System.out.println(e);
			}
		return ok;
	}

}
