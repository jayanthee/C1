/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import com.lrl.c1.bean.TargetingBean;
import com.sun.jersey.server.impl.container.servlet.Include;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class MediaplanData implements Serializable {
    
    private Integer Id;  
    private String  Name;
    private Integer Targeting;
    private String StartDate;
    private String EndDate;
    private Integer InventoryPublisher;
    private Integer InventoryAdUnits; 
    private Integer InventoryPlacements; 
    private Integer Impressions;
    private Double CPM;
    private String Status;  
    private String Style;
    private String Sizes;
    private transient String UUs;     
    private transient List<TargetingBean> targetingGp;
    private Integer advertiserid;
    private String advertisername;
    private Integer adunitId;
    private Integer placementId;
    
    private Integer LineId; // sharan
    
    private static final Logger LOG = Logger.getLogger(MediaplanData.class.getName());

      public MediaplanData(){
      }
      
      
    public MediaplanData(Integer Id, String Name, Integer Targeting, String StartDate, String EndDate, Integer InventoryPublisher, Integer InventoryAdUnits, Integer InventoryPlacements, Integer Impressions, Double CPM, String Status, String Style, String Sizes) {
        this.Id = Id;
        this.Name = Name;
        this.Targeting = Targeting;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.InventoryPublisher = InventoryPublisher;
        this.InventoryAdUnits = InventoryAdUnits;
        this.InventoryPlacements = InventoryPlacements;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.Status = Status;
        this.Style = Style;
        this.Sizes = Sizes;       
    }

    public MediaplanData(Integer Id, String Name, Integer Targeting, String StartDate, String EndDate, Integer InventoryPublisher, Integer InventoryAdUnits, Integer InventoryPlacements, Integer Impressions, Double CPM, String Status){
        this.Id = Id;
        this.Name = Name;
        this.Targeting = Targeting; 
        this.StartDate =  StartDate ; 
        this.EndDate =  EndDate ; 
        this.InventoryPublisher = InventoryPublisher;
        this.InventoryAdUnits = InventoryAdUnits;
        this.InventoryPlacements = InventoryPlacements;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.Status = Status;
    }
    
    public MediaplanData(Integer Id, String Name, List<TargetingBean> targetingGp, String StartDate, String EndDate, Integer InventoryPublisher, Integer InventoryAdUnits, Integer InventoryPlacements, Integer Impressions, Double CPM, String Status){
        this.Id = Id;
        this.Name = Name;
        this.targetingGp = targetingGp;
        this.StartDate =  StartDate ; 
        this.EndDate =  EndDate ; 
        this.InventoryPublisher = InventoryPublisher;
        this.InventoryAdUnits = InventoryAdUnits;
        this.InventoryPlacements = InventoryPlacements;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.Status = Status;
    }
    
    // sharan , newly added lineid at the end
    public MediaplanData(Integer Id, String Name, List<TargetingBean> targetingGp, String StartDate, String EndDate, Integer InventoryPublisher, Integer InventoryAdUnits, Integer InventoryPlacements, Integer Impressions, Double CPM, String Status, Integer LineId){
        this.Id = Id;
        this.Name = Name;
        this.targetingGp = targetingGp;
        this.StartDate =  StartDate ; 
        this.EndDate =  EndDate ; 
        this.InventoryPublisher = InventoryPublisher;
        this.InventoryAdUnits = InventoryAdUnits;
        this.InventoryPlacements = InventoryPlacements;
        this.Impressions = Impressions;
        this.CPM = CPM;
        this.Status = Status;
        this.LineId = LineId;
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

    public Integer getTargeting() {
        return Targeting;
    }

    public void setTargeting(Integer Targeting) {
        this.Targeting = Targeting;
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

    public Integer getInventoryPublisher() {
        return InventoryPublisher;
    }

    public void setInventoryPublisher(Integer InventoryPublisher) {
        this.InventoryPublisher = InventoryPublisher;
    }

    public Integer getInventoryAdUnits() {
        return InventoryAdUnits;
    }

    public void setInventoryAdUnits(Integer InventoryAdUnits) {
        this.InventoryAdUnits = InventoryAdUnits;
    }

    public Integer getInventoryPlacements() {
        return InventoryPlacements;
    }

    public void setInventoryPlacements(Integer InventoryPlacements) {
        this.InventoryPlacements = InventoryPlacements;
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
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String Style) {
        this.Style = Style;
    }

    public String getSizes() {
        return Sizes;
    }

    public void setSizes(String Sizes) {
        this.Sizes = Sizes;
    }

    public List<TargetingBean> getTargetingGp() {
        return targetingGp;
    }

    public void setTargetingBean(List<TargetingBean> targetingGp) {
        this.targetingGp = targetingGp;
    }

    public String getUUs() {
        return UUs;
    }

    public void setUUs(String UUs) {
        this.UUs = UUs;
    }
// sharan
    public Integer getLineId() {
        return LineId;
    }

    public void setLineId(Integer LineId) {
        this.LineId = LineId;
    }

    public Integer getAdvertiserid() {
        return advertiserid;
    }

    public void setAdvertiserid(Integer advertiserid) {
        this.advertiserid = advertiserid;
    }

    public String getAdvertisername() {
        return advertisername;
    }

    public void setAdvertisername(String advertisername) {
        this.advertisername = advertisername;
    }

    public Integer getAdunitId() {
        return adunitId;
    }

    public void setAdunitId(Integer adunitId) {
        this.adunitId = adunitId;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }
 
    
    
    
    
    
    
    
   
    
}
