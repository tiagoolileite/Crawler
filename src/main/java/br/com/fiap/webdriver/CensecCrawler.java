package br.com.fiap.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.fiap.model.ContatoCensecModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ParteCensecModel;
import br.com.fiap.model.ResultadoCensecModel;
import br.com.fiap.repository.ContatoCensecRepository;
import br.com.fiap.repository.ParteCensecRepository;
import br.com.fiap.repository.ResultadoCensecRepository;

public class CensecCrawler {

	@SuppressWarnings("unused")
	public boolean mainCensecFlowPf(PFJsonModel pfJson) throws InterruptedException {
		boolean ok = false;
		long idCensec = 0;
		try {
			ResultadoCensecRepository censecRepository = new ResultadoCensecRepository();
			ParteCensecRepository parteCensecRepository = new ParteCensecRepository();
			ContatoCensecRepository contatoCensecRepository = new ContatoCensecRepository();
			WebDriver driver = MainWebDriver.AutenticaMock();
			
			String urlCensec = driver.findElement(By.linkText("Censec"))
					.getAttribute("href");
			driver.get(urlCensec);
			
			driver.findElement(By.id("EntrarButton")).click();
			WebElement element = driver.findElement(By.id("menucentrais"));			
			Actions action = new Actions(driver);			
			
			action.moveToElement(element).build().perform();
			Thread.sleep(2500);
			element = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[1]/div/ul/li[2]/ul/li[1]/a"));
			action.moveToElement(element).build().perform();
			Thread.sleep(2500);
			element = driver.findElement(By.id("ctl00_CESDIConsultaAtoHyperLink"));
			action.moveToElement(element).build().perform();
			Thread.sleep(2500);
			
			String consultaAlto = driver.findElement(By.id("ctl00_CESDIConsultaAtoHyperLink"))
					.getAttribute("href");
			driver.get(consultaAlto);
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_DocumentoTextBox")).sendKeys(pfJson.getCpf());
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_BuscarButton")).click();
			
			List<WebElement> resultados;
			
			resultados = driver.findElements(By.cssSelector(".rolagem > table:nth-child(1) > tbody > tr"));
			int i = 2;
			for(WebElement resultado:resultados) {
				if(i <= 2) {
					i++;
				}else if(i < 7){
				ResultadoCensecModel resultadoCensec = new ResultadoCensecModel();
				String nomeEmpresa = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+ i +"]/td[2]")).getText();
				String cpfCnpj = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+ i +"]/td[3]")).getText();
				String identidade = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[4]")).getText();
				String cartorio = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[5]")).getText();
				String tipoAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[6]")).getText();
				String livro = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[7]")).getText();
				String folha = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[8]")).getText();
				String dtAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[9]")).getText();
				
				resultadoCensec.setNomeEmpresa(nomeEmpresa);
				resultadoCensec.setCpfCnpj(cpfCnpj);
				resultadoCensec.setIdentidade(identidade);
				resultadoCensec.setCartorio(cartorio);
				resultadoCensec.setTipoAto(tipoAto);
				resultadoCensec.setLivro(livro);
				resultadoCensec.setFolha(folha);
				resultadoCensec.setDtAto(dtAto);
				
