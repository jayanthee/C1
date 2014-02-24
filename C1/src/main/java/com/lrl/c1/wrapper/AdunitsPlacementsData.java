/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient; 

/**
 *
 * @author logic
 */
@XmlRootElement
public class AdunitsPlacementsData implements Serializable {
    private Integer adunit_id;
    private Integer placement_id;
    private Integer parentadunit_id;
    private Integer publisher_id;
    private Integer default_ratecard_id;
    private Integer special_ratecard_id;
    private Integer inventory;
    private String name;    
    private String sizes;    
    private String style;    
    private Double cpm;    
    private Integer impression;
    private String type; // Adunits or Placements 
    private Double public_booked;
    private Double public_RFP;
    private Double public_available;
    private Double private_booked;
    private Double private_RFP;
    private Double private_available; 
    private Double publicMinCpm;
    private Double publicMaxCpm;
    private Double privateMinCpm;
    private Double privateMaxCpm;

    public Integer getAdunit_id() {
        return adunit_id;
    }

    public void setAdunit_id(Integer adunit_id) {
        this.adunit_id = adunit_id;
    }

    public Integer getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Integer placement_id) {
        this.placement_id = placement_id;
    }

    public Integer getParentadunit_id() {
        return parentadunit_id;
    }

    public void setParentadunit_id(Integer parentadunit_id) {
        this.parentadunit_id = parentadunit_id;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    public Integer getDefault_ratecard_id() {
        return default_ratecard_id;
    }

    public void setDefault_ratecard_id(Integer default_ratecard_id) {
        this.default_ratecard_id = default_ratecard_id;
    }

    public Integer getSpecial_ratecard_id() {
        return special_ratecard_id;
    }

    public void setSpecial_ratecard_id(Integer special_ratecard_id) {
        this.special_ratecard_id = special_ratecard_id;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Double getCpm() {
        return cpm;
    }

    public void setCpm(Double cpm) {
        this.cpm = cpm;
    }

    public Integer getImpression() {
        return impression;
    }

    public void setImpression(Integer impression) {
        this.impression = impression;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPublic_booked() {
        return public_booked;
    }

    public void setPublic_booked(Double public_booked) {
        this.public_booked = public_booked;
    }

    public Double getPublic_RFP() {
        return public_RFP;
    }

    public void setPublic_RFP(Double public_RFP) {
        this.public_RFP = public_RFP;
    }

    public Double getPublic_available() {
        return public_available;
    }

    public void setPublic_available(Double public_available) {
        this.public_available = public_available;
    }

    public Double getPrivate_booked() {
        return private_booked;
    }

    public void setPrivate_booked(Double private_booked) {
        this.private_booked = private_booked;
    }

    public Double getPrivate_RFP() {
        return private_RFP;
    }

    public void setPrivate_RFP(Double private_RFP) {
        this.private_RFP = private_RFP;
    }

    public Double getPrivate_available() {
        return private_available;
    }

    public void setPrivate_available(Double private_available) {
        this.private_available = private_available;
    }

    public Double getPublicMinCpm() {
        return publicMinCpm;
    }

    public void setPublicMinCpm(Double publicMinCpm) {
        this.publicMinCpm = publicMinCpm;
    }

    public Double getPublicMaxCpm() {
        return publicMaxCpm;
    }

    public void setPublicMaxCpm(Double publicMaxCpm) {
        this.publicMaxCpm = publicMaxCpm;
    }

    public Double getPrivateMinCpm() {
        return privateMinCpm;
    }

    public void setPrivateMinCpm(Double privateMinCpm) {
        this.privateMinCpm = privateMinCpm;
    }

    public Double getPrivateMaxCpm() {
        return privateMaxCpm;
    }

    public void setPrivateMaxCpm(Double privateMaxCpm) {
        this.privateMaxCpm = privateMaxCpm;
    }
    
   
    
  


    
     
     
}
