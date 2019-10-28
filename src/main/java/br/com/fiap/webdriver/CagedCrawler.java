package br.com.fiap.webdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import br.com.fiap.model.CagedModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.repository.CagedRepository;
import br.com.fiap.service.SnapShot;

public class CagedCrawler {

	public boolean mainCagedFlowPf(PFJsonModel pfJson) {
		boolean ok = false;
		try {
			File file = new File("C://Users//tleite//Pictures//imgs-mpsp//caged//pf//idPf-"+ pfJson.getIdPf());
			CagedRepository cagedRepository = new CagedRepository();
			WebDriver driver = MainWebDriver.AutenticaMock();
			
			String urlCaged = driver.findElement(By.linkText("Caged"))
					.getAttribute("href");
			driver.get(urlCaged);
			
			driver.findElement(By.id("btn-submit")).click();
			
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/ul/li[1]/a"));
			
			actions.moveToElement(element).build().perform();
			
			driver.findElement(By.id("j_idt12:idMenuLinkAutorizado")).click();
			
			Select drpPesquisa = new Select(driver.findElement(By.id("formPesquisarAutorizado:slctTipoPesquisaAutorizado")));
			drpPesquisa.selectByVisibleText("CPF");
			
			CagedModel caged = new CagedModel();
			
			String logradouro = driver.findElement(By.xpath("//*[@id=\"txt3_logradouro020\"]")).getText();
			String bairroDistrito = driver.findElement(By.xpath("//*[@id=\"txt4_bairro020\"]")).getText();
			String municipio = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[3]/div/div[2]")).getText();
			String uf = driver.findElement(By.xpath("//*[@id=\"txt7_uf020\"]")).getText();
			String cep = driver.findElement(By.xpath("//*[@id=\"txt8_cep020\"]")).getText();
			String nomContato = driver.findElement(By.xpath("//*[@id=\"txt_nome_contato\"]")).getText();
			String cpfContato = driver.findElement(By.xpath("//*[@id=\"txt_contato_cpf\"]")).getText();
			String telContato = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[3]/div[1]/div[2]")).getText();
			String emailContato = driver.findElement(By.xpath("//*[@id=\"txt11_email\"]")).getText();
			String ramalContato = driver.findElement(By.xpath("//*[@id=\"txt10_ramal020\"]")).getText();
			
			caged.setLogradouro(logradouro);
			caged.setBairroDistrito(bairroDistrito);
			caged.setMunicipio(municipio);
			caged.setUf(uf);
			caged.setCep(cep);
			caged.setNomContato(nomContato);
			caged.setCpfContato(cpfContato);
			caged.setTelContato(telContato);
			caged.setEmailContato(emailContato);
			caged.setRamalContato(ramalContato);
			
			element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/ul/li[1]/a"));
			actions.moveToElement(element).build().perform();
			
			driver.findElement(By.id("j_idt12:idMenuLinkTrabalhador")).click();
			
			driver.findElement(By.id("formPesquisarTrabalhador:txtChavePesquisa")).sendKeys(String.valueOf(pfJson.getPisPasep()));
			
			driver.findElement(By.id("formPesquisarTrabalhador:submitPesqTrab")).click();
			
			String pisBase = driver.findElement(By.xpath("//*[@id=\"txt1_Pis028\"]")).getText();
			String ctpsSerie = driver.findElement(By.xpath("//*[@id=\"txt5_Ctps027\"]")).getText();
			String situacaoPis = driver.findElement(By.xpath("//*[@id=\"txt4_SitPis027\"]")).getText();
			String nacionalidade = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[4]/div[1]/div[2]")).getText();
			String grauInstrucao = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[5]/div/div[2]")).getText();
			String deficiente = driver.findElement(By.xpath("//*[@id=\"txt13_Def027\"]")).getText();
			String sexo = driver.findElement(By.xpath("//*[@id=\"txt6_Sexo027\"]")).getText();
			String racaCor = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[4]/div[2]/div[2]")).getText();
			String tempoTrabalho = driver.findElement(By.xpath("//*[@id=\"txt26_Caged027\"]")).getText();
			String rais = driver.findElement(By.xpath("//*[@id=\"txt27_Rais027\"]")).getText();
			
			caged.setPisBase(pisBase);
			caged.setCtpsSerie(ctpsSerie);
			caged.setSituacaoPis(situacaoPis);
			caged.setNacionalidade(nacionalidade);
			caged.setGrauInstrucao(grauInstrucao);
			caged.setDeficiente(deficiente);
			caged.setSexo(sexo);
			caged.setRacaCor(racaCor);
			caged.setTempoTrabalho(tempoTrabalho);
			caged.setRais(rais);
			
			String imprimirVinculos = driver.findElement(By.linkText("Imprimir Vínculos Consolidados"))
					.getAttribute("href");
			driver.get(imprimirVinculos);
			
			Thread.sleep(6000);
			SnapShot.takeSnapShot(driver, file.getPath() + "//vinculo.png");
			
			driver.quit();
			
			cagedRepository.savePf(caged, pfJson);
			
			ok = true;
		
			System.out.println("Executou bem o crawler caged para o " + pfJson.getNome() + ", id "+ pfJson.getIdPf() + "\n");
		}
		catch (Exception e) {
			System.out.println("Não executou bem o crawler caged para o " + pfJson.getNome() + ", id "+ pfJson.getIdPf() + "\n" + e);
			ok = false;
		}
		return ok;
	}

