/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.controller.report;
import com.gearupnepal.web.service.PurchaseReportService;
import com.gearupnepal.web.service.Size1Service;
import com.gearupnepal.web.view.GeneratePdfReport;
import com.gearupnepal.web.view.PurchaseReportPDf;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PReportController {

    @Autowired
    PurchaseReportService purchaseReportService;

    @RequestMapping(value = "/admin/purchasereports", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() throws IOException {
   
        PurchaseReportPDf pr=new PurchaseReportPDf();
                
        ByteArrayInputStream bis = pr.report(purchaseReportService.getAll());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=purchasereport.pdf");
        headers.add("Location", "/admin/purchasereports");    


        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
