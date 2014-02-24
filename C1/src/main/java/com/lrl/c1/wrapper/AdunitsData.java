/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class AdunitsData implements Serializable {
    private Integer id;
    private String name;    
    private String sizes;    
    private String style;    
    private Double cpm;    
    private String positions;
    private Integer publiserid;
    private Integer adunitid;
    private Integer placementid;
    private Integer parentaddunitid;
    private Integer impression;

    public AdunitsData() {
    }

    public AdunitsData(Integer id, String name, String sizes, String style, Double cpm, String positions, Integer publiserid, Integer adunitid, Integer placementid, Integer parentaddunitid, Integer impression) {
        this.id = id;
        this.name = name;
        this.sizes = sizes;
        this.style = style;
        this.cpm = cpm;
        this.positions = positions;
        this.publiserid = publiserid;
        this.adunitid = adunitid;
        this.placementid = placementid;
        this.parentaddunitid = parentaddunitid;
        this.impression = impression;
    }
     public AdunitsData(Integer id, String name, String sizes, String style, Double cpm, String positions, Integer publiserid, Integer adunitid, Integer placementid, Integer parentaddunitid) {
        this.id = id;
        this.name = name;
        this.sizes = sizes;
        this.style = style;
        this.cpm = cpm;
        this.positions = positions;
        this.publiserid = publiserid;
        this.adunitid = adunitid;
        this.placementid = placementid;
        this.parentaddunitid = parentaddunitid;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public Integer getPubliserid() {
        return publiserid;
    }

    public void setPubliserid(Integer publiserid) {
        this.publiserid = publiserid;
    }

    public Integer getAdunitid() {
        return adunitid;
    }

    public void setAdunitid(Integer adunitid) {
        this.adunitid = adunitid;
    }

    public Integer getPlacementid() {
        return placementid;
    }

    public void setPlacementid(Integer placementid) {
        this.placementid = placementid;
    }

    public Integer getParentaddunitid() {
        return parentaddunitid;
    }

    public void setParentaddunitid(Integer parentaddunitid) {
        this.parentaddunitid = parentaddunitid;
    }

    public void setImpression(Integer impression) {
       this.impression = impression;
    
    }
    
    public Integer getImpression() {
       return this.impression;
    
    }
    
    
    
    
}
