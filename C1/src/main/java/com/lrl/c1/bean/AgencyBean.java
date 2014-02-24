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
public class AgencyBean implements Serializable {
    private Integer id;
    private String name;    
    private String address;    
    private String address2;    
    private String city;    
    private String state;    
    private String zipCode;    
    private String billingContactFirstName;    
    private String billingContactLastName;    
    private String billingContactPhone;    
    private String billingContactEmail;    
    private String paymentMethod;    
    private String paymentDetails;    
    private String integrationId;    
    private Date created;    
    private Date updated;    
    private List<MediaplanBean> mediaplanList;    
    private UserprofileBean updatedBy;    
    private UserprofileBean createdBy;    
    private List<PaymentmethodBean> paymentmethodList;    
    private List<AdvertiserBean> advertiserList;

    public AgencyBean() {
    }

    public AgencyBean(Integer id) {
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

    public String getBillingContactFirstName() {
        return billingContactFirstName;
    }

    public void setBillingContactFirstName(String billingContactFirstName) {
        this.billingContactFirstName = billingContactFirstName;
    }

    public String getBillingContactLastName() {
        return billingContactLastName;
    }

    public void setBillingContactLastName(String billingContactLastName) {
        this.billingContactLastName = billingContactLastName;
    }

    public String getBillingContactPhone() {
        return billingContactPhone;
    }

    public void setBillingContactPhone(String billingContactPhone) {
        this.billingContactPhone = billingContactPhone;
    }

    public String getBillingContactEmail() {
        return billingContactEmail;
    }

    public void setBillingContactEmail(String billingContactEmail) {
        this.billingContactEmail = billingContactEmail;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
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

    public List<MediaplanBean> getMediaplanList() {
        return mediaplanList;
    }

    public void setMediaplanList(List<MediaplanBean> mediaplanList) {
        this.mediaplanList = mediaplanList;
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

    public List<PaymentmethodBean> getPaymentmethodList() {
        return paymentmethodList;
    }

    public void setPaymentmethodList(List<PaymentmethodBean> paymentmethodList) {
        this.paymentmethodList = paymentmethodList;
    }

    public List<AdvertiserBean> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(List<AdvertiserBean> advertiserList) {
        this.advertiserList = advertiserList;
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
        if (!(object instanceof AgencyBean)) {
            return false;
        }
        AgencyBean other = (AgencyBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Agency[ id=" + id + " ]";
    }
    
}
