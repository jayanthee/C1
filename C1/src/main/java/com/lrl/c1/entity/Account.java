/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author logic
 */
@Entity
@Table(name = "account", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"),
    @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address"),
    @NamedQuery(name = "Account.findByAddress2", query = "SELECT a FROM Account a WHERE a.address2 = :address2"),
    @NamedQuery(name = "Account.findByCity", query = "SELECT a FROM Account a WHERE a.city = :city"),
    @NamedQuery(name = "Account.findByState", query = "SELECT a FROM Account a WHERE a.state = :state"),
    @NamedQuery(name = "Account.findByZipCode", query = "SELECT a FROM Account a WHERE a.zipCode = :zipCode"),
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM Account a WHERE a.type = :type"),
    @NamedQuery(name = "Account.findByBillingContactFirstName", query = "SELECT a FROM Account a WHERE a.billingContactFirstName = :billingContactFirstName"),
    @NamedQuery(name = "Account.findByBillingContactLastName", query = "SELECT a FROM Account a WHERE a.billingContactLastName = :billingContactLastName"),
    @NamedQuery(name = "Account.findByBillingContactPhone", query = "SELECT a FROM Account a WHERE a.billingContactPhone = :billingContactPhone"),
    @NamedQuery(name = "Account.findByBillingContactEmail", query = "SELECT a FROM Account a WHERE a.billingContactEmail = :billingContactEmail"),
    @NamedQuery(name = "Account.findByPaymentMethod", query = "SELECT a FROM Account a WHERE a.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Account.findByPaymentDetails", query = "SELECT a FROM Account a WHERE a.paymentDetails = :paymentDetails"),
    @NamedQuery(name = "Account.findByIntegrationId", query = "SELECT a FROM Account a WHERE a.integrationId = :integrationId"),
    @NamedQuery(name = "Account.findByCreatedBy", query = "SELECT a FROM Account a WHERE a.createdBy = :createdBy"),
    @NamedQuery(name = "Account.findByCreated", query = "SELECT a FROM Account a WHERE a.created = :created"),
    @NamedQuery(name = "Account.findByUpdatedBy", query = "SELECT a FROM Account a WHERE a.updatedBy = :updatedBy"),
    @NamedQuery(name = "Account.findByUpdated", query = "SELECT a FROM Account a WHERE a.updated = :updated")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "Name")
    private String name;
    @Size(max = 300)
    @Column(name = "Address")
    private String address;
    @Size(max = 300)
    @Column(name = "Address2")
    private String address2;
    @Size(max = 90)
    @Column(name = "City")
    private String city;
    @Size(max = 90)
    @Column(name = "State")
    private String state;
    @Size(max = 90)
    @Column(name = "ZipCode")
    private String zipCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Type")
    private String type;
    @Size(max = 150)
    @Column(name = "BillingContactFirstName")
    private String billingContactFirstName;
    @Size(max = 150)
    @Column(name = "BillingContactLastName")
    private String billingContactLastName;
    @Size(max = 150)
    @Column(name = "BillingContactPhone")
    private String billingContactPhone;
    @Size(max = 300)
    @Column(name = "BillingContactEmail")
    private String billingContactEmail;
    @Size(max = 150)
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Size(max = 300)
    @Column(name = "PaymentDetails")
    private String paymentDetails;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedBy")
    private int createdBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UpdatedBy")
    private int updatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY)
    private List<Mediaplan> mediaplanList;
    @OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY)
    private List<Paymentmethod> paymentmethodList;
    @OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY)
    private List<Advertiser> advertiserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId", fetch = FetchType.LAZY)
    private List<Userprofile> userprofileList;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String type, int createdBy, Date created, int updatedBy, Date updated) {
        this.id = id;
        this.type = type;
        this.createdBy = createdBy;
        this.created = created;
        this.updatedBy = updatedBy;
        this.updated = updated;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplan> getMediaplanList() {
        return mediaplanList;
    }

    public void setMediaplanList(List<Mediaplan> mediaplanList) {
        this.mediaplanList = mediaplanList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Paymentmethod> getPaymentmethodList() {
        return paymentmethodList;
    }

    public void setPaymentmethodList(List<Paymentmethod> paymentmethodList) {
        this.paymentmethodList = paymentmethodList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Advertiser> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(List<Advertiser> advertiserList) {
        this.advertiserList = advertiserList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Userprofile> getUserprofileList() {
        return userprofileList;
    }

    public void setUserprofileList(List<Userprofile> userprofileList) {
        this.userprofileList = userprofileList;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Account[ id=" + id + " ]";
    }
    
}
