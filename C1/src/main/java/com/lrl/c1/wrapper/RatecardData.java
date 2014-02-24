/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.*;

/**
 *
 * @author logic
 */
@XmlRootElement
public class RatecardData implements Serializable {

    private Integer timeperiodid;
    private Integer ratecardid;
    private Integer volumediscountid;
    private String name;
    private String startDate;
    private String endDate;
    private String Status;
    private Integer startImpression;
    private Integer endImpression;
    private Double discount;
    private Integer totaldays;
    private Integer adunits;
    private Integer placements;
    private Integer subadunits;
    private Integer totalimpressions;
    private Double price;

    public RatecardData() {
    }

    public RatecardData(Integer timeperiodid,Integer ratecardid, String name, String startDate, String endDate, String Status,Double price) {
        this.timeperiodid = timeperiodid;
        this.ratecardid = ratecardid;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.Status = Status;
        this.price=price;
    }

    public RatecardData(Integer timeperiodid,Integer volumediscountid, String name, Integer startImpression, Integer endImpression, Double discount, Integer totaldays) {
        this.timeperiodid = timeperiodid;
        this.volumediscountid = volumediscountid;
        this.name = name;
        this.startImpression = startImpression;
        this.endImpression = endImpression;
        this.discount = discount;
        this.totaldays = totaldays;
    }

    public Integer getTimeperiodid() {
        return timeperiodid;
    }

    public void setTimeperiodid(Integer timeperiodid) {
        this.timeperiodid = timeperiodid;
    }

    public Integer getRatecardid() {
        return ratecardid;
    }

    public void setRatecardid(Integer ratecardid) {
        this.ratecardid = ratecardid;
    }
    
    
   
    public Integer getVolumediscountid() {
        return volumediscountid;
    }

    public void setVolumediscountid(Integer volumediscountid) {
        this.volumediscountid = volumediscountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return Status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Integer getStartImpression() {
        return startImpression;
    }

    public void setStartImpression(Integer startImpression) {
        this.startImpression = startImpression;
    }

    public Integer getEndImpression() {
        return endImpression;
    }

    public void setEndImpression(Integer endImpression) {
        this.endImpression = endImpression;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(Integer totaldays) {
        this.totaldays = totaldays;
    }

    public Integer getAdunits() {
        return adunits;
    }

    public void setAdunits(Integer adunits) {
        this.adunits = adunits;
    }

    public Integer getPlacements() {
        return placements;
    }

    public void setPlacements(Integer placements) {
        this.placements = placements;
    }

    public Integer getSubadunits() {
        return subadunits;
    }

    public void setSubadunits(Integer subadunits) {
        this.subadunits = subadunits;
    }

    public Integer getTotalimpressions() {
        return totalimpressions;
    }

    public void setTotalimpressions(Integer totalimpressions) {
        this.totalimpressions = totalimpressions;
    }
}
