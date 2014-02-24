/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.bean;

import com.lrl.c1.entity.Mediaplan;
import com.lrl.c1.entity.Userprofile;
import com.lrl.c1.entity.Mediaplanline;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author logic
 */
public class CreativeBean implements Serializable {

    private Integer id;

    
    private String integrationId;
    
    
    private Date created;
    
    
    private Date updated;
    
    private Userprofile createdBy;
    
    private Mediaplanline planLineId;
    
    private Mediaplan planId;
    
    private Userprofile updatedBy;
    
    private List<CreativelistBean> creativelistList;

    public CreativeBean() {
    }

    public CreativeBean(Integer id) {
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

    public Userprofile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Userprofile createdBy) {
        this.createdBy = createdBy;
    }

    public Mediaplanline getPlanLineId() {
        return planLineId;
    }

    public void setPlanLineId(Mediaplanline planLineId) {
        this.planLineId = planLineId;
    }

    public Mediaplan getPlanId() {
        return planId;
    }

    public void setPlanId(Mediaplan planId) {
        this.planId = planId;
    }

    public Userprofile getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Userprofile updatedBy) {
        this.updatedBy = updatedBy;
    }

  
    public List<CreativelistBean> getCreativelistList() {
        return creativelistList;
    }

    public void setCreativelistList(List<CreativelistBean> creativelistList) {
        this.creativelistList = creativelistList;
    }
 
    
}
