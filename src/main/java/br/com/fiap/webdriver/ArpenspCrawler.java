package br.com.fiap.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.RegistroArpenspModel;
import br.com.fiap.repository.RegistroArpenspRepository;

public class ArpenspCrawler {

	public boolean mainArpenspFlow(PFJsonModel pfJson) {
		boolean ok = false;
		try {
			WebDriver driver = MainWebDriver.AutenticaMock();
			RegistroArpenspRepository arpenspRepository = new RegistroArpenspRepository();
			//Abre o portal Arisp no portal do prof
			String urlArpensp = driver.findElement(By.linkText("Arpenp"))
					.getAttribute("href");
			driver.get(urlArpensp);
			
			String crcJud = driver.findElement(By.cssSelector("div.col-3:nth-child(2) > div:nth-child(1) > a:nth-child(1)"))
					.getAttribute("href");
			driver.get(crcJud);
			
			driver.findElement(By.cssSelector("html body div#corpo div#menu div#wrapper ul.menu li.item3")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			@SuppressWarnings("unused")
			WebElement element;
			
			element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Busca na CRC")));
			driver.findElement(By.linkText("Busca na CRC")).click();
			
			driver.findElement(By.cssSelector(".redondo > form:nth-child(3) > table:nth-child(1) > "
					+ "tbody:nth-child(1) > tr:nth-child(2) > "
					+ "td:nth-child(2) > input:nth-child(1)"))
					.sendKeys(String.valueOf(pfJson.getNrProcessoArpensp()));;
				
			RegistroArpenspModel registroArpensp = new RegistroArpenspModel();		
					
			driver.findElement(By.id("btn_pesquisar")).click();
			String cartorioDeRegistro = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[1]/tbody/tr[1]/td[2]/b")).getText();
			String nrCns = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[1]/tbody/tr[2]/td[2]/b")).getText();
			String uf = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[1]/tbody/tr[3]/td[2]/b")).getText();
			String nomeConjuge1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[2]/td[2]")).getText();
			String nomeConjuge2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[4]/td[2]")).getText();
			String novoNomeConjuge2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[5]/td[2]")).getText();
			String dtCasamento = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[6]/td[2]")).getText();
			String matricula = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[8]/td[2]/b")).getText();
			String dtEntrada = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[9]/td[2]/b")).getText();
			String dtRegistro = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[10]/td[2]")).getText();
			String acervo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[11]/td[2]")).getText();
			String nrLivro = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[12]/td[2]")).getText();
			String nrFolha = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[13]/td[2]")).getText();
			String nrRegistro = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[14]/td[2]")).getText();
			String tipoLivro = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/table[2]/tbody/tr[15]/td[2]/b")).getText();
			
			registroArpensp.setCartorioDeRegistro(cartorioDeRegistro);
			registroArpensp.setNrCns(nrCns);
			registroArpensp.setUf(uf);
			registroArpensp.setNomeConjuge1(nomeConjuge1);
			registroArpensp.setNomeConjuge2(nomeConjuge2);
			registroArpensp.setNovoNomeConjuge2(novoNomeConjuge2);
			registroArpensp.setDtCasamento(dtCasamento);
			registroArpensp.setMatricula(matricula);
			registroArpensp.setDtEntrada(dtEntrada);
			registroArpensp.setDtRegistro(dtRegistro);
			registroArpensp.setAcervo(acervo);
			registroArpensp.setNrLivro(nrLivro);
			registroArpensp.setNrFolha(nrFolha);
			registroArpensp.setNrRegistro(nrRegistro);
			registroArpensp.setTipoLivro(tipoLivro);
			
			arpenspRepository.save(registroArpensp, pfJson);
			
			driver.quit();		
			System.out.println("Executou o crawler certin da pessoa " + pfJson.getNome() + ", id" + pfJson.getIdPf() + "\n");
			ok = true;
		}
		catch (Exception e) {
			System.out.println("Não executou o crawler não, da pessoa " + pfJson.getNome() + ", id" + pfJson.getIdPf() + "\n");
			ok = false;
		}
		return ok;
	}

}