				idCensec = censecRepository.savePf(resultadoCensec, pfJson);
				i++;
				}
			}
			
			ResultadoCensecModel resultadoCensec = new ResultadoCensecModel();
			
			String nomeEmpresa = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]")).getText();
			String cpfCnpj = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[3]")).getText();
			String identidade = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[4]")).getText();
			String cartorio = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[5]")).getText();
			String tipoAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[6]")).getText();
			String livro = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[7]")).getText();
			String folha = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[8]")).getText();
			String dtAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[9]")).getText();
			
			resultadoCensec.setNomeEmpresa(nomeEmpresa);
			resultadoCensec.setCpfCnpj(cpfCnpj);
			resultadoCensec.setIdentidade(identidade);
			resultadoCensec.setCartorio(cartorio);
			resultadoCensec.setTipoAto(tipoAto);
			resultadoCensec.setLivro(livro);
			resultadoCensec.setFolha(folha);
			resultadoCensec.setDtAto(dtAto);
			
			element = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/input"));
			element.click();
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_VisualizarButton")).click();
			
			String carga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_CodigoTextBox\"]")).getText();
			String atoCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_TipoAtoDropDownList\"]")).getText();
			String dtAtoCarga = ((driver.findElement(By.id("ctl00_ContentPlaceHolder1_DiaAtoTextBox")).getText()) + "/" 
					+(driver.findElement(By.id("ctl00_ContentPlaceHolder1_MesAtoTextBox")).getText()) + "/"
					+(driver.findElement(By.id("ctl00_ContentPlaceHolder1_AnoAtoTextBox")).getText()));
			String livroCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_LivroTextBox\"]")).getText();
			String complementoLivroCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_LivroComplementoTextBox\"]")).getText();
			String folhaCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_FolhaTextBox\"]")).getText();
			String complementoFolhaCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_FolhaComplementoTextBox\"]")).getText();
			
			resultadoCensec.setCarga(carga);
			resultadoCensec.setAtoCarga(atoCarga);
			resultadoCensec.setDtAtoCarga(dtAtoCarga);
			resultadoCensec.setLivroCarga(livroCarga);
			resultadoCensec.setComplementoLivroCarga(complementoLivroCarga);
			resultadoCensec.setFolhaCarga(complementoFolhaCarga);
			resultadoCensec.setComplementoFolhaCarga(complementoFolhaCarga);
			
			idCensec = censecRepository.savePf(resultadoCensec, pfJson);
			resultadoCensec.setIdCensec(idCensec);
			
			List<WebElement> partes = driver.findElements(By.cssSelector("#ctl00_ContentPlaceHolder1_PartesUpdatePanel > table:nth-child(1) > tbody:nth-child(1) > tr"));
			List<WebElement> contatos = driver.findElements(By.cssSelector("#ctl00_ContentPlaceHolder1_DadosCartorio_DivTelefonesCartorioListView > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr"));	
			int j = 1;
			for(WebElement parte:partes) {
				if(j < 5) {
					ParteCensecModel parteModel = new ParteCensecModel();
					String nomeParte = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr["+j+"]/td[2]")).getText();
					String cpfCnpjParte = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr["+j+"]/td[3]")).getText();
					String qualidadeParte = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr["+j+"]/td[4]")).getText();
					
					parteModel.setNome(nomeParte);
					parteModel.setCpfCnpj(cpfCnpjParte);
					parteModel.setQualidade(qualidadeParte);
					
					parteCensecRepository.savePf(parteModel,resultadoCensec,pfJson);
					j++;
				}
			}
			int k = 1;
			for(WebElement contato:contatos) {
				if(k<3) {
					ContatoCensecModel contatoModel = new ContatoCensecModel();
					String telContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[1]")).getText();
					String tipoContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[2]")).getText();
					String ramalContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[3]")).getText();
					String contatoContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[4]")).getText();
					String statusContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[5]")).getText();
					
					contatoModel.setTelefone(telContato);
					contatoModel.setTipo(tipoContato);
					contatoModel.setRamal(ramalContato);
					contatoModel.setContato(contatoContato);
					contatoModel.setStatus(statusContato);
					
					contatoCensecRepository.savePf(contatoModel, resultadoCensec,pfJson);
					k++;
				}
			}
			
			driver.quit();	
	
			ok = true;
			System.out.println("Realizado o crawler de " + pfJson.getNome() + ", id " + pfJson.getIdPf() + " corretamente. \n");
		}catch (Exception e) {
			ok = false;
			System.out.println("Não foi realiado o crawler de " + pfJson.getNome() + ", id " + pfJson.getIdPf() + " corretamente. \n");
			System.out.println(e);
		}
		return ok;
	}

	public boolean mainCensecFlowPj(PJJsonModel pjJson) throws InterruptedException {
		boolean ok = false;
		long idCensec = 0;
			try {
			ResultadoCensecRepository censecRepository = new ResultadoCensecRepository();
			ParteCensecRepository parteCensecRepository = new ParteCensecRepository();
			ContatoCensecRepository contatoCensecRepository = new ContatoCensecRepository();
			WebDriver driver = MainWebDriver.AutenticaMock();
			
			String urlCensec = driver.findElement(By.linkText("Censec"))
					.getAttribute("href");
			driver.get(urlCensec);
			
			driver.findElement(By.id("EntrarButton")).click();
			WebElement element = driver.findElement(By.id("menucentrais"));			
			Actions action = new Actions(driver);			
			
			action.moveToElement(element).build().perform();
			Thread.sleep(2500);
			element = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[1]/div/ul/li[2]/ul/li[1]/a"));
			action.moveToElement(element).build().perform();
			Thread.sleep(2500);
			element = driver.findElement(By.id("ctl00_CESDIConsultaAtoHyperLink"));
			action.moveToElement(element).build().perform();
			Thread.sleep(2500);
			
			String consultaAlto = driver.findElement(By.id("ctl00_CESDIConsultaAtoHyperLink"))
					.getAttribute("href");
			driver.get(consultaAlto);
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_DocumentoTextBox")).sendKeys(pjJson.getCnpj());
			
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_BuscarButton")).click();
			
			List<WebElement> resultados;
			
			resultados = driver.findElements(By.cssSelector(".rolagem > table:nth-child(1) > tbody > tr"));
			int i = 2;
			for(@SuppressWarnings("unused") WebElement resultado:resultados) {
				if(i <= 2) {
					i++;
				}else if(i < 7){
				ResultadoCensecModel resultadoCensec = new ResultadoCensecModel();
				String nomeEmpresa = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+ i +"]/td[2]")).getText();
				String cpfCnpj = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+ i +"]/td[3]")).getText();
				String identidade = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[4]")).getText();
				String cartorio = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[5]")).getText();
				String tipoAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[6]")).getText();
				String livro = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[7]")).getText();
				String folha = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[8]")).getText();
				String dtAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr["+i+"]/td[9]")).getText();
				
				resultadoCensec.setNomeEmpresa(nomeEmpresa);
				resultadoCensec.setCpfCnpj(cpfCnpj);
				resultadoCensec.setIdentidade(identidade);
				resultadoCensec.setCartorio(cartorio);
				resultadoCensec.setTipoAto(tipoAto);
				resultadoCensec.setLivro(livro);
				resultadoCensec.setFolha(folha);
				resultadoCensec.setDtAto(dtAto);
				
				idCensec = censecRepository.savePj(resultadoCensec, pjJson);
				i++;
				}
			}
			
			ResultadoCensecModel resultadoCensec = new ResultadoCensecModel();
			
			String nomeEmpresa = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[2]")).getText();
			String cpfCnpj = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[3]")).getText();
			String identidade = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[4]")).getText();
			String cartorio = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[5]")).getText();
			String tipoAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[6]")).getText();
			String livro = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[7]")).getText();
			String folha = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[8]")).getText();
			String dtAto = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[9]")).getText();
			
			resultadoCensec.setNomeEmpresa(nomeEmpresa);
			resultadoCensec.setCpfCnpj(cpfCnpj);
			resultadoCensec.setIdentidade(identidade);
			resultadoCensec.setCartorio(cartorio);
			resultadoCensec.setTipoAto(tipoAto);
			resultadoCensec.setLivro(livro);
			resultadoCensec.setFolha(folha);
			resultadoCensec.setDtAto(dtAto);
			
			element = driver.findElement(By.xpath("/html/body/form/div[4]/div/div[3]/div[2]/div[4]/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/input"));
			element.click();
			driver.findElement(By.id("ctl00_ContentPlaceHolder1_VisualizarButton")).click();
			
			String carga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_CodigoTextBox\"]")).getText();
			String atoCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_TipoAtoDropDownList\"]")).getText();
			String dtAtoCarga = ((driver.findElement(By.id("ctl00_ContentPlaceHolder1_DiaAtoTextBox")).getText()) + "/" 
					+(driver.findElement(By.id("ctl00_ContentPlaceHolder1_MesAtoTextBox")).getText()) + "/"
					+(driver.findElement(By.id("ctl00_ContentPlaceHolder1_AnoAtoTextBox")).getText()));
			String livroCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_LivroTextBox\"]")).getText();
			String complementoLivroCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_LivroComplementoTextBox\"]")).getText();
			String folhaCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_FolhaTextBox\"]")).getText();
			String complementoFolhaCarga = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_FolhaComplementoTextBox\"]")).getText();
			
			resultadoCensec.setCarga(carga);
			resultadoCensec.setAtoCarga(atoCarga);
			resultadoCensec.setDtAtoCarga(dtAtoCarga);
			resultadoCensec.setLivroCarga(livroCarga);
			resultadoCensec.setComplementoLivroCarga(complementoLivroCarga);
			resultadoCensec.setFolhaCarga(folhaCarga);
			resultadoCensec.setComplementoFolhaCarga(complementoFolhaCarga);
			
			idCensec = censecRepository.savePj(resultadoCensec, pjJson);
			resultadoCensec.setIdCensec(idCensec);
			
			List<WebElement> partes = driver.findElements(By.cssSelector("#ctl00_ContentPlaceHolder1_PartesUpdatePanel > table:nth-child(1) > tbody:nth-child(1) > tr"));
			List<WebElement> contatos = driver.findElements(By.cssSelector("#ctl00_ContentPlaceHolder1_DadosCartorio_DivTelefonesCartorioListView > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr"));	
			int j = 1;
			for(@SuppressWarnings("unused") WebElement parte:partes) {
				if(j < 5) {
					ParteCensecModel parteModel = new ParteCensecModel();
					String nomeParte = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr["+j+"]/td[2]")).getText();
					String cpfCnpjParte = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr["+j+"]/td[3]")).getText();
					String qualidadeParte = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr["+j+"]/td[4]")).getText();
					
					parteModel.setNome(nomeParte);
					parteModel.setCpfCnpj(cpfCnpjParte);
					parteModel.setQualidade(qualidadeParte);
					
					parteCensecRepository.savePj(parteModel,resultadoCensec,pjJson);
					j++;
				}
			}
			int k = 1;
			for(@SuppressWarnings("unused") WebElement contato:contatos) {
				if(k<3) {
					ContatoCensecModel contatoModel = new ContatoCensecModel();
					String telContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[1]")).getText();
					String tipoContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[2]")).getText();
					String ramalContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[3]")).getText();
					String contatoContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[4]")).getText();
					String statusContato = driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr["+k+"]/td[5]")).getText();
					
					contatoModel.setTelefone(telContato);
					contatoModel.setTipo(tipoContato);
					contatoModel.setRamal(ramalContato);
					contatoModel.setContato(contatoContato);
					contatoModel.setStatus(statusContato);
					
					contatoCensecRepository.savePj(contatoModel, resultadoCensec,pjJson);
					k++;
				}
			}
			
			driver.quit();	
	
			ok = true;
			System.out.println("Realizado o crawler de " + pjJson.getRazaoSocial() + ", id " + pjJson.getIdPj() + " corretamente. \n");
			}catch (Exception e) {
				ok = false;
			}
		return ok;
	}

}
