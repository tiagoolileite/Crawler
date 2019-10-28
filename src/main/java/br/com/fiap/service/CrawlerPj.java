package br.com.fiap.service;

import java.io.IOException;
import java.util.List;

import br.com.fiap.model.PJJsonModel;
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
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ConsomeApiPj apiPj = new ConsomeApiPj();
					PJRepository pjRepository = new PJRepository();
					List<PJJsonModel> pessoasJJson = apiPj.ConsomeApiAguardando("Aguardando");
					pjRepository.saveAll(pessoasJJson);
					
					for(PJJsonModel pj:pessoasJJson) {
						
						ArispCrawler arisp = new ArispCrawler();
						try {
							statusArisp = arisp.mainArispFlowPj(pj);
						} catch (InterruptedException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						CadespCrawler cadesp = new CadespCrawler();
						statusCadesp = cadesp.mainCadespFlow(pj);
						CagedCrawler caged = new CagedCrawler();
						statusCaged = caged.mainCagedFlowPj(pj);
					}
						
				} catch (Exception e) {
					e.printStackTrace();
					String msg = "Erro, pode ser q o servidor web não esta rodando" + e;
					System.out.println(msg);
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					ConsomeApiPj apiPj = new ConsomeApiPj();
					PJRepository pjRepository = new PJRepository();
					List<PJJsonModel> pessoasJJson = apiPj.ConsomeApiAguardando("Aguardando");
					pjRepository.saveAll(pessoasJJson);
					
					for(PJJsonModel pj:pessoasJJson) {
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
					}
				}catch (Exception e) {
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
			HttpComunication.editStatusPj(pj);
			System.out.println("Status de " + pj.getRazaoSocial() + ", (id: " + pj.getIdPj() + ") alterado para Pronto\n");
		} catch (IOException e) {
			System.out.println("Não foi possível alterar o status (Para pronto) de " +pj.getRazaoSocial() + ", (ID: " + pj.getIdPj() + ")!");
			e.printStackTrace();
		}
	}
	else {
		try {
			HttpComunication.editStatusPjerror(pj);
		} catch (IOException e) {
			System.out.println("Não foi possível alterar o status (Para erro) de " +pj.getRazaoSocial() + ", (ID: " + pj.getIdPj() + ")!");
			e.printStackTrace();
		}
	}
	*/