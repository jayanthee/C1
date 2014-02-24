/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author logic
 */

public class DemographyBean implements Serializable {
    private Integer id;
    private String gender;    
    private String age;    
    private Date created;    
    private Date updated;    
    private UserprofileBean updatedBy;
    private UserprofileBean createdBy;

    public DemographyBean() {
    }

    public DemographyBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
        if (!(object instanceof DemographyBean)) {
            return false;
        }
        DemographyBean other = (DemographyBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Demography[ id=" + id + " ]";
    }
    
}
