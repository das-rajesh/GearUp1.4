/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.view;

import com.gearupnepal.web.entity.ChildSubcategory;
import com.gearupnepal.web.entity.Color;
import com.gearupnepal.web.entity.Size1;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfReport {

    public static ByteArrayInputStream citiesReport(List<ChildSubcategory> childs) throws NullPointerException {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(12);
//            table.setWidthPercentage(60);
//            table.setWidths(new int[]{1, 3, 3});

            table.setWidthPercentage(100.0f);
            table.setSpacingBefore(9);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Purchase Date", headFont));
            //  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Vendor", headFont));
            //  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Category", headFont));
            //  hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("SubCategory", headFont));
            //hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("ChildSubcategory", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Image", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Size", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);\
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Color", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Unit Price", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("Quantity", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("Total", headFont));
            //   hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            int id = 0;
            try {
                for (ChildSubcategory child : childs) {
                    //System.out.println(child.getSize1List().get(id).getSize());
//                    for (Size1 size1 : child.getSize1List()) {
//                      for (Color color : size1.getColorList()) {
//                          System.out.println(child.getName());
//                          System.out.println(size1.getSize());
//                         System.out.println(color.getColor());
//                   
                        id++;
                        PdfPCell cell;

                        cell = new PdfPCell(new Phrase(String.valueOf(id)));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Phrase(child.getCreatedDate().toString()));
                        cell.setPaddingLeft(5);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);
                        cell = new PdfPCell(new Phrase(child.getVendorId().getName()));
                        cell.setPaddingLeft(5);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Phrase(String.valueOf(child.getSubCategoriesId().getCategoriesId().getName())));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);
                        cell = new PdfPCell(new Phrase(String.valueOf(child.getSubCategoriesId().getName())));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);
                        cell = new PdfPCell(new Phrase(String.valueOf(child.getName())));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);
                        cell = new PdfPCell(new Phrase("image"));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Phrase(child.getSize1List().get(0).getSize()));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Phrase("color"));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                      
                        table.addCell(cell);
                        cell = new PdfPCell(new Phrase(String.valueOf(child.getPrice())));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                       
                        table.addCell(cell);

                        cell = new PdfPCell(new Phrase(String.valueOf(child.getQuantity())));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);

                        cell = new PdfPCell(new Phrase(String.valueOf(child.getPrice() * child.getQuantity())));
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setPaddingRight(5);
                        table.addCell(cell);

   }
                      
           //         }                    
            //    }

            } catch (Exception e) {
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
