/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gearupnepal.web.entity;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SellReportWrapper {
    
private ArrayList<SellReport> sellReport;

    public SellReportWrapper() {
    }

    public SellReportWrapper(ArrayList<SellReport> sellReport) {
        this.sellReport = sellReport;
    }

    public ArrayList<SellReport> getSellReport() {
        return sellReport;
    }

    public void setSellReport(ArrayList<SellReport> sellReport) {
        this.sellReport = sellReport;
    }

    

}
