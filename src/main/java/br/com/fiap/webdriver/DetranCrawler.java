package br.com.fiap.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.DetranModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.repository.DetranRepository;
import br.com.fiap.service.SnapShot;

public class DetranCrawler {

	public boolean mainDetranFlowPf(PFJsonModel pfJson) throws IOException, InterruptedException {
		boolean ok = false;
		try {
			File file = new File("C://Users//tleite//Pictures//imgs-mpsp//detran//pf//idPf-"+ pfJson.getIdPf());
			DetranRepository detranRepository = new DetranRepository();
			WebDriver driver = MainWebDriver.AutenticaMock();
			String urlDetran = driver.findElement(By.linkText("Detran"))
					.getAttribute("href");
			driver.get(urlDetran);
			
			driver.findElement(By.id("form:j_id563205015_44efc1ab")).sendKeys("fiap");
			driver.findElement(By.id("form:j_id563205015_44efc191")).sendKeys("mpsp");
			driver.findElement(By.id("form:j_id563205015_44efc15b")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(By.id("navigation"));
			actions.moveToElement(element).build().perform();
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Linha da Vida do Condutor")));
			String linhaVida = driver.findElement(By.linkText("Linha da Vida do Condutor"))
					.getAttribute("href");
			driver.get(linhaVida);
			String parentWindow = driver.getWindowHandle();
			
			for(int fluxo=0;fluxo<3;fluxo++) {
				DetranModel detran = new DetranModel();
				if(fluxo == 0) {
					driver.findElement(By.id("form:cpf")).sendKeys(pfJson.getCpf());
					driver.findElement(By
							.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[1]/div[2]/table[3]/tbody/tr/td/a"))
							.click();
					Thread.sleep(1000);
					Set<String> allHandles = driver.getWindowHandles();
		            for(String curWindow : allHandles){
		                driver.switchTo().window(curWindow);
		            }
					
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("viewer")));
					List<WebElement> paginasPdf;
					int i = 0;
					paginasPdf = driver.findElements(By.className("textLayer"));
					driver.findElement(By.id("scaleSelect")).click();
					driver.findElement(By.id("pageFitOption")).click();
					
					for(@SuppressWarnings("unused") WebElement paginaPdf:paginasPdf) {
						i++;
						SnapShot.takeSnapShot(driver, file.getPath() + "//condutor-pag-" + i + ".png");
					}
					Thread.sleep(1500);
					driver.close();
					driver.switchTo().window(parentWindow);
				}
				else if(fluxo == 1) {
					element = driver.findElement(By.id("navigation_a_M_18"));
					actions.moveToElement(element).build().perform();
					
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Consultar Veículo Base Estadual")));
					String veiculoEstadual = driver.findElement(By.linkText("Consultar Veículo Base Estadual"))
							.getAttribute("href");
					driver.get(veiculoEstadual);
	
					driver.findElement(By.id("form:j_id2124610415_1b3be1bd")).sendKeys(pfJson.getPlaca());
					driver.findElement(By.id("form:j_id2124610415_1b3be1e3")).sendKeys(pfJson.getCpf());
					driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[1]/div[2]/table[3]/tbody/tr/td/a/span")).click();
					Thread.sleep(1000);
					Set<String> allHandles = driver.getWindowHandles();
			        for(String curWindow : allHandles){
			            driver.switchTo().window(curWindow);
			        }
					
					List<WebElement> paginasPdf;
					int i = 0;
					paginasPdf = driver.findElements(By.className("page"));
					driver.findElement(By.id("scaleSelect")).click();
					driver.findElement(By.id("pageFitOption")).click();
					
					for(@SuppressWarnings("unused") WebElement paginaPdf:paginasPdf) {
						i++;
						try {
							SnapShot.takeSnapShot(driver, file.getPath() + "//pag-veiculo-" + i + ".png");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					driver.close();
					driver.switchTo().window(parentWindow);
					
				}
				else if(fluxo == 2) {
					element = driver.findElement(By.id("navigation_a_M_16"));
					actions.moveToElement(element).build().perform();
					element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Consultar Imagem da CNH")));
					String imgCnh = driver.findElement(By.linkText("Consultar Imagem da CNH"))
							.getAttribute("href");
					driver.get(imgCnh);
					
					driver.findElement(By.id("form:cpf")).sendKeys(pfJson.getCpf());
					String pesquisar = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[1]/div[2]/table[3]/tbody/tr/td/a"))
							.getAttribute("href");
					driver.get(pesquisar);
					
					String renach = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span")).getText();
					String categoria = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/span")).getText();
					String emissao = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/span")).getText();
					String dtNascimento = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[4]/span")).getText();
					String nomeCondutor = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/span")).getText();
					String nomePai = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/span")).getText();
					String nomeMae = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td/span")).getText();
					String registro = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[1]/span")).getText();
					String tipografico = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[2]/span")).getText();
					String identidade = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[3]/span")).getText();
					String cpf = driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[4]/span")).getText();
					
					detran.setRenach(renach);
					detran.setCategoria(categoria);
					detran.setEmissao(emissao);
					detran.setDtNascimento(dtNascimento);
					detran.setNomeCondutor(nomeCondutor);
					detran.setNomePai(nomePai);
					detran.setNomeMae(nomeMae);
					detran.setRegistro(registro);
					detran.setTipografico(tipografico);
					detran.setIdentidade(identidade);
					detran.setCpf(cpf);
					
					detranRepository.savePf(detran, pfJson);
					
					SnapShot.takeSnapShot(driver, file.getPath() + "//cnh.png");
				}
			}
			
			driver.quit();
			ok = true;
		}catch (Exception e) {
			ok = false;
		}
		return ok;
	}
	
	public boolean mainDetranFlowPj(PJJsonModel pjJson) {
		boolean ok = false;
		try {
			File file = new File("C://Users//tleite//Pictures//imgs-mpsp//detran//pj//idPj-"+ pjJson.getIdPj());
			WebDriver driver = MainWebDriver.AutenticaMock();
			String urlDetran = driver.findElement(By.linkText("Detran"))
					.getAttribute("href");
			driver.get(urlDetran);
			
			driver.findElement(By.id("form:j_id563205015_44efc1ab")).sendKeys("fiap");
			driver.findElement(By.id("form:j_id563205015_44efc191")).sendKeys("mpsp");
			driver.findElement(By.id("form:j_id563205015_44efc15b")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(By.cssSelector(""
					+ "html body.ui-layout-container div#j_id776342735_6aae4df.ui-layout-unit.ui-widget.ui-widget-content.ui-corner-all"
					+ ".ui-layout-north.ui-layout-pane.ui-layout-pane-north.ui-layout-pane-hover.ui-layout-pane-north-hover.ui-layout-pane-open-hover"
					+ ".ui-layout-pane-north-open-hover div.ui-layout-unit-content.ui-widget-content table tbody tr td."
					+ "imagem_menu_middle nav#nav ul#navigation li#navigation_li_M_18"));
			actions.moveToElement(element).build().perform();
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Consultar Veículo Base Estadual")));
			String veiculoEstadual = driver.findElement(By.linkText("Consultar Veículo Base Estadual"))
					.getAttribute("href");
			driver.get(veiculoEstadual);
			
			String parentWindow = driver.getWindowHandle();
			driver.findElement(By.id("form:j_id2124610415_1b3be1e3")).sendKeys(pjJson.getCnpj());
			driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[1]/div[2]/table[3]/tbody/tr/td/a/span")).click();
			
			Set<String> allHandles = driver.getWindowHandles();
	        for(String curWindow : allHandles){
	            driver.switchTo().window(curWindow);
	        }
	        
			List<WebElement> paginasPdf;
			int i = 0;
			paginasPdf = driver.findElements(By.id("viewerContainer"));
			driver.findElement(By.id("scaleSelect")).click();
			driver.findElement(By.id("pageFitOption")).click();
			
			for(@SuppressWarnings("unused") WebElement paginaPdf:paginasPdf) {
				i++;
				try {
					Thread.sleep(5000);
					SnapShot.takeSnapShot(driver, file.getPath() + "//pag-veiculo-" + i + ".png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.close();	
				driver.switchTo().window(parentWindow);
			}
			driver.quit();		
			ok = true;
		}catch (Exception e) {
			ok = false;
		}
		return ok;
	}
	
}
