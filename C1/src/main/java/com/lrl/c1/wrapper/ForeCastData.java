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
public class ForeCastData implements Serializable {
    private String unitType;
    private String availableUnits;    
    private String deliveredUnits;    
    private String matchedUnits;        
    private String possibleUnits;
    private String reservedUnits;

    public ForeCastData() {
    }

    public ForeCastData(String unitType, String availableUnits, String deliveredUnits, String matchedUnits, String possibleUnits, String reservedUnits) {
        this.unitType = unitType;
        this.availableUnits = availableUnits;
        this.deliveredUnits = deliveredUnits;
        this.matchedUnits = matchedUnits;
        this.possibleUnits = possibleUnits;
        this.reservedUnits = reservedUnits;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(String availableUnits) {
        this.availableUnits = availableUnits;
    }

    public String getDeliveredUnits() {
        return deliveredUnits;
    }

    public void setDeliveredUnits(String deliveredUnits) {
        this.deliveredUnits = deliveredUnits;
    }

    public String getMatchedUnits() {
        return matchedUnits;
    }

    public void setMatchedUnits(String matchedUnits) {
        this.matchedUnits = matchedUnits;
    }

    public String getPossibleUnits() {
        return possibleUnits;
    }

    public void setPossibleUnits(String possibleUnits) {
        this.possibleUnits = possibleUnits;
    }

    public String getReservedUnits() {
        return reservedUnits;
    }

    public void setReservedUnits(String reservedUnits) {
        this.reservedUnits = reservedUnits;
    }
    
}
