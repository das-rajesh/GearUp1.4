/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.view;

import com.gearupnepal.web.entity.Category;
import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.SellReport;
import com.gearupnepal.web.entity.Size1;
import com.gearupnepal.web.entity.StockReport;
import com.gearupnepal.web.entity.SubCategory;
import com.gearupnepal.web.service.CategoryService;
import com.gearupnepal.web.service.Size1Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class StockPDFReport extends Thread {

    public ByteArrayInputStream report(List<Size1> size1s) throws NullPointerException {

        Document document = new Document();
        document.addTitle("title");
        document.addSubject("Subject");
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            Paragraph preface = new Paragraph();
            // We add one empty line
            // Lets write a big header

            PdfPTable table = new PdfPTable(10);

            table.setWidthPercentage(100.0f);
            table.setSpacingBefore(10);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Purchase Date", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Vendor", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Category", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("SubCategory", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("ChildSubCategory", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Size", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("UnitPrice", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Total Price", headFont));
            table.addCell(hcell);

            int id = 0;
//            System.out.println("size  " + sizes.size());
            for (Size1 report : size1s) {
                try {
                    id++;
                    PdfPCell cell;

                    cell = new PdfPCell(new Phrase(" "+String.valueOf(id)));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = format.format(report.getCreatedDate());

                    cell = new PdfPCell(new Phrase(" "+dateString));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getChildSubCategoriesId().getVendorId().getName()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getChildSubCategoriesId().getSubCategoriesId().getCategoriesId().getName()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getChildSubCategoriesId().getSubCategoriesId().getName()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getChildSubCategoriesId().getName()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getSize()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getChildSubCategoriesId().getPrice()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(" "+report.getQuantity()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                       float total=(report.getChildSubCategoriesId().getPrice())*Integer.parseInt(report.getQuantity());
                    cell = new PdfPCell(new Phrase(" "+total));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                } catch (NullPointerException e) {
                }
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException | NullPointerException ex) {

            Logger.getLogger(StockPDFReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
