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
public class CreativeData implements Serializable {
    
    private Integer Id;  
    private String  Name;  
    private String InventoryPublisher;  
    private Integer Impressions;       
    //private List<CreativelistBean> creative;
    
    private static final Logger LOG = Logger.getLogger(CreativeData.class.getName());

      public CreativeData(){
      }

    public CreativeData(Integer Id, String Name, String InventoryPublisher, Integer Impressions) {
        this.Id = Id;
        this.Name = Name;
        this.InventoryPublisher = InventoryPublisher;
        this.Impressions = Impressions;
        //this.creative = creative;
    }
    
   
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getcreativeName() {
        return Name;
    }

    public void setcreativeName(String Name) {
        this.Name = Name;
    }

    public String getInventoryPublisher() {
        return InventoryPublisher;
    }

    public void setInventoryPublisher(String InventoryPublisher) {
        this.InventoryPublisher = InventoryPublisher;
    }

    public Integer getImpressions() {
        return Impressions;
    }

    public void setImpressions(Integer Impressions) {
        this.Impressions = Impressions;
    }

    
    
    
}
