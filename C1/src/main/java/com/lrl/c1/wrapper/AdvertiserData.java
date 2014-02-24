/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class AdvertiserData implements Serializable {
    
    private Integer Id;  
    private String  Name; 
    private String StartDate;
    private String EndDate;
    private String lastupdateDate; 
    private Integer InventoryAdUnits; 
    private Integer Inventorylines; 
    private Integer Impressions;
    private Double CPM;
    private  String status;
     
    private static final Logger LOG = Logger.getLogger(AdvertiserData.class.getName());
    

    public AdvertiserData(Integer Id, String Name,   String StartDate, String EndDate, String lastupdateDate, Integer InventoryAdUnits, Integer Inventorylines, Integer Impressions, Double CPM,String status) {
        this.Id = Id;
        this.Name = Name; 
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.lastupdateDate = lastupdateDate;
        this.InventoryAdUnits = InventoryAdUnits;
        this.Inventorylines = Inventorylines;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.status =status;
    }

     

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public String getLastupdateDate() {
        return lastupdateDate;
    }

    public void setLastupdateDate(String lastupdateDate) {
        this.lastupdateDate = lastupdateDate;
    }

    public Integer getInventoryAdUnits() {
        return InventoryAdUnits;
    }

    public void setInventoryAdUnits(Integer InventoryAdUnits) {
        this.InventoryAdUnits = InventoryAdUnits;
    }

    public Integer getInventorylines() {
        return Inventorylines;
    }

    public void setInventorylines(Integer Inventorylines) {
        this.Inventorylines = Inventorylines;
    }

    public Integer getImpressions() {
        return Impressions;
    }

    public void setImpressions(Integer Impressions) {
        this.Impressions = Impressions;
    }

    public Double getCPM() {
        return CPM;
    }

    public void setCPM(Double CPM) {
        this.CPM = CPM;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  
    
}
