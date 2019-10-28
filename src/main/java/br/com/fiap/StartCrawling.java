package br.com.fiap;

import br.com.fiap.service.CrawlerPf;
import br.com.fiap.service.CrawlerPj;
import relatorio.CriaPdf;

public class StartCrawling {
	public static void main(String[] args) {
		CriaPdf relatorio = new CriaPdf();
		relatorio.relatorioPdfPf();
		/*
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				CrawlerPf crwlPf = new CrawlerPf();
				crwlPf.PessoaFiscia();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				CrawlerPj crwlPj = new CrawlerPj();
				crwlPj.PessoaJurídica();
			}
		}).start();
		*/
	}
}