	public boolean mainCagedFlowPj(PJJsonModel pjJson) {
		boolean ok = false;
		try {
			WebDriver driver = MainWebDriver.AutenticaMock();
			CagedRepository cagedRepository = new CagedRepository();
			
			String urlCaged = driver.findElement(By.linkText("Caged"))
					.getAttribute("href");
			driver.get(urlCaged);
			
			driver.findElement(By.id("btn-submit")).click();
			
			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/ul/li[1]/a"));
			
			actions.moveToElement(element).build().perform();
			
			driver.findElement(By.id("j_idt12:idMenuLinkAutorizado")).click();
			
			driver.findElement(By.id("formPesquisarAutorizado:txtChavePesquisaAutorizado014")).sendKeys(pjJson.getCnpj());
			driver.findElement(By.id("formPesquisarAutorizado:bt027_8")).click();
			
			CagedModel caged = new CagedModel();
			
			String logradouro = driver.findElement(By.xpath("//*[@id=\"txt3_logradouro020\"]")).getText();
			String bairroDistrito = driver.findElement(By.xpath("//*[@id=\"txt4_bairro020\"]")).getText();
			String municipio = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[3]/div/div[2]")).getText();
			String uf = driver.findElement(By.xpath("//*[@id=\"txt7_uf020\"]")).getText();
			String cep = driver.findElement(By.xpath("//*[@id=\"txt8_cep020\"]")).getText();
			String nomContato = driver.findElement(By.xpath("//*[@id=\"txt_nome_contato\"]")).getText();
			String cpfContato = driver.findElement(By.xpath("//*[@id=\"txt_contato_cpf\"]")).getText();
			String telContato = driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[3]/div[1]/div[2]")).getText();
			String emailContato = driver.findElement(By.xpath("//*[@id=\"txt11_email\"]")).getText();
			String ramalContato = driver.findElement(By.xpath("//*[@id=\"txt10_ramal020\"]")).getText();
			
			caged.setLogradouro(logradouro);
			caged.setBairroDistrito(bairroDistrito);
			caged.setMunicipio(municipio);
			caged.setUf(uf);
			caged.setCep(cep);
			caged.setNomContato(nomContato);
			caged.setCpfContato(cpfContato);
			caged.setTelContato(telContato);
			caged.setEmailContato(emailContato);
			caged.setRamalContato(ramalContato);
			
			element = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/ul/li[1]/a"));
			actions.moveToElement(element).build().perform();
			driver.findElement(By.id("j_idt12:idMenuLinkEmpresaCaged")).click();
			
			driver.findElement(By.id("formPesquisarEmpresaCAGED:txtcnpjRaiz")).sendKeys(pjJson.getCnpj());
			driver.findElement(By.id("formPesquisarEmpresaCAGED:btConsultar")).click();
			
			String nrFiliais = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtNumFiliais\"]")).getText();
			String admissoes = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtTotalNumAdmissoes\"]")).getText();
			String variacaoAbsoluta = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtTotalVariacaoAbosulta\"]")).getText();
			String totalVinculos = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtTotalVinculos\"]")).getText();
			String desligamentos = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtTotalNumDesligamentos\"]")).getText();
			String primeiroDia = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtTotalNumPrimDia\"]")).getText();
			String ultimoDia = driver.findElement(By.xpath("//*[@id=\"formResumoEmpresaCaged:txtTotalNumUltDia\"]")).getText();
			
			caged.setNrFiliais(nrFiliais);;
			caged.setAdmissoes(admissoes);
			caged.setVariacaoAbsoluta(variacaoAbsoluta);
			caged.setTotalVinculos(totalVinculos);
			caged.setDesligamentos(desligamentos);
			caged.setPrimeiroDia(primeiroDia);
			caged.setUltimoDia(ultimoDia);
			
			driver.quit();
			
			cagedRepository.savePj(caged, pjJson);
			
			ok = true;
		}
		catch (Exception e) {
			ok = false;
		}
		return ok;
	}

}
