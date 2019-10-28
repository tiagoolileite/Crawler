package br.com.fiap.service;

import java.io.IOException;
import java.util.List;

import br.com.fiap.model.PFJsonModel;
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
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ConsomeApiPf apiPf = new ConsomeApiPf();
					PFRepository pfRepository = new PFRepository();
					List<PFJsonModel> pessoasFJson = apiPf.ConsomeApiAguardando("Aguardando");
					pfRepository.saveAll(pessoasFJson);
					
					for(PFJsonModel pf: pessoasFJson) {	
						SivecCrawler sivec = new SivecCrawler();
						statusSivec = sivec.mainSivecFlow(pf);
						/*
						ArispCrawler arisp = new ArispCrawler();
						try {
							statusArisp = arisp.mainArispFlowPf(pf);//
						} catch (Exception e) {
							 //TODO Auto-generated catch block
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
						
						SielCrawler siel = new SielCrawler();
						try {
						statusSiel = siel.mainSielFlowPf(pf);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/
					}
				}
					catch (Exception e) {
						e.printStackTrace();
						String msg = "Erro, pode ser q o servidor web não esta rodando" + e;
						System.out.println(msg);
					}
			}
		}).start();
	}
}
/*
if(statusArisp == true) {
	try {
		HttpComunication.editStatusPf(pf);
		System.out.println("Status de " + pf.getNome() + ", (id: " + pf.getIdPf() + ") alterado para Pronto\n");
	} catch (IOException e) {
		System.out.println("Não foi possível alterar o status (Para pronto) de " +pf.getNome() + ", (ID: " + pf.getIdPf() + ")!");
		e.printStackTrace();
	}
}
else {
	try {
		HttpComunication.editStatusPferror(pf);
	} catch (IOException e) {
		System.out.println("Não foi possível alterar o status (Para erro) de " +pf.getNome() + ", (ID: " + pf.getIdPf() + ")!");
		e.printStackTrace();
	}
}
*/