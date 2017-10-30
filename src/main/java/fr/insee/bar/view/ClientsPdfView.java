package fr.insee.bar.view;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import fr.insee.bar.model.Personne;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ClientsPdfView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked") List<Personne> personnes = (List<Personne>) model.get("clients");
        for (Personne personne : personnes) {
            document.add(new Paragraph(String.format("%s — %s", personne.getNom(), personne.getEmail())));
        }
    }
}
