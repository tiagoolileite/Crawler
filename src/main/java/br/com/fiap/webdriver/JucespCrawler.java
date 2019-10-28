package br.com.fiap.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.JucespModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.repository.JucespRepository;
import br.com.fiap.service.SnapShot;

public class JucespCrawler {

	public boolean mainArispFlowPj(PJJsonModel pjJson) {
		boolean ok = false;
			try {
			JucespRepository jucespRepository = new JucespRepository();
			File file = new File("C://Users//tleite//Pictures//imgs-mpsp//jucesp//pj//idPj-"+ pjJson.getIdPj());
			WebDriver driver = MainWebDriver.AutenticaMock();
			
			String urlJucesp = driver.findElement(By.linkText("Jucesp"))
					.getAttribute("href");
			driver.get(urlJucesp);
			
			driver.findElement(By.id("ctl00_cphContent_frmBuscaSimples_txtPalavraChave")).sendKeys(pjJson.getRazaoSocial());
			
			driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div[1]/div/div[1]/table/tbody/tr/td[2]/input")).click();
			
			driver.findElement(By.className("btcadastro")).click();
			
			String codEmpresa = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_gdvResultadoBusca_gdvContent_ctl02_lbtSelecionar\"]"))
					.getAttribute("href");
			driver.get(codEmpresa);
			
			JucespModel jucesp = new JucespModel();
			
			String razaoSocial = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblEmpresa\"]")).getText();
			String nireMatriz = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblNire\"]")).getText();
			String tipoEmpresa = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblDetalhes\"]")).getText();
			String dtConstituicao = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblConstituicao\"]")).getText();
			String inicioAtividade = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblAtividade\"]")).getText();
			String cnpj = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblCnpj\"]")).getText();
			String objetivo = driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[5]/td/p[2]")).getText();
			String capital = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblCapital\"]")).getText();
			String logradouro = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblLogradouro\"]")).getText();
			String nr = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblNumero\"]")).getText();
			String bairro = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblBairro\"]")).getText();
			String municipio = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblMunicipio\"]")).getText();
			String complemento = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblComplemento\"]")).getText();
			String cep = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblCep\"]")).getText();
			String uf = driver.findElement(By.xpath("//*[@id=\"ctl00_cphContent_frmPreVisualiza_lblUf\"]")).getText();
			
			jucesp.setRazaoSocial(razaoSocial);
			jucesp.setNireMatriz(nireMatriz);
			jucesp.setTipoEmpresa(tipoEmpresa);
			jucesp.setDtConstituicao(dtConstituicao);
			jucesp.setInicioAtividade(inicioAtividade);
			jucesp.setCnpj(cnpj);
			jucesp.setObjetivo(objetivo);
			jucesp.setCapital(capital);
			jucesp.setLogradouro(logradouro);
			jucesp.setNr(nr);
			jucesp.setBairro(bairro);
			jucesp.setMunicipio(municipio);
			jucesp.setComplemento(complemento);
			jucesp.setCep(cep);
			jucesp.setUf(uf);
			
			jucespRepository.save(jucesp, pjJson);
			
			driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[2]/table/tbody/tr[3]/td/div/input")).click();;
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			@SuppressWarnings("unused")
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("viewer")));
			List<WebElement> paginasPdf;
			int i = 0;
			paginasPdf = driver.findElements(By.className("page"));
			driver.findElement(By.id("scaleSelect")).click();
			driver.findElement(By.id("pageFitOption")).click();
			
			for(@SuppressWarnings("unused") WebElement paginaPdf:paginasPdf) {
				i++;
				try {
					SnapShot.takeSnapShot(driver, file.getPath() + "//pag-" + i + ".png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			driver.quit();
			ok = false;
			}catch (Exception e) {
				ok = true;
			}
		return ok;
	}

}
