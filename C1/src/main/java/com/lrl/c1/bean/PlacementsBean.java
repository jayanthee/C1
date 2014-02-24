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
public class PlacementsBean implements Serializable {
    private Integer id;
    private String name;    
    private BigDecimal cpm;    
    private String integrationId;    
    private String currency;    
    private Date created;    
    private Date updated;    
    private UserprofileBean createdBy;    
    private UserprofileBean updatedBy;    
    private PublisherBean publisherId;    
    private List<AdunitsplacementsBean> adunitsplacementsList;

    public PlacementsBean() {
    }

    public PlacementsBean(Integer id) {
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

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public UserprofileBean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserprofileBean createdBy) {
        this.createdBy = createdBy;
    }

    public UserprofileBean getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserprofileBean updatedBy) {
        this.updatedBy = updatedBy;
    }

    public PublisherBean getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(PublisherBean publisherId) {
        this.publisherId = publisherId;
    }

    public List<AdunitsplacementsBean> getAdunitsplacementsList() {
        return adunitsplacementsList;
    }

    public void setAdunitsplacementsList(List<AdunitsplacementsBean> adunitsplacementsList) {
        this.adunitsplacementsList = adunitsplacementsList;
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
        if (!(object instanceof PlacementsBean)) {
            return false;
        }
        PlacementsBean other = (PlacementsBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Placements[ id=" + id + " ]";
    }
    
}
