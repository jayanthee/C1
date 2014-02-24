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
public class GraphData implements Serializable {
    
    private String  Name;
    private Integer Id;  
    private Integer Impressions;
    private Double Avg;
    
    private String Name2;
    private String Date;
    
    
    
    private static final Logger LOG = Logger.getLogger(GraphData.class.getName());

    public GraphData(String Name, Integer Id, Integer Impressions, Double Avg) {
        this.Name = Name;
        this.Id = Id;
        this.Impressions = Impressions;
        this.Avg = Avg;
    }

    public GraphData(String Name, Integer Id, Integer Impressions, Double Avg, String Name2, String Date) {
        this.Name = Name;
        this.Id = Id;
        this.Impressions = Impressions;
        this.Avg = Avg;
        this.Name2 = Name2;
        this.Date = Date;
    }
    

    public GraphData() {
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

    public Integer getImpressions() {
        return Impressions;
    }

    public void setImpressions(Integer Impressions) {
        this.Impressions = Impressions;
    }

    public Double getAvg() {
        return Avg;
    }

    public void setAvg(Double Avg) {
        this.Avg = Avg;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String Name2) {
        this.Name2 = Name2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    
    
    
    
    
    
}
