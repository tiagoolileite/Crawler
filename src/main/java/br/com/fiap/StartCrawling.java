package br.com.fiap;

import br.com.fiap.service.CrawlerPf;
import br.com.fiap.service.CrawlerPj;

public class StartCrawling {
	public static void main(String[] args) {
		
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
	}
}
