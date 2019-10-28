package br.com.fiap.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.SielModel;
import br.com.fiap.repository.SielRepository;

public class SielCrawler {

	public boolean mainSielFlowPf(PFJsonModel pfjson) throws InterruptedException {
		boolean ok = false;
		try {
			SielRepository sielRepository = new SielRepository();
			WebDriver driver = MainWebDriver.AutenticaMock();
			String urlSiel = driver.findElement(By.linkText("Siel"))
					.getAttribute("href");
			driver.get(urlSiel);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/form/table/tbody/tr[3]/td[2]/input")).click();
			
			
				Thread.sleep(2500);
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/form[2]/fieldset[1]/table/tbody/tr[1]/td[2]/input")).sendKeys(pfjson.getNome());
			driver.findElement(By.id("num_processo")).click();

				Thread.sleep(2500);
				
			driver.findElement(By.id("fechar")).click();
			
			driver.findElement(By.id("num_processo")).sendKeys(pfjson.getNrProcessoSiel());
				
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/form[2]/table/tbody/tr/td[2]/input")).click();
			
			SielModel siel = new SielModel();
			
			String nome = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[2]/td[2]")).getText();
			String titulo = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[3]/td[2]")).getText();
			String dtNascimento = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[4]/td[2]")).getText();
			String zona = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[5]/td[2]")).getText();
			String endereco = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[6]/td[2]")).getText();
			String municipio = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[7]/td[2]")).getText();
			String uf = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[8]/td[2]")).getText();
			String dtDomicilio = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[9]/td[2]")).getText();
			String nomePai = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[10]/td[2]")).getText();
			String nomeMae = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[11]/td[2]")).getText();
			String naturalidade = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[12]/td[2]")).getText();
			String codValidacao = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[13]/td[2]")).getText();
			
			siel.setNome(nome);
			siel.setTitulo(titulo);
			siel.setDtNascimento(dtNascimento);
			siel.setZona(zona);
			siel.setEndereco(endereco);
			siel.setMunicipio(municipio);
			siel.setUf(uf);
			siel.setDtDomicilio(dtDomicilio);
			siel.setNomePai(nomePai);
			siel.setNomeMae(nomeMae);
			siel.setNaturalidade(naturalidade);
			siel.setCodValidacao(codValidacao);
			
			sielRepository.save(siel, pfjson);
			
			driver.quit();	
			ok = true;
		}catch (Exception e) {
			System.out.println(e);
			ok = false;
		}
		return ok;
	}

}
