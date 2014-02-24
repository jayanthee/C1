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
public class AdunitsBean implements Serializable {
    private Integer id;
    private String name;    
    private String sizes;    
    private String style;    
    private BigDecimal cpm;    
    private String currency;    
    private String imageLink;    
    private String keyWords;    
    private String positions;    
    private String inventoryType;
    private Integer publicInventoryPercent;    
    private String integrationId;
    private Integer impression;
    private Date created;    
    private Date updated;    
    private List<AdunitsplacementsBean> adunitsplacementsList;        
    private UserprofileBean updatedBy;        
    private UserprofileBean createdBy;        
    private PlacementtypelistBean placementType;        
    private PublisherBean publisherId;    
    private List<AdunitsBean> adunitsList;    
    private AdunitsBean parentId;    
    private List<InvtargetingBean> invtargetingList;    
    private List<InvtargetingBean> invtargetingList1;

    public AdunitsBean() {
    }

    public AdunitsBean(Integer id) {
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

    public String getSizes() {
        return sizes;
    }

    public void setSize(String sizes) {
        this.sizes = sizes;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getPublicInventoryPercent() {
        return publicInventoryPercent;
    }

    public void setPublicInventoryPercent(Integer publicInventoryPercent) {
        this.publicInventoryPercent = publicInventoryPercent;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public Integer getImpression() {
        return impression;
    }

    public void setImpression(Integer impression) {
        this.impression = impression;
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

    public List<AdunitsplacementsBean> getAdunitsplacementsList() {
        return adunitsplacementsList;
    }

    public void setAdunitsplacementsList(List<AdunitsplacementsBean> adunitsplacementsList) {
        this.adunitsplacementsList = adunitsplacementsList;
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

    public PlacementtypelistBean getPlacementType() {
        return placementType;
    }

    public void setPlacementType(PlacementtypelistBean placementType) {
        this.placementType = placementType;
    }

    public PublisherBean getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(PublisherBean publisherId) {
        this.publisherId = publisherId;
    }

    public List<AdunitsBean> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<AdunitsBean> adunitsList) {
        this.adunitsList = adunitsList;
    }

    public AdunitsBean getParentId() {
        return parentId;
    }

    public void setParentId(AdunitsBean parentId) {
        this.parentId = parentId;
    }

    public List<InvtargetingBean> getInvtargetingList() {
        return invtargetingList;
    }

    public void setInvtargetingList(List<InvtargetingBean> invtargetingList) {
        this.invtargetingList = invtargetingList;
    }

    public List<InvtargetingBean> getInvtargetingList1() {
        return invtargetingList1;
    }

    public void setInvtargetingList1(List<InvtargetingBean> invtargetingList1) {
        this.invtargetingList1 = invtargetingList1;
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
        if (!(object instanceof AdunitsBean)) {
            return false;
        }
        AdunitsBean other = (AdunitsBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Adunits[ id=" + id + " ]";
    }
    
}
