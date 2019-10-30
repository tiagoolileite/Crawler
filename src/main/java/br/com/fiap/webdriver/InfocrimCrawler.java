package br.com.fiap.webdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.service.SnapShot;

public class InfocrimCrawler {

	public boolean mainInfoCrimFlow(PFJsonModel pfJson) {
		boolean ok = false;
		try {
			File file = new File("C://Users//tleite//Pictures//imgs-mpsp//infocrim//pf//idPf-"+ pfJson.getIdPf());
			WebDriver driver = MainWebDriver.AutenticaMock();
			
			String urlInfocrim = driver.findElement(By.linkText("Infocrim"))
					.getAttribute("href");
			driver.get(urlInfocrim);
			
			String logar = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]/a"))
					.getAttribute("href");
			driver.get(logar);
			
			String enviar = driver.findElement(By.id("submit"))
					.getAttribute("href");
			driver.get(enviar);
			
			String elaboracaoUrl = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table[3]/tbody/tr[2]/td[2]/a"))
					.getAttribute("href");
			String elaboracao = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table[3]/tbody/tr[2]/td[2]/a")).getText();
			driver.get(elaboracaoUrl);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("/html/body"));
			SnapShot.takeSnapShot(driver, file.getPath() + "//bo_"+elaboracao+"//"+"pt1.png");
			js.executeScript("window.scrollTo(0,2000)", element);
			SnapShot.takeSnapShot(driver, file.getPath() + "//bo_"+elaboracao+"//"+"pt2.png");
			
			driver.quit();
			ok = true;
		}catch (Exception e) {
			ok = false;
		}
		return ok;
	}

}
