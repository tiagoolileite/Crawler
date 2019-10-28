package br.com.fiap.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.SivecModel;
import br.com.fiap.repository.SivecRepository;

public class SivecCrawler {

	public boolean mainSivecFlow(PFJsonModel pfJson) {
		boolean ok = false;
			try {
			SivecRepository sivecRepository = new SivecRepository();
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
			
			SivecModel sivec = new SivecModel();
			
			String nome = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[1]/td[2]/span")).getText();
			String sexo = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[1]/td[5]/span")).getText();
			String dtNascimento = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[2]/td[2]/span")).getText();
			String rg = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[2]/td[5]/span")).getText();
			String tipoRg = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[3]/td[5]/span")).getText();
			String dtEmissaoRg = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[1]/td[2]/span")).getText();
			String estadoCivil = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[2]/td[2]/span")).getText();
			String naturalizado = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[3]/td[2]/span")).getText();
			String grauInstrucao = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[4]/td[2]/span")).getText();
			String nomePai = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[5]/td[2]/span")).getText();
			String nomeMae = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[6]/td[2]/span")).getText();
			String corPele = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[7]/td[2]/span")).getText();
			String alcunha = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[1]/td[5]/span")).getText();
			String naturalidade = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[2]/td[5]/span")).getText();
			String postoIdentificacao = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[3]/td[5]/span")).getText();
			String formulaFundamental = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[4]/td[5]/span")).getText();
			String corOlhos = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[5]/td[5]/span")).getText();
			String cabelo = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[6]/td[5]/span")).getText();
			String profissao = driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[7]/td[5]/span")).getText();
			String enderecoResidencial = driver.findElement(By.xpath("/html/body/form[1]/div/div[7]/div[2]/span")).getText();
			String enderecoTrabalho = driver.findElement(By.xpath("/html/body/form[1]/div/div[8]/div[2]/span")).getText();
			
			sivec.setNome(nome);
			sivec.setSexo(sexo);
			sivec.setDtNascimento(dtNascimento);
			sivec.setRg(rg);
			sivec.setTipoRg(tipoRg);
			sivec.setDtEmissaoRg(dtEmissaoRg);
			sivec.setEstadoCivil(estadoCivil);
			sivec.setNaturalizado(naturalizado);
			sivec.setGrauInstrucao(grauInstrucao);
			sivec.setNomePai(nomePai);
			sivec.setNomeMae(nomeMae);
			sivec.setCorPele(corPele);
			sivec.setAlcunha(alcunha);
			sivec.setNaturalidade(naturalidade);
			sivec.setPostoIdentificacao(postoIdentificacao);
			sivec.setFormulaFundamental(formulaFundamental);
			sivec.setCorOlhos(corOlhos);
			sivec.setCabelo(cabelo);
			sivec.setProfissao(profissao);
			sivec.setEnderecoResidencial(enderecoResidencial);
			sivec.setEnderecoTrabalho(enderecoTrabalho);
			
			sivecRepository.save(sivec,pfJson);
			
			driver.quit();
			ok = true;
			}catch (Exception e) {
				ok = false;
				System.out.println(e);
			}
		return ok;
	}

}
