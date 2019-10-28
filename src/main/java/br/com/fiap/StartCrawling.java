package br.com.fiap;

import br.com.fiap.service.CrawlerPf;
import br.com.fiap.service.CrawlerPj;

public class StartCrawling {
	public static void main(String[] args) {
		CrawlerPf crwlPf = new CrawlerPf();
		crwlPf.PessoaFiscia();
		
		//CrawlerPj crwlPj = new CrawlerPj();
		//crwlPj.PessoaJurídica();
	}
}
