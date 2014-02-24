/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author logic
 */

public class MediaplanlineBean implements Serializable {
    private Integer id;
    private String name;    
    private BigDecimal cpm;    
    private String currency;
    private Integer inventoryProposed;    
    private String status;
    private Integer inventoryApproved;    
    private Date startDate;    
    private Date endDate;    
    private String integrationId;    
    private Date created;    
    private Date updated;    
    private List<TargetingBean> targetingList;    
    private List<CreativeBean> creativeList;        
    private UserprofileBean updatedBy;    
    private UserprofileBean createdBy;    
    private MediaplanBean planId;        
    private PublisherBean publisherId;    
    private List<InvtargetingBean> invtargetingList;

    public MediaplanlineBean() {
    }

    public MediaplanlineBean(Integer id) {
        this.id = id;
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

    public Integer getInventoryProposed() {
        return inventoryProposed;
    }

    public void setInventoryProposed(Integer inventoryProposed) {
        this.inventoryProposed = inventoryProposed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInventoryApproved() {
        return inventoryApproved;
    }

    public void setInventoryApproved(Integer inventoryApproved) {
        this.inventoryApproved = inventoryApproved;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public List<TargetingBean> getTargetingList() {
        return targetingList;
    }

    public void setTargetingList(List<TargetingBean> targetingList) {
        this.targetingList = targetingList;
    }

    public List<CreativeBean> getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(List<CreativeBean> creativeList) {
        this.creativeList = creativeList;
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

    public MediaplanBean getPlanId() {
        return planId;
    }

    public void setPlanId(MediaplanBean planId) {
        this.planId = planId;
    }

    public PublisherBean getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(PublisherBean publisherId) {
        this.publisherId = publisherId;
    }

    public List<InvtargetingBean> getInvtargetingList() {
        return invtargetingList;
    }

    public void setInvtargetingList(List<InvtargetingBean> invtargetingList) {
        this.invtargetingList = invtargetingList;
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
        if (!(object instanceof MediaplanlineBean)) {
            return false;
        }
        MediaplanlineBean other = (MediaplanlineBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Mediaplanline[ id=" + id + " ]";
    }
    
}
