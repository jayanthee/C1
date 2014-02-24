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
public class MediaplanBean implements Serializable {
    private Integer id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Integer totalImpression;
    private String publisherList;      
    private String integerationId;    
    private String owner;    
    private BigDecimal totalCost;
    private String termsandCondition;    
    private String status;    
    private Date created;    
    private Date updated;    
    private AdvertiserBean advertiserID;
    private UserprofileBean updatedBy;
    private UserprofileBean createdBy;    
    private AgencyBean agencyId;    
    private List<MediaplanlineBean> mediaplanlineList;
    private int PubCount; 
    
    
     public int getPubCount() {
        return PubCount;
    }

    public void setPubCount(int PubCount) {
        this.PubCount = PubCount;
    }

    public MediaplanBean() {
    }

    public MediaplanBean(Integer id) {
        this.id = id;
    }

    public MediaplanBean(Integer id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Integer getTotalImpression() {
        return totalImpression;
    }

    public void setTotalImpression(Integer totalImpression) {
        this.totalImpression = totalImpression;
    }

    public String getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(String publisherList) {
        this.publisherList = publisherList;
    }

    public String getIntegerationId() {
        return integerationId;
    }

    public void setIntegerationId(String integerationId) {
        this.integerationId = integerationId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getTermsandCondition() {
        return termsandCondition;
    }

    public void setTermsandCondition(String termsandCondition) {
        this.termsandCondition = termsandCondition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public AdvertiserBean getAdvertiserID() {
        return advertiserID;
    }

    public void setAdvertiserID(AdvertiserBean advertiserID) {
        this.advertiserID = advertiserID;
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

    public AgencyBean getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(AgencyBean agencyId) {
        this.agencyId = agencyId;
    }

    public List<MediaplanlineBean> getMediaplanlineList() {
        return mediaplanlineList;
    }

    public void setMediaplanlineList(List<MediaplanlineBean> mediaplanlineList) {
        this.mediaplanlineList = mediaplanlineList;
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
        if (!(object instanceof MediaplanBean)) {
            return false;
        }
        MediaplanBean other = (MediaplanBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Mediaplan[ id=" + id + " ]";
    }
    
}
