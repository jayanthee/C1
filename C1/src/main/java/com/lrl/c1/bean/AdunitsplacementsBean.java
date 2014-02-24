/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author logic
 */

public class AdunitsplacementsBean implements Serializable {
    private Integer id;
    private String integrationId;    
    private Date created;    
    private Date updated;        
    private UserprofileBean updatedBy;
    private AdunitsBean adUnitId;    
    private UserprofileBean createdBy;
    private PlacementsBean placementId;    
    private List<InvtargetingBean> invtargetingList;

    public AdunitsplacementsBean() {
    }

    public AdunitsplacementsBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserprofileBean getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserprofileBean updatedBy) {
        this.updatedBy = updatedBy;
    }

    public AdunitsBean getAdUnitId() {
        return adUnitId;
    }

    public void setAdUnitId(AdunitsBean adUnitId) {
        this.adUnitId = adUnitId;
    }

    public UserprofileBean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserprofileBean createdBy) {
        this.createdBy = createdBy;
    }

    public PlacementsBean getPlacementId() {
        return placementId;
    }

    public void setPlacementId(PlacementsBean placementId) {
        this.placementId = placementId;
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
        if (!(object instanceof AdunitsplacementsBean)) {
            return false;
        }
        AdunitsplacementsBean other = (AdunitsplacementsBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Adunitsplacements[ id=" + id + " ]";
    }
    
}
