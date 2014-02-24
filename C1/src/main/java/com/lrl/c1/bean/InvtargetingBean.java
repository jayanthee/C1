/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author logic
 */
public class InvtargetingBean implements Serializable {
    private Integer id;
    private BigDecimal cpm;    
    private String currency;
    private Integer impressionBooked;
    private BigDecimal mediaCost;
    private BigDecimal discountPercentage;    
    private String status;    
    private String integrationId;    
    private Date created;    
    private Date updated;    
    private PublisherBean publisherId;    
    private UserprofileBean updatedBy;    
    private UserprofileBean createdBy;    
    private MediaplanlineBean planLineId;
    private AdunitsBean parentAdUnitId;    
    private AdunitsplacementsBean placementId;    
    private AdunitsBean adUnitId;

    public InvtargetingBean() {
    }

    public InvtargetingBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCpm() {
        return cpm;
    }

    public void setCpm(BigDecimal cpm) {
        this.cpm = cpm;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getImpressionBooked() {
        return impressionBooked;
    }

    public void setImpressionBooked(Integer impressionBooked) {
        this.impressionBooked = impressionBooked;
    }

    public BigDecimal getMediaCost() {
        return mediaCost;
    }

    public void setMediaCost(BigDecimal mediaCost) {
        this.mediaCost = mediaCost;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public PublisherBean getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(PublisherBean publisherId) {
        this.publisherId = publisherId;
    }

    public UserprofileBean getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserprofileBean updatedBy) {
        this.updatedBy = updatedBy;
    }

    public UserprofileBean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserprofileBean createdBy) {
        this.createdBy = createdBy;
    }

    public MediaplanlineBean getPlanLineId() {
        return planLineId;
    }

    public void setPlanLineId(MediaplanlineBean planLineId) {
        this.planLineId = planLineId;
    }

    public AdunitsBean getParentAdUnitId() {
        return parentAdUnitId;
    }

    public void setParentAdUnitId(AdunitsBean parentAdUnitId) {
        this.parentAdUnitId = parentAdUnitId;
    }

    public AdunitsplacementsBean getPlacementId() {
        return placementId;
    }

    public void setPlacementId(AdunitsplacementsBean placementId) {
        this.placementId = placementId;
    }

    public AdunitsBean getAdUnitId() {
        return adUnitId;
    }

    public void setAdUnitId(AdunitsBean adUnitId) {
        this.adUnitId = adUnitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvtargetingBean)) {
            return false;
        }
        InvtargetingBean other = (InvtargetingBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Invtargeting[ id=" + id + " ]";
    }
    
}
