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
public class PublisherBean implements Serializable {
    private Integer id;
    private String name;    
    private String overview;    
    private Date created;    
    private Date updated;    
    private List<PlacementsBean> placementsList;
    private List<InventorytypeBean> inventorytypeList;    
    private List<AdunitsBean> adunitsList;    
    private List<MediaplanlineBean> mediaplanlineList;    
    private UserprofileBean updatedBy;
    private UserprofileBean createdBy;
    private List<InvtargetingBean> invtargetingList;    
    private List<PublishercontactBean> publishercontactList;

    public PublisherBean() {
    }

    public PublisherBean(Integer id) {
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public List<PlacementsBean> getPlacementsList() {
        return placementsList;
    }

    public void setPlacementsList(List<PlacementsBean> placementsList) {
        this.placementsList = placementsList;
    }

    public List<InventorytypeBean> getInventorytypeList() {
        return inventorytypeList;
    }

    public void setInventorytypeList(List<InventorytypeBean> inventorytypeList) {
        this.inventorytypeList = inventorytypeList;
    }

    public List<AdunitsBean> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<AdunitsBean> adunitsList) {
        this.adunitsList = adunitsList;
    }

    public List<MediaplanlineBean> getMediaplanlineList() {
        return mediaplanlineList;
    }

    public void setMediaplanlineList(List<MediaplanlineBean> mediaplanlineList) {
        this.mediaplanlineList = mediaplanlineList;
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

    public List<InvtargetingBean> getInvtargetingList() {
        return invtargetingList;
    }

    public void setInvtargetingList(List<InvtargetingBean> invtargetingList) {
        this.invtargetingList = invtargetingList;
    }

    public List<PublishercontactBean> getPublishercontactList() {
        return publishercontactList;
    }

    public void setPublishercontactList(List<PublishercontactBean> publishercontactList) {
        this.publishercontactList = publishercontactList;
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
        if (!(object instanceof PublisherBean)) {
            return false;
        }
        PublisherBean other = (PublisherBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Publisher[ id=" + id + " ]";
    }
    
}
