package br.com.fiap.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ProcessoArispModel;
import br.com.fiap.repository.ProcessoArispRepository;
import br.com.fiap.service.SnapShot;


public class ArispCrawler {
	
	
	
	public boolean mainArispFlowPf(PFJsonModel pf) throws Exception {//
		boolean ok = false;
		try {
			
				File file = new File("C://Users//tleite//Pictures//imgs-mpsp//arisp//pf//idPf-"+ pf.getIdPf());
				ProcessoArispRepository arispRepository = new ProcessoArispRepository();
				//String sql = "INSERT INTO TB_ARISP (id_processo,cidade,cartorio,matricula,id_pf) VALUES (?,?,?,?,?)";	
				
				//Autentica no portal que o prof criou
					WebDriver driver = MainWebDriver.AutenticaMock();
					//Abre o portal Arisp no portal do prof
					String urlArisp = driver.findElement(By.linkText("Arisp"))
							.getAttribute("href");
					driver.get(urlArisp);
					
					//Autentica no portal mockado Arisp
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.getElementById('btnCallLogin').click()");
					js.executeScript("document.getElementById('btnAutenticar').click()");
					
					//Espera carregar a pagina
					WebDriverWait wait = new WebDriverWait(driver, 60);
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("liInstituicoes")));
					//Simula movimentação do mouse em cima do texto Instituições
					element = driver.findElement(By.id("liInstituicoes"));
					Actions actions = new Actions(driver);
					actions.moveToElement(element).build().perform();
					//Depois do mouse movimentado, clica em solicitações
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-0 > ul:nth-child(1)")));
					String solicitacoes = driver.findElement(By.linkText("SOLICITAÇÕES"))
							.getAttribute("href");
					driver.get(solicitacoes);
					
					//Click no botão de continuar
					driver.findElement(By.id("Prosseguir")).click();
					
