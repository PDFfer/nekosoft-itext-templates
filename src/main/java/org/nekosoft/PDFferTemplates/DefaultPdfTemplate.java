package org.nekosoft.PDFferTemplates;

import java.util.Map;

import org.nekosoft.pdffer.template.AbstractJacksonPdfTemplate;
import org.nekosoft.pdffer.template.PdfTemplateComponent;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

/**
 * A very basic template for PDFfer that takes a java Map of String to Object
 * and prints it out in table form with the key name and corresponding value
 * in each row.
 */
@PdfTemplateComponent(name = "default")
public class DefaultPdfTemplate extends AbstractJacksonPdfTemplate<Map<String, Object>> {

    @Override
    public Class<Map<String, Object>> getPayloadClass() {
        return (Class<Map<String, Object>>)(Class<?>)Map.class;
    }

    @Override
    public void setPayloadMap(Map<String, Object> map) {
        setPayload(map);
    }

	@Override
	public void generate() {
        Map<String, Object> data = getPayload();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(os));
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Document layoutDocument = new Document(pdfDocument);
        layoutDocument.setMargins(25f, 25f, 25f, 25f);
        Table table = new Table(UnitValue.createPercentArray(new float[] { 25f, 5f, 70f }))
                .useAllAvailableWidth()
                .setMargins(0f, 0f, 0f, 0f)
                ;

        Cell keyCell = new Cell().add(new Paragraph("KEY").setBold())
                .setBorder(Border.NO_BORDER)
                ;
        table.addHeaderCell(keyCell);
        table.addHeaderCell(new Cell().setBorder(Border.NO_BORDER));
        Cell valueCell = new Cell().add(new Paragraph("VALUE").setBold())
                .setBorder(Border.NO_BORDER)
                ;
        table.addHeaderCell(valueCell);

        for (Map.Entry<String,Object> pair : data.entrySet()) {
            Cell kCell = new Cell().add(new Paragraph(pair.getKey()))
                    .setBorder(Border.NO_BORDER)
                    ;
            table.addCell(kCell);
            table.addCell(new Cell().setBorder(Border.NO_BORDER));
            // TODO nested Map (only one level down)
            Cell vCell = new Cell().add(new Paragraph(pair.getValue().toString()))
                    .setBorder(Border.NO_BORDER)
                    ;
            table.addCell(vCell);
        }

        layoutDocument.add(table);

        layoutDocument.close();
        
        pdfContent = os.toByteArray();
	}

}
