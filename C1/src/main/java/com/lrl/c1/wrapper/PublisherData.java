/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class PublisherData implements Serializable {
    
    private String  Name;
    private Integer Id;  
    private Integer InventoryAdUnits; 
    private Integer InventoryPlacements; 
    private Integer Impressions;
    private Double CPM;
    private String  Style;
    private String  Size;
    private Integer InventorySubAdUnits;
   
    private Integer expectedTotImpression;
    private Double percentageInvBooked;
    private Double totRevenue;
    private Integer nonC1;
    private Double privatePercent;
    private Double publicPercent; 
    private Integer AdunitId;
    private Integer PlacementId;
    private Integer ParentId;
    private List ListofValue;
    
     
    private static final Logger LOG = Logger.getLogger(PublisherData.class.getName());

    public PublisherData(String Name, Integer Impressions, Double CPM, Integer AdunitId, Integer PlacementId, Integer ParentId, List ListofValue) {
        this.Name = Name;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.AdunitId = AdunitId;
        this.PlacementId = PlacementId;
        this.ParentId = ParentId;
        this.ListofValue = ListofValue;
    }

   

    public PublisherData(String Name, Integer Id, Integer Impressions, Double CPM, String Style, String Size) {
        this.Name = Name;
        this.Id = Id;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.Style = Style;
        this.Size = Size;
    }
    
    
    
    
    
    public PublisherData() {
    }

    public PublisherData(String Name, Integer Id, Integer InventoryAdUnits, Integer InventoryPlacements, Integer Impressions, Double CPM) {
        this.Name = Name;
        this.Id = Id;
        this.InventoryAdUnits = InventoryAdUnits;
        this.InventoryPlacements = InventoryPlacements;
        this.Impressions = Impressions;
        this.CPM = CPM;
    }
    
 
    
     public PublisherData(String Name, Integer Id,  Integer Impressions, Double CPM) {
        this.Name = Name;
        this.Id = Id; 
        this.Impressions = Impressions;
        this.CPM = CPM;
    }
     
     
     
    public Integer getInventoryPlacements() {
        return InventoryPlacements;
    }

    public void setInventoryPlacements(Integer InventoryPlacements) {
        this.InventoryPlacements = InventoryPlacements;
    }
     

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getInventoryAdUnits() {
        return InventoryAdUnits;
    }

    public void setInventoryAdUnits(Integer InventoryAdUnits) {
        this.InventoryAdUnits = InventoryAdUnits;
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

     public String getStyle() {
        return Style;
    }

    public void setStyle(String Style) {
        this.Style = Style;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public Integer getInventorySubAdUnits() {
        return InventorySubAdUnits;
    }

    public void setInventorySubAdUnits(Integer InventorySubAdUnits) {
        this.InventorySubAdUnits = InventorySubAdUnits;
    }

    public Integer getExpectedTotImpression() {
        return expectedTotImpression;
    }

    public void setExpectedTotImpression(Integer expectedTotImpression) {
        this.expectedTotImpression = expectedTotImpression;
    }

    public Double getPercentageInvBooked() {
        return percentageInvBooked;
    }

    public void setPercentageInvBooked(Double percentageInvBooked) {
        this.percentageInvBooked = percentageInvBooked;
    }

    public Double getTotRevenue() {
        return totRevenue;
    }

    public void setTotRevenue(Double totRevenue) {
        this.totRevenue = totRevenue;
    }

    public Integer getNonC1() {
        return nonC1;
    }

    public void setNonC1(Integer nonC1) {
        this.nonC1 = nonC1;
    }

    public Double getPrivatePercent() {
        return privatePercent;
    }

    public void setPrivatePercent(Double privatePercent) {
        this.privatePercent = privatePercent;
    }

    public Double getPublicPercent() {
        return publicPercent;
    }

    public void setPublicPercent(Double publicPercent) {
        this.publicPercent = publicPercent;
    }
    public Integer getAdunitId() {
        return AdunitId;
    }

    public void setAdunitId(Integer AdunitId) {
        this.AdunitId = AdunitId;
    }

    public Integer getPlacementId() {
        return PlacementId;
    }

    public void setPlacementId(Integer PlacementId) {
        this.PlacementId = PlacementId;
    }

    public Integer getParentId() {
        return ParentId;
    }

    public void setParentId(Integer ParentId) {
        this.ParentId = ParentId;
    }

    public List getListofValue() {
        return ListofValue;
    }

    public void setListofValue(List ListofValue) {
        this.ListofValue = ListofValue;
    }
    
    
    
}