					//Espera pagina carregar
					element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
							"div.selectorAll div.checkbox input")));
					//Clica no checkbox para selecionar todas cidades
					driver.findElement(By.cssSelector("div.selectorAll div.checkbox input")).click();
					//Cria um elemento para poder realizar o Scroll da pagina
					element = driver.findElement(By.xpath("/html/body/section/div[1]"));
					//Realiza o scroll para ficar visivel o checkbox de aceitar os termos
					js.executeScript("window.scrollTo(0,1500)", element);
					//Espera o scroll ser realizado
					element = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkHabilitar")));
					//Checka o "Li e aceito"
			        driver.findElement(By.id("chkHabilitar")).click();
			        //Prossegue para proxima tela
			        driver.findElement(By.id("Prosseguir")).click();
			        
			        //Digita cpf do cara na tela e depois pesquisa
			        driver.findElement(By.id("filterDocumento")).sendKeys(pf.getCpf());
			        driver.findElement(By.id("btnPesquisar")).click();
			        
			        //Faz o scroll da tela, clica para habilitar todos os cartorios e então prossegue
			        element = driver.findElement(By.xpath("/html/body/section"));
					js.executeScript("window.scrollTo(0,13400)", element);
					driver.findElement(By.id("btnSelecionarTudo")).click();
					driver.findElement(By.id("btnProsseguir")).click();
					
					//inicia os contadores para fazer o controle da navegação em cada matricula disponível
					int i = 1;
					List<WebElement> processos;
					List<ProcessoArispModel> processosModel = new ArrayList<ProcessoArispModel>();
					//Pega a lista de matriculas disponíveis
					processos = driver.findElements(By.cssSelector("#panelMatriculas > tr > td:nth-child(4) a.list.listDetails"));
					int k = 1;
					//For para salvar a imagem de cada matricula, uma a uma
					for(WebElement processo: processos) {
						i = i+1;
						
						if(i < 9) {
							//Salvar informações disponíves antes de clicar no botão de matricula
							ProcessoArispModel processoArispModel = new ProcessoArispModel();
							element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#panelMatriculas > tr:nth-child(" 
									+i + ") > td:nth-child(1)")));
							String cidade = driver.findElement(By.cssSelector("#panelMatriculas > tr:nth-child(" 
									+i + ") > td:nth-child(1)")).getText();
							String cartorio = driver.findElement(By.cssSelector("#panelMatriculas > tr:nth-child("
									+ i + ") > td:nth-child(2)")).getText();
							String matricula = driver.findElement(By.cssSelector("#panelMatriculas > tr:nth-child("
									+ i + ") > td:nth-child(3)")).getText();
							processoArispModel.setCidade(cidade);
							processoArispModel.setCartorio(cartorio);
							processoArispModel.setMatricula(matricula);
							processoArispModel.setPf(pf);
							
							//arispRepository.saveProcPf(processoArispModel, pfJson);
							
							//Finalmente salva as informações do processo capturadas anteriormente
				            processosModel.add(processoArispModel);
							//Salva instancia da tela atual para selenium encontrar caminho de volta para aba
							String parentWindow = driver.getWindowHandle();
							
							//Clica no botão Matricula
				            js.executeScript("arguments[0].scrollIntoView(true);", processo);
				            js.executeScript("arguments[0].removeAttribute('href');", processo);
				            js.executeScript("arguments[0].click();", processo);
				      		
				            //Navega com o selenium na aba aberta
				            Set<String> allHandles = driver.getWindowHandles();
				            for(String curWindow : allHandles){
				                driver.switchTo().window(curWindow);
				            }
				            //System.out.println(driver.getCurrentUrl());
				            //Clicando na imagem para abrir o pdf
				            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > a:nth-child(2)")));
				            String matriculaImg = driver.findElement(By.cssSelector("body > a:nth-child(2)"))
									.getAttribute("href");
							driver.get(matriculaImg);
							
							//Imprimindo pdf
							element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page")));
							List<WebElement> paginasPdf;
							int j = 0;
							paginasPdf = driver.findElements(By.className("page"));
							driver.findElement(By.id("scaleSelect")).click();
							driver.findElement(By.id("pageFitOption")).click();
							for(@SuppressWarnings("unused") WebElement paginaPdf:paginasPdf) {
								j++;
								SnapShot.takeSnapShot(driver, file.getPath() + "//pt-"
										+ k + "-pag-" + j 
										+ ".png");
								//div.page:nth-child(1) > div:nth-child(2)
								//div.page:nth-child(2) > div:nth-child(2)
							}
							k++;
							allHandles = null;
							
							//Fecha aba que foi aberta
							driver.close();
							
							//Volta com o selenium para a aba principal
				            driver.switchTo().window(parentWindow);
						}
					}
				driver.quit();
				arispRepository.saveAllPf(processosModel, pf);
				 ok = true;
			
		}catch (Exception e) {
			System.out.println("Deu ruim pra fazer o crawler no Arisp pra pf :(\n" + e);
			ok = false;
		}
		return ok;
	}
		//});
		
	//}
	
	public boolean mainArispFlowPj(PJJsonModel pjJson) throws InterruptedException, IOException {
		boolean ok = false;
		try {
				File file = new File("C://Users//tleite//Pictures//imgs-mpsp//arisp//pj//idPj-"+ pjJson.getIdPj());
				ProcessoArispRepository arispRepository = new ProcessoArispRepository();
					//Autentica no portal que o prof criou
					WebDriver driver = MainWebDriver.AutenticaMock();
					//Abre o portal Arisp no portal do prof
					String urlArisp = driver.findElement(By.linkText("Arisp"))
							.getAttribute("href");
					driver.get(urlArisp);
					
					//Autentica no portal mockado Arisp
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.getElementById('btnCallLogin').click()");
					js.executeScript("document.getElementById('btnAutenticar').click()");
					
					//Espera carregar a pagina
					WebDriverWait wait = new WebDriverWait(driver, 60);
					WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("liInstituicoes")));
					//Simula movimentação do mouse em cima do texto Instituições
					element = driver.findElement(By.id("liInstituicoes"));
					Actions actions = new Actions(driver);
					actions.moveToElement(element).build().perform();
					//Depois do mouse movimentado, clica em solicitações
					element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#liInstituicoes > div > ul > li:nth-child(3) > a")));
					driver.findElement(By.cssSelector("#liInstituicoes > div > ul > li:nth-child(3) > a")).click();
					
					//Click no botão de continuar
					driver.findElement(By.id("Prosseguir")).click();
					
					//Espera pagina carregar
					element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
							"div.selectorAll div.checkbox input")));
					//Clica no checkbox para selecionar todas cidades
					driver.findElement(By.cssSelector("div.selectorAll div.checkbox input")).click();
					//Cria um elemento para poder realizar o Scroll da pagina
					element = driver.findElement(By.xpath("/html/body/section/div[1]"));
					//Realiza o scroll para ficar visivel o checkbox de aceitar os termos
					js.executeScript("window.scrollTo(0,1500)", element);
					//Espera o scroll ser realizado
					element = wait.until(ExpectedConditions.elementToBeClickable(By.id("chkHabilitar")));
					//Checka o "Li e aceito"
			        driver.findElement(By.id("chkHabilitar")).click();
			        //Prossegue para proxima tela
			        driver.findElement(By.id("Prosseguir")).click();
			        
			        //Digita cpf do cara na tela e depois pesquisa
			        
			        driver.findElement(By.id("filterDocumento")).sendKeys(pjJson.getCnpj());
			        driver.findElement(By.id("btnPesquisar")).click();
			        
			        //Faz o scroll da tela, clica para habilitar todos os cartorios e então prossegue
			        element = driver.findElement(By.xpath("/html/body/section"));
					js.executeScript("window.scrollTo(0,13400)", element);
					driver.findElement(By.id("btnSelecionarTudo")).click();
					driver.findElement(By.id("btnProsseguir")).click();
					
					//inicia os contadores para fazer o controle da navegação em cada matricula disponível
					int i = 1;
					List<WebElement> processos;
					List<ProcessoArispModel> processosModel = new ArrayList<ProcessoArispModel>();
					//Pega a lista de matriculas disponíveis
					processos = driver.findElements(By.cssSelector("#panelMatriculas > tr > td:nth-child(4) a.list.listDetails"));
					int k = 1;
					//For para salvar a imagem de cada matricula, uma a uma
					for(WebElement processo: processos) {
						i = i+1;
						
						if(i < 9) {
							//Salvar informações disponíves antes de clicar no botão de matricula
							ProcessoArispModel processoArispModel = new ProcessoArispModel();
							element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#panelMatriculas > tr:nth-child(" 
									+i + ") > td:nth-child(1)")));
							String cidade = driver.findElement(By.cssSelector("#panelMatriculas > tr:nth-child(" 
									+i + ") > td:nth-child(1)")).getText();
							String cartorio = driver.findElement(By.cssSelector("#panelMatriculas > tr:nth-child("
									+ i + ") > td:nth-child(2)")).getText();
							String matricula = driver.findElement(By.cssSelector("#panelMatriculas > tr:nth-child("
									+ i + ") > td:nth-child(3)")).getText();
							processoArispModel.setCidade(cidade);
							processoArispModel.setCartorio(cartorio);
							processoArispModel.setMatricula(matricula);
							processoArispModel.setPj(pjJson);
							//Finalmente salva as informações do processo capturadas anteriormente
				            processosModel.add(processoArispModel);
							//Salva instancia da tela atual para selenium encontrar caminho de volta para aba
							String parentWindow = driver.getWindowHandle();
							
							//Clica no botão Matricula
				            js.executeScript("arguments[0].scrollIntoView(true);", processo);
				            js.executeScript("arguments[0].removeAttribute('href');", processo);
				            js.executeScript("arguments[0].click();", processo);
				      		
				            //Navega com o selenium na aba aberta
				            Set<String> allHandles = driver.getWindowHandles();
				            for(String curWindow : allHandles){
				                driver.switchTo().window(curWindow);
				            }
				            //System.out.println(driver.getCurrentUrl());
				            //Clicando na imagem para abrir o pdf
				            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > a:nth-child(2)")));
				            String matriculaImg = driver.findElement(By.cssSelector("body > a:nth-child(2)"))
									.getAttribute("href");
							driver.get(matriculaImg);
							
							//Imprimindo pdf
							element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page")));
							List<WebElement> paginasPdf;
							int j = 0;
							paginasPdf = driver.findElements(By.className("page"));
							driver.findElement(By.id("scaleSelect")).click();
							driver.findElement(By.id("pageFitOption")).click();
							for(@SuppressWarnings("unused") WebElement paginaPdf:paginasPdf) {
								j++;
								SnapShot.takeSnapShot(driver, file.getPath() + "//pt-"
										+ k + "-pag-" + j 
										+ ".png");
								//div.page:nth-child(1) > div:nth-child(2)
								//div.page:nth-child(2) > div:nth-child(2)
							}
							k++;
							allHandles = null;
							
							//Fecha aba que foi aberta
							driver.close();
							
							//Volta com o selenium para a aba principal
				            driver.switchTo().window(parentWindow);		
							            
				            
						}
					}
				driver.quit();
				arispRepository.saveAllPj(processosModel, pjJson);
				ok = true;
		}catch (Exception e) {
			System.out.println("Deu ruim pra fazer o crawler no Arisp pra pj :(\n" + e);
			ok = false;
		}
		return ok;
	}
}