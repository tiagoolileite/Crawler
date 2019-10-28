package relatorio;

import com.itextpdf.text.Element;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;


public class CriaPdf {
	public void relatorioPdfPf() {
		Document document = new Document();
		try {
			OutputStream outputStream = new FileOutputStream("C://Users//tleite//documents//Relatorio.pdf");
			PdfWriter.getInstance(document, outputStream);
			
			document.open();
			
			Font font = new Font(Font.BOLD, 24, Font.BOLD);
			Paragraph cabecalho = new Paragraph("Relatório consolidado de Pessoa Física\n\n", font);
			
			cabecalho.setAlignment(Element.ALIGN_CENTER);
			document.add(cabecalho);
			
			Paragraph paragrafo = new Paragraph("Pessoa Fisica");
			document.add(paragrafo);
			
			Paragraph paragrafo1 = new Paragraph("Teste");
			document.add(paragrafo1);
			
			Image image = Image.getInstance("C://Users//tleite//Pictures//imgs-mpsp//arisp//pf//idPf-1//pt-1-pag-1.png");
			image.scaleAbsolute(700, 500);
			document.add(image);
			
			document.close();
			System.out.println("Relatório gerado com sucesso");
		}catch (Exception e) {
			
		}
	}
}
