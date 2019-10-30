package br.com.fiap.service;

import java.io.IOException;
import java.util.List;

import br.com.fiap.model.PJJsonModel;
import br.com.fiap.relatorio.CriaPdf;
import br.com.fiap.repository.PJRepository;
import br.com.fiap.webdriver.ArispCrawler;
import br.com.fiap.webdriver.CadespCrawler;
import br.com.fiap.webdriver.CagedCrawler;
import br.com.fiap.webdriver.CensecCrawler;
import br.com.fiap.webdriver.DetranCrawler;
import br.com.fiap.webdriver.JucespCrawler;

public class CrawlerPj {

	boolean statusArisp = false; 
	boolean statusCadesp = false; 
	boolean statusCaged = false;
	boolean statusCensec = false;
	boolean statusDetran = false;
	boolean statusJucesp = false;
	
	public void PessoaJurídica() {
		try {
			ConsomeApiPj apiPj = new ConsomeApiPj();
			PJRepository pjRepository = new PJRepository();
			List<PJJsonModel> pessoasJJson = apiPj.ConsomeApiAguardando("Aguardando");
			CriaPdf relatorio = new CriaPdf();
			pjRepository.saveAll(pessoasJJson);
				
			for(PJJsonModel pj:pessoasJJson) {
					
				ArispCrawler arisp = new ArispCrawler();
				try {
					statusArisp = arisp.mainArispFlowPj(pj);
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					/*	
				CadespCrawler cadesp = new CadespCrawler();
				statusCadesp = cadesp.mainCadespFlow(pj);
				
				CagedCrawler caged = new CagedCrawler();
				statusCaged = caged.mainCagedFlowPj(pj);
				
				JucespCrawler jucesp = new JucespCrawler();
				statusJucesp = jucesp.mainArispFlowPj(pj);
				
				CensecCrawler censec = new CensecCrawler();
				try {
					statusCensec = censec.mainCensecFlowPj(pj);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				DetranCrawler detran = new DetranCrawler();
				statusDetran = detran.mainDetranFlowPj(pj);
				
				if(statusArisp == true && statusCadesp == true && statusCaged == true && statusCensec == true 
						&& statusDetran == true && statusJucesp == true) {
					HttpComunication.editStatusPj(pj);
				}else if(statusArisp) {
					HttpComunication.editStatusPjerror(pj);
				}else if(statusCadesp) {
					HttpComunication.editStatusPjerror(pj);
				}else if(statusCaged) {
					HttpComunication.editStatusPjerror(pj);
				}else if(statusCensec) {
					HttpComunication.editStatusPjerror(pj);
				}else if(statusDetran) {
					HttpComunication.editStatusPjerror(pj);
				}else if(statusJucesp) {
					HttpComunication.editStatusPjerror(pj);
				}else if(statusArisp == false && statusCadesp == false && statusCaged == false 
						&& statusCensec == false 
						&& statusDetran == false && statusJucesp == false) {
					HttpComunication.editStatusPjerrorFull(pj);
				}
				*/
				
				relatorio.relatorioPdfPj(pj,statusArisp,statusCadesp,statusCaged,statusCensec,statusDetran,statusJucesp);
			}
					
		}catch (Exception e) {
			e.printStackTrace();
			String msg = "Erro, pode ser q o servidor web não esta rodando" + e;
			System.out.println(msg);
		}
	}
	
}