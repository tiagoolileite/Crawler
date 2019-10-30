package br.com.fiap.relatorio;

import com.itextpdf.text.Element;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import br.com.fiap.model.CadespModel;
import br.com.fiap.model.CagedModel;
import br.com.fiap.model.DetranModel;
import br.com.fiap.model.JucespModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ProcessoArispModel;
import br.com.fiap.model.RegistroArpenspModel;
import br.com.fiap.model.ResultadoCensecModel;
import br.com.fiap.model.SielModel;
import br.com.fiap.model.SivecModel;
import br.com.fiap.repository.CadespRepository;
import br.com.fiap.repository.CagedRepository;
import br.com.fiap.repository.DetranRepository;
import br.com.fiap.repository.JucespRepository;
import br.com.fiap.repository.ProcessoArispRepository;
import br.com.fiap.repository.RegistroArpenspRepository;
import br.com.fiap.repository.ResultadoCensecRepository;
import br.com.fiap.repository.SielRepository;
import br.com.fiap.repository.SivecRepository;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class CriaPdf {
	public void relatorioPdfPf(PFJsonModel pfJson, boolean statusArisp, boolean statusArpensp, boolean statusCaged, boolean statusCensec, boolean statusDetran, boolean statusInfocrim, boolean statusSiel, boolean statusSivec) throws FileNotFoundException, DocumentException {
		ProcessoArispRepository arispRepository = new ProcessoArispRepository();
		RegistroArpenspRepository arpenspRepository = new RegistroArpenspRepository();
		CagedRepository cagedRepository = new CagedRepository();
		ResultadoCensecRepository censecRepository = new ResultadoCensecRepository();
		DetranRepository detranRepository = new DetranRepository();
		SielRepository sielRepository = new SielRepository();
		SivecRepository sivecRepository = new SivecRepository();
		Document document = new Document();
		List<ProcessoArispModel> processosArisp = new ArrayList<ProcessoArispModel>();
		List<RegistroArpenspModel> registrosArpensp = new ArrayList<RegistroArpenspModel>();
		List<CagedModel> cageds = new ArrayList<CagedModel>();
		List<ResultadoCensecModel> censecs = new ArrayList<ResultadoCensecModel>();
		List<DetranModel> detrans = new ArrayList<DetranModel>();
		List<SivecModel> sivecs = new ArrayList<SivecModel>();
		List<SielModel> siels = new ArrayList<SielModel>();
		try {
			new File("C://Users//tleite//documents//Relatorio_MP//PF//PF_" + pfJson.getIdPf()).mkdirs();
			OutputStream outputStream = new FileOutputStream("C://Users//tleite//documents//Relatorio_MP//PF//PF_"+ pfJson.getIdPf() +"//Relatorio_pf_"+pfJson.getIdPf()+".pdf");
			PdfWriter.getInstance(document, outputStream);
			
			document.open();
			
			Font h1 = new Font(Font.BOLD, 26, Font.BOLD);
			Paragraph cabecalho = new Paragraph("Relatório consolidado de Pessoa Física\n\n\n", h1);
			
			cabecalho.setAlignment(Element.ALIGN_CENTER);
			document.add(cabecalho);
			
			Font h2 = new Font(Font.BOLD, 22, Font.BOLD);
			Paragraph paragrafo = new Paragraph(("Pessoa Fisica -> "+ pfJson.getNome()+ "\n"),h2);
			document.add(paragrafo);
			
			Font h3 = new Font(Font.BOLD, 18, Font.BOLD);
			Font font = new Font(Font.BOLD, 12, Font.NORMAL);
			Font error = new Font(Font.BOLD, 22, Font.BOLD,new Color(255,0,0));
			Paragraph espaco = new Paragraph("\n\n");
			
			Image image;
			
			if(statusArisp == true) {
				
				Paragraph paragrafo1 = new Paragraph("Resultados Arisp\n\n", h3);
				paragrafo1.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo1);
				
				processosArisp = arispRepository.findAllById(pfJson);
				for(ProcessoArispModel processo:processosArisp) {
					Paragraph paragrafoProcesso = new Paragraph("Processo " + pfJson.getIdPf() + ": \n", font);
					Paragraph paragrafoProcesso2 = new Paragraph("	Cidade: " + processo.getCidade() + " | " + "Cartorio: " + processo.getCartorio()
					+ " | " + "Matricula: " + processo.getMatricula() + "\n",font);
					document.add(paragrafoProcesso);
					document.add(paragrafoProcesso2);
					document.add(espaco);
				}
				
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//arisp//pf//idPf-"+pfJson.getIdPf()+"//pt-1-pag-1.png");
				image.scaleAbsolute(700, 500);
				document.add(image);			
				document.add(espaco);
			}else {
				Paragraph erro1 = new Paragraph("Deu pau no Crawler do Arisp",error);
				document.add(erro1);
				document.add(espaco);
			}
			
			if(statusArpensp == true) {
				Paragraph paragrafo2 = new Paragraph("Resultados Arpensp\n\n", h3);
				paragrafo2.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo2);
				
				registrosArpensp = arpenspRepository.findAllById(pfJson);
				for(RegistroArpenspModel registro: registrosArpensp) {
					Paragraph paragrafoRegistro = new Paragraph("Registro: " + pfJson.getIdPf() + ": \n",font);
					Paragraph paragrafoRegistro2 = new Paragraph("	Cartorio: " + registro.getCartorioDeRegistro() + " | Numero de CNS: " + registro.getNrCns()
					+ " | Unidade Federal: " + registro.getUf() + "\n	Nome do Conjuge 1: " + registro.getNomeConjuge1() + " | Nome do Conjuge 2: " + registro.getNomeConjuge2()
					+ "Novo nome do conjuge 2: " + registro.getNovoNomeConjuge2() + "\n		Data do casamento: " + registro.getDtCasamento() + " | Matricula: "
					+ registro.getMatricula() + " | Data de Entrada: " + registro.getDtEntrada() + "\n		Data Registro: " + registro.getDtRegistro() + " | "
					+ "Acervo: " + registro.getAcervo() + " | Numero do Lívro: " + registro.getNrLivro() + "\n		Numero da Folha: " + registro.getNrFolha()
					+ " | Numero do Registro: " + registro.getNrRegistro() + " | Tipo do Lívro: " + registro.getTipoLivro(), font);
					document.add(paragrafoRegistro);
					document.add(paragrafoRegistro2);
					document.add(espaco);
				}
			}else {
				Paragraph erro2 = new Paragraph("Deu pau no Crawler do Arpensp",error);
				document.add(erro2);
				document.add(espaco);
			}
			
			if(statusCaged == true) {
				Paragraph paragrafo3 = new Paragraph("Resultados Caged\n\n", h3);
				paragrafo3.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo3);
				
				
				cageds = cagedRepository.findAllById(pfJson);
				for(CagedModel caged:cageds) {
					Paragraph paragrafoCaged = new Paragraph("Caged " + pfJson.getIdPf() + ": \n",font);
					Paragraph paragrafoCaged2 = new Paragraph("	  Logradouro: "+caged.getLogradouro() +" | Bairro: "+caged.getBairroDistrito()+" | Municipio: "+caged.getMunicipio()
					+"\n	UF: "+caged.getUf()+" | CEP: "+caged.getCep()+" | Nome Contato: "+caged.getNomContato()
					+"\n	CPF Contato: "+caged.getCpfContato()+" | Telefone Contato: "+caged.getTelContato()+" | Email Contato: "+caged.getEmailContato()
					+"\n	Ramal Contato: "+caged.getRamalContato()+" | Numero de Filiais: "+caged.getNrFiliais()+" | Serie CTPS: "+caged.getCtpsSerie()
					+"\n	Situacão PIS: "+caged.getSituacaoPis()+" | Nacionalidade: "+caged.getNacionalidade()+" | Grau de Instrução: "+caged.getGrauInstrucao()
					+"\n	É deficiente ? "+caged.getDeficiente()+" | Sexo: "+caged.getSexo()+" | Raca/Cor: "+caged.getRacaCor()
					+"\n	Tempo de Trabalho: "+caged.getTempoTrabalho()+"Rais: "+caged.getRais(), font);
					document.add(paragrafoCaged);
					document.add(paragrafoCaged2);
					document.add(espaco);
				}
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//caged//pf//idPf-"+pfJson.getIdPf()+"//vinculo.png");
				image.scaleAbsolute(500, 300);
				document.add(image);			
				document.add(espaco);
			}else {
				Paragraph erro3 = new Paragraph("Deu pau no Crawler do Caged",error);
				document.add(erro3);
				document.add(espaco);
			}
			
			if(statusCensec == true) {
				Paragraph paragrafo4 = new Paragraph("Resultados Censec\n\n", h3);
				paragrafo4.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo4);
				
				censecs = censecRepository.findAllById(pfJson);			
				for(ResultadoCensecModel censec:censecs) {
					Paragraph paragrafoCensec = new Paragraph("Censec " + pfJson.getIdPf() + ": \n",font);
					Paragraph paragrafoCensec2 = new Paragraph("	Nome empresa: " +censec.getNomeEmpresa()+" | CPF/CNPJ: " +censec.getCpfCnpj()+" | Identidade: " +censec.getIdentidade()
					+"\n	Cartorio: "+censec.getCartorio()+" | Tipo de Ato: "+censec.getTipoAto()+" | Livro: "+censec.getLivro()
					+"\n	Folha: " +censec.getFolha()+" | Data do Ato: " +censec.getDtAto() + " | Carga: "+censec.getCarga()
					+"\n	Ato da Carga: "+censec.getAtoCarga()+" | Data Ato da Carga: "+censec.getDtAtoCarga()+" | Livro Carga: "+censec.getLivroCarga()
					+"\n	Complemento do Livro da Carga: " +censec.getComplementoLivroCarga()+" | Folha Carga: " + censec.getFolhaCarga()+" | Complemento Folha Carga: " +censec.getComplementoFolhaCarga());
					document.add(paragrafoCensec);
					document.add(paragrafoCensec2);
					document.add(espaco);
				}
			}else {
				Paragraph erro4 = new Paragraph("Deu pau no Crawler do Censec",error);
				document.add(erro4);
				document.add(espaco);
			}
			
			if(statusDetran == true) {
				Paragraph paragrafo5 = new Paragraph("Resultados Detran\n\n", h3);
				paragrafo5.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo5);
				
				detrans = detranRepository.findAllById(pfJson);
				for(DetranModel detran:detrans) {
					Paragraph paragrafoDetran = new Paragraph("Detran: " + pfJson.getIdPf() + ": \n",font);
					Paragraph paragrafoDetran2 = new Paragraph("	Renach: " + detran.getRenach() + " | Categoria: " + detran.getCategoria() + " | Emissão: " 
					+"\n	Data de Nascimento: "+detran.getDtNascimento()+" | Nome do Condutor: "+detran.getNomeCondutor()+" | Nome do Pai: "+detran.getNomePai()
					+"\n	Nome da Mãe: "+detran.getNomeMae()+" | Registro: "+detran.getRegistro()+" | Tipografico: " +detran.getTipografico()
					+"\n	Identidade: "+detran.getIdentidade()+" | "+detran.getCpf());
					document.add(paragrafoDetran);
					document.add(paragrafoDetran2);
					document.add(espaco);
				}
				
				Paragraph cnh = new Paragraph("CNH\n", h3);
				document.add(cnh);
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//detran//pf//idPf-"+pfJson.getIdPf()+"//cnh.png");
				image.scaleAbsolute(500, 300);
				document.add(image);			
				document.add(espaco);
				
				Paragraph condutor = new Paragraph("Condutor\n", h3);
				document.add(condutor);
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//detran//pf//idPf-"+pfJson.getIdPf()+"//condutor-pag-1.png");
				image.scaleAbsolute(500, 300);
				document.add(image);			
				document.add(espaco);
				
				Paragraph veiculo = new Paragraph("Veiculo\n", h3);
				document.add(veiculo);
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//detran//pf//idPf-"+pfJson.getIdPf()+"//pag-veiculo-1.png");
				image.scaleAbsolute(500, 300);
				document.add(image);			
				document.add(espaco);
			}else {
				Paragraph erro5 = new Paragraph("Deu pau no Crawler do Detran",error);
				document.add(erro5);
				document.add(espaco);
			}
			
			if(statusInfocrim == true) {
				Paragraph paragrafo6 = new Paragraph("Resultados Infocrim\n\n", h3);
				paragrafo6.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo6);
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//infocrim//pf//idPf-"+pfJson.getIdPf()+"//bo_79//2014//pt1.png");
				image.scaleAbsolute(500, 300);
				document.add(image);			
				document.add(espaco);
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//infocrim//pf//idPf-"+pfJson.getIdPf()+"//bo_79//2014//pt2.png");
				image.scaleAbsolute(500, 300);
				document.add(image);			
				document.add(espaco);
			}else {
				Paragraph erro6 = new Paragraph("Deu pau no Crawler do Infocrim",error);
				document.add(erro6);
				document.add(espaco);
			}
			
			if(statusSivec == true) {
				Paragraph paragrafo7 = new Paragraph("Resultados Sivec\n\n", h3);
				paragrafo7.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo7);
				
				sivecs = sivecRepository.findAllById(pfJson); 
				for(SivecModel sivec:sivecs) {
					Paragraph paragrafoSivec = new Paragraph("Sivec: "+pfJson.getIdPf()+"\n",font);
					Paragraph paragrafoSivec2 = new Paragraph("		Nome: "+sivec.getNome()+" | Sexo: "+sivec.getSexo()+" | Data de Nascimento: "+sivec.getDtNascimento()
					+"\n	RG: "+sivec.getRg()+" | Tipo de RG: "+sivec.getTipoRg()+" | Data de Emissão do RG: "+sivec.getDtEmissaoRg()
					+"\n	Estado Civil: "+sivec.getEstadoCivil()+" | Naturalizado em: "+sivec.getNaturalizado()+" | Grau de instrução: " +sivec.getGrauInstrucao()
					+"\n	Nome do Pai: "+sivec.getNomePai()+" | Nome da Mãe: "+sivec.getNomeMae()+" | Cor da Pele: " +sivec.getCorPele()
					+"\n	Alcunha: "+sivec.getAlcunha()+" | Naturalidade: " + sivec.getNaturalidade()+" | Posto de Identificação: "+sivec.getPostoIdentificacao()
					+"\n	Formula Fundamental: "+sivec.getFormulaFundamental()+" | Cor dos Olhos: "+sivec.getCorOlhos() + " | Cabelo: " +sivec.getCabelo()
					+"\n	Profissão: "+sivec.getProfissao()+" | Endereço Residencial: "+sivec.getEnderecoResidencial()+" | Endereço Comercial: "+sivec.getEnderecoTrabalho());
					document.add(paragrafoSivec);
					document.add(paragrafoSivec2);
					document.add(espaco);
				}
				
			}else {
				Paragraph erro7 = new Paragraph("Deu pau no Crawler do Sivec",error);
				document.add(erro7);
				document.add(espaco);
			}
			
			if(statusSiel == true) {
				Paragraph paragrafo8 = new Paragraph("Resultados Siel\n\n", h3);
				paragrafo8.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo8);
				
				siels = sielRepository.findAllById(pfJson); 
				for(SielModel siel:siels) {
					Paragraph paragrafoSiel = new Paragraph("Siel: "+pfJson.getIdPf()+"\n",font);
					Paragraph paragrafoSiel2 = new Paragraph("		Nome: "+siel.getNome()+" | Titulo: "+siel.getTitulo()+" | Data de Nascimento: "+siel.getDtNascimento()
					+"\n	Zona: "+siel.getZona()+" | Endereço: "+siel.getEndereco()+" | Municipio: " +siel.getMunicipio() 
					+"\n	UF: "+siel.getUf()+" | Data Domicilio: "+siel.getDtDomicilio()+" | Nome do Pai: "+siel.getNomePai()
					+"\n	Nome da Mãe: "+siel.getNomeMae()+" | Naturalidade: "+siel.getNaturalidade()+" | Codigo de Validação: "+siel.getCodValidacao());
					document.add(paragrafoSiel);
					document.add(paragrafoSiel2);
					document.add(espaco);
				}
				
			}else {
				Paragraph erro8 = new Paragraph("Deu pau no Crawler do Siel",error);
				document.add(erro8);
				document.add(espaco);
			}
			
			document.close();
			System.out.println("Relatório gerado com sucesso");
		}catch (Exception e) {
			new File("C://Users//tleite//documents//Relatorio_MP//PF//PF_" + pfJson.getIdPf()).mkdirs();
			OutputStream outputStream = new FileOutputStream("C://Users//tleite//documents//Relatorio_MP//PF//PF_"+ pfJson.getIdPf() +"//Relatorio_corrompido.pdf");
			PdfWriter.getInstance(document, outputStream);
			document.open();
			System.out.println(e);
		}
	}

	public void relatorioPdfPj(PJJsonModel pj, boolean statusArisp, boolean statusCadesp, boolean statusCaged,
			boolean statusCensec, boolean statusDetran, boolean statusJucesp) throws FileNotFoundException, DocumentException {
		ProcessoArispRepository arispRepository = new ProcessoArispRepository();
		CagedRepository cagedRepository = new CagedRepository();
		CadespRepository cadespRepository = new CadespRepository(); 
		ResultadoCensecRepository censecRepository = new ResultadoCensecRepository();
		DetranRepository detranRepository = new DetranRepository();
		JucespRepository jucespRepository = new JucespRepository();
		Document document = new Document();
		List<ProcessoArispModel> processosArisp = new ArrayList<ProcessoArispModel>();
		List<CagedModel> cageds = new ArrayList<CagedModel>();
		List<ResultadoCensecModel> censecs = new ArrayList<ResultadoCensecModel>();
		List<DetranModel> detrans = new ArrayList<DetranModel>();
		List<CadespModel> cadesps = new ArrayList<CadespModel>();
		List<JucespModel> jucesps = new ArrayList<JucespModel>();
		
		try {
			new File("C://Users//tleite//documents//Relatorio_MP//PJ//PJ_" + pj.getIdPj()).mkdirs();
			OutputStream outputStream = new FileOutputStream("C://Users//tleite//documents//Relatorio_MP//PJ//PJ_"+ pj.getIdPj() +"//Relatorio_pj_"+pj.getIdPj()+".pdf");
			PdfWriter.getInstance(document, outputStream);
			
			document.open();
			
			Font h1 = new Font(Font.BOLD, 26, Font.BOLD);
			Paragraph cabecalho = new Paragraph("Relatório consolidado de Pessoa Jurídica\n\n\n", h1);
			
			cabecalho.setAlignment(Element.ALIGN_CENTER);
			document.add(cabecalho);
			
			Font h2 = new Font(Font.BOLD, 22, Font.BOLD);
			Paragraph paragrafo = new Paragraph(("Pessoa Jurídica -> "+ pj.getRazaoSocial()+"\n"),h2);
			document.add(paragrafo);
			
			Font h3 = new Font(Font.BOLD, 18, Font.BOLD);
			Font font = new Font(Font.BOLD, 12, Font.NORMAL);
			Font error = new Font(Font.BOLD, 22, Font.BOLD,new Color(255,0,0));
			Paragraph espaco = new Paragraph("\n\n");
			
			Image image;
			
			if(statusArisp == true) {
				Paragraph paragrafo1 = new Paragraph("Resultados Arisp\n\n", h3);
				paragrafo1.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo1);
				
				processosArisp = arispRepository.findAllByIdPj(pj);
				for(ProcessoArispModel processo:processosArisp) {
					Paragraph paragrafoProcesso = new Paragraph("Processo " + pj.getIdPj() + ": \n", font);
					Paragraph paragrafoProcesso2 = new Paragraph("	Cidade: " + processo.getCidade() + " | " + "Cartorio: " + processo.getCartorio()
					+ " | " + "Matricula: " + processo.getMatricula() + "\n",font);
					document.add(paragrafoProcesso);
					document.add(paragrafoProcesso2);
					document.add(espaco);
				}
				
				
				image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//arisp//pj//idPj-"+pj.getIdPj()+"//pt-1-pag-1.png");
				image.scaleAbsolute(700, 500);
				document.add(image);			
				document.add(espaco);
			}else {
				Paragraph erro1 = new Paragraph("Deu pau no Crawler do Arisp",error);
				document.add(erro1);
				document.add(espaco);
			}
			if(statusCadesp == true) {
				Paragraph paragrafo2 = new Paragraph("Resultados Cadesp\n\n", h3);
				paragrafo2.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo2);
				
				
			}else {
				Paragraph erro2 = new Paragraph("Deu pau no Crawler do Cadesp",error);
				document.add(erro2);
				document.add(espaco);
			}
			if(statusCaged == true) {
				
			}else {
				Paragraph erro3 = new Paragraph("Deu pau no Crawler do Caged",error);
				document.add(erro3);
				document.add(espaco);
			}
			if(statusCensec == true) {
				
			}else {
				Paragraph erro4 = new Paragraph("Deu pau no Crawler do Censec",error);
				document.add(erro4);
				document.add(espaco);
			}
			if(statusDetran == true) {
				
			}else {
				Paragraph erro5 = new Paragraph("Deu pau no Crawler do Detran",error);
				document.add(erro5);
				document.add(espaco);
			}
			if(statusJucesp == true) {
				
			}else {
				Paragraph erro6 = new Paragraph("Deu pau no Crawler do Jucesp",error);
				document.add(erro6);
				document.add(espaco);
			}
			document.close();
			System.out.println("Relatório gerado com sucesso");
			
		}catch (Exception e) {
			
			new File("C://Users//tleite//documents//Relatorio_MP//PJ//PJ_" + pj.getIdPj()).mkdirs();
			OutputStream outputStream = new FileOutputStream("C://Users//tleite//documents//Relatorio_MP//PJ//PJ_"+ pj.getIdPj() +"//Relatorio_corrompido.pdf");
			PdfWriter.getInstance(document, outputStream);
			document.open();
			System.out.println(e);
		}
	}
}
