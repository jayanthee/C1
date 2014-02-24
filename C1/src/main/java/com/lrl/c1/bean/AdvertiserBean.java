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
public class AdvertiserBean implements Serializable {
    private Integer id;
    private String name;    
    private String address;    
    private String address2;    
    private String city;    
    private String state;    
    private String zipCode;    
    private Date created;    
    private Date updated;    
    private List<MediaplanBean> mediaplanList;
    private AgencyBean agencyId;    
    private UserprofileBean updatedBy;    
    private UserprofileBean createdBy;

    public AdvertiserBean() {
    }

    public AdvertiserBean(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public List<MediaplanBean> getMediaplanList() {
        return mediaplanList;
    }

    public void setMediaplanList(List<MediaplanBean> mediaplanList) {
        this.mediaplanList = mediaplanList;
    }

    public AgencyBean getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(AgencyBean agencyId) {
        this.agencyId = agencyId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdvertiserBean)) {
            return false;
        }
        AdvertiserBean other = (AdvertiserBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Advertiser[ id=" + id + " ]";
    }
    
}
