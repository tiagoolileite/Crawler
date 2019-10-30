package br.com.fiap.service;

import java.io.IOException;
import java.util.List;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.relatorio.CriaPdf;
import br.com.fiap.repository.PFRepository;
import br.com.fiap.webdriver.ArispCrawler;
import br.com.fiap.webdriver.ArpenspCrawler;
import br.com.fiap.webdriver.CagedCrawler;
import br.com.fiap.webdriver.CensecCrawler;
import br.com.fiap.webdriver.DetranCrawler;
import br.com.fiap.webdriver.InfocrimCrawler;
import br.com.fiap.webdriver.SielCrawler;
import br.com.fiap.webdriver.SivecCrawler;

public class CrawlerPf {
		
	boolean statusArisp = false;
	boolean statusArpensp = false;
	boolean statusCaged = false;
	boolean statusCensec = false;
	boolean statusDetran = false;
	boolean statusInfocrim = false;
	boolean statusSiel = false;
	boolean statusSivec = false;
	
	public void PessoaFiscia(){
		try{
			ConsomeApiPf apiPf = new ConsomeApiPf();
			PFRepository pfRepository = new PFRepository();
			List<PFJsonModel> pessoasFJson = apiPf.ConsomeApiAguardando("Aguardando");
			CriaPdf relatorio = new CriaPdf();
			pfRepository.saveAll(pessoasFJson);
			
			for(PFJsonModel pf: pessoasFJson) {
				ArispCrawler arisp = new ArispCrawler();
				try {
					statusArisp = arisp.mainArispFlowPf(pf);//
				} catch (Exception e) {
				e.printStackTrace();
				}
				
				ArpenspCrawler arpensp = new ArpenspCrawler();
				statusArpensp = arpensp.mainArpenspFlow(pf);
				
				
				CagedCrawler caged = new CagedCrawler();
				statusCaged = caged.mainCagedFlowPf(pf);
		
				CensecCrawler censec = new CensecCrawler();
				try {
					statusCensec = censec.mainCensecFlowPf(pf);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				DetranCrawler detran = new DetranCrawler();
				try {
					statusDetran = detran.mainDetranFlowPf(pf);
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
				InfocrimCrawler infocrim = new InfocrimCrawler();
				statusInfocrim = infocrim.mainInfoCrimFlow(pf);
				
				
				SivecCrawler sivec = new SivecCrawler();
				statusSivec = sivec.mainSivecFlow(pf);
				
				SielCrawler siel = new SielCrawler();
				try {
					statusSiel = siel.mainSielFlowPf(pf);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(statusArisp == true && statusArpensp == true && statusCaged == true
						&& statusCensec == true && statusDetran == true && statusInfocrim == true 
						&& statusSiel == true && statusSivec == true) {
					HttpComunication.editStatusPf(pf);
				}else if(statusArisp == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusArpensp == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusCaged == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusCensec == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusDetran == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusInfocrim == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusSiel == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusSivec == false) {
					HttpComunication.editStatusPferror(pf);
				}else if(statusArisp == false && statusArpensp == false && statusCaged == false
						&& statusCensec == false && statusDetran == false && statusInfocrim == false 
						&& statusSiel == false && statusSivec == false) {
					HttpComunication.editStatusPferrorFull(pf);
				}
	
				relatorio.relatorioPdfPf(pf,statusArisp,statusArpensp,statusCaged,statusCensec,statusDetran,statusInfocrim,statusSiel,statusSivec);
			}
		}catch (Exception e) {
		e.printStackTrace();
		String msg = "Erro, pode ser q o servidor web não esta rodando" + e;
		System.out.println(msg);
		}

	}
}