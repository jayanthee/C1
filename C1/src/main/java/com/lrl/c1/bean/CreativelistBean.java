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
public class CreativelistBean implements Serializable {
    
    private Integer id;

    private String name;

    private String link;

    private String sizes;

    private String tag;
    
//    private String integrationId;
//    
//    private Date created;
//    
//    private Date updated;
    
    //private Userprofile createdBy;
    
    //private Creative creativeId; // old code
    private Integer creativeId; // #
    
    //private Userprofile updatedBy;

    public CreativelistBean() {
    }

    public CreativelistBean(Integer id) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

//    public String getIntegrationId() {
//        return integrationId;
//    }

//    public void setIntegrationId(String integrationId) {
//        this.integrationId = integrationId;
//    }

//    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }

//    public Date getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(Date updated) {
//        this.updated = updated;
//    }

//    public Userprofile getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(Userprofile createdBy) {
//        this.createdBy = createdBy;
//    }

    //    public Creative getCreativeId() {
    //        return creativeId;
    //    }
    //
    //    public void setCreativeId(Creative creativeId) {
    //        this.creativeId = creativeId;
    //    }
    public Integer getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(Integer creativeId) {
        this.creativeId = creativeId;
    }
    
    

//    public Userprofile getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(Userprofile updatedBy) {
//        this.updatedBy = updatedBy;
//    }

    
    
}
