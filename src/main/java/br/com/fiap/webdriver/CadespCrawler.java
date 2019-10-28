package br.com.fiap.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.CadespModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.repository.CadespRepository;

public class CadespCrawler {

	public boolean mainCadespFlow(PJJsonModel pjJson) {
		boolean ok = false;
		try {
			WebDriver driver = MainWebDriver.AutenticaMock();
			CadespRepository cadespRepository = new CadespRepository();
			
			String cadesp = driver.findElement(By.linkText("Cadesp"))
					.getAttribute("href");
			driver.get(cadesp);
			
			driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_loginControl_UserName")).sendKeys("fiap");
			driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_loginControl_Password")).sendKeys("mpsp");
			driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_loginControl_loginButton")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_menuPlaceHolder_menuControl1_LoginView1_menuSuperiorn1")));
			element = driver.findElement(By.id("ctl00_menuPlaceHolder_menuControl1_LoginView1_menuSuperiorn1"));
			
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_menuPlaceHolder_menuControl1_LoginView1_menuSuperiorn1")));
			String cadastro = driver.findElement(By.linkText("Cadastro"))
					.getAttribute("href");
			driver.get(cadastro);
			
			//driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_lstIdentificacao")).click();
			Select drpCnpj = new Select(driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_lstIdentificacao")));
			drpCnpj.selectByVisibleText("CNPJ");
			
			driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_txtIdentificacao")).sendKeys(pjJson.getCnpj());
			driver.findElement(By.id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_btnConsultarEstabelecimento")).click();
			
			CadespModel cadCadesp = new CadespModel();
			String iE = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]")).getText();
			String situacaoCadesp = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]")).getText();
			String dtInstituicaoEstado = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]")).getText();
			String nomeEmpresarial = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
			String regimeEstadual = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[4]/td[3]")).getText();
			String drt = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();
			String postoFiscal = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[5]/td[3]")).getText();
			String nire = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]")).getText();
			String ocorrenciaFiscal = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]")).getText();
			String tipoUnidade = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[10]/td[2]")).getText();
			String dtInicioIe = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[4]")).getText();
			String formasAtuacao = driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[10]/td[4]/table/tbody/tr/td/table/tbody/tr/td")).getText();
			
			cadCadesp.setiE(iE);
			cadCadesp.setSituacaoCadesp(situacaoCadesp);
			cadCadesp.setDtInstituicaoEstado(dtInstituicaoEstado);
			cadCadesp.setNomeEmpresarial(nomeEmpresarial);
			cadCadesp.setRegimeEstadual(regimeEstadual);
			cadCadesp.setDrt(drt);
			cadCadesp.setPostoFiscal(postoFiscal);
			cadCadesp.setNire(nire);
			cadCadesp.setOcorrenciaFiscal(ocorrenciaFiscal);
			cadCadesp.setTipoUnidade(tipoUnidade);
			cadCadesp.setDtInicioIe(dtInicioIe);
			cadCadesp.setFormasAtuacao(formasAtuacao);
			
			driver.quit();	
			
			cadespRepository.save(cadCadesp, pjJson);
			
			ok = true;
		}
		catch (Exception e) {
			ok = false;
		}
		return ok;
	}

}
