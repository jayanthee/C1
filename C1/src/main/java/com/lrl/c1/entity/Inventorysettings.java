/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author logic
 */
@Entity
@Table(name = "inventorysettings", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventorysettings.findAll", query = "SELECT i FROM Inventorysettings i"),
    @NamedQuery(name = "Inventorysettings.findById", query = "SELECT i FROM Inventorysettings i WHERE i.id = :id"),
    @NamedQuery(name = "Inventorysettings.findByUserName", query = "SELECT i FROM Inventorysettings i WHERE i.userName = :userName"),
    @NamedQuery(name = "Inventorysettings.findByPassWord", query = "SELECT i FROM Inventorysettings i WHERE i.passWord = :passWord"),
    @NamedQuery(name = "Inventorysettings.findByStatus", query = "SELECT i FROM Inventorysettings i WHERE i.status = :status"),
    @NamedQuery(name = "Inventorysettings.findByTotalImpression", query = "SELECT i FROM Inventorysettings i WHERE i.totalImpression = :totalImpression"),
    @NamedQuery(name = "Inventorysettings.findByPublicInventroyPercent", query = "SELECT i FROM Inventorysettings i WHERE i.publicInventroyPercent = :publicInventroyPercent"),
    @NamedQuery(name = "Inventorysettings.findByPrivateInventoryPercent", query = "SELECT i FROM Inventorysettings i WHERE i.privateInventoryPercent = :privateInventoryPercent"),
    @NamedQuery(name = "Inventorysettings.findByCreated", query = "SELECT i FROM Inventorysettings i WHERE i.created = :created"),
    @NamedQuery(name = "Inventorysettings.findByUpdated", query = "SELECT i FROM Inventorysettings i WHERE i.updated = :updated")})
public class Inventorysettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 300)
    @Column(name = "PassWord")
    private String passWord;
    @Size(max = 30)
    @Column(name = "Status")
    private String status;
    @Column(name = "TotalImpression")
    private Integer totalImpression;
    @Column(name = "PublicInventroyPercent")
    private Integer publicInventroyPercent;
    @Column(name = "PrivateInventoryPercent")
    private Integer privateInventoryPercent;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "Vendor", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendors vendor;
    @OneToMany(mappedBy = "inventorySettingsId", fetch = FetchType.LAZY)
    private List<Impressionsettings> impressionsettingsList;

    public Inventorysettings() {
    }

    public Inventorysettings(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalImpression() {
        return totalImpression;
    }

    public void setTotalImpression(Integer totalImpression) {
        this.totalImpression = totalImpression;
    }

    public Integer getPublicInventroyPercent() {
        return publicInventroyPercent;
    }

    public void setPublicInventroyPercent(Integer publicInventroyPercent) {
        this.publicInventroyPercent = publicInventroyPercent;
    }

    public Integer getPrivateInventoryPercent() {
        return privateInventoryPercent;
    }

    public void setPrivateInventoryPercent(Integer privateInventoryPercent) {
        this.privateInventoryPercent = privateInventoryPercent;
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

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public Userprofile getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Userprofile updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Userprofile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Userprofile createdBy) {
        this.createdBy = createdBy;
    }

    public Vendors getVendor() {
        return vendor;
    }

    public void setVendor(Vendors vendor) {
        this.vendor = vendor;
    }

    @XmlTransient
    @JsonIgnore
    public List<Impressionsettings> getImpressionsettingsList() {
        return impressionsettingsList;
    }

    public void setImpressionsettingsList(List<Impressionsettings> impressionsettingsList) {
        this.impressionsettingsList = impressionsettingsList;
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
        if (!(object instanceof Inventorysettings)) {
            return false;
        }
        Inventorysettings other = (Inventorysettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Inventorysettings[ id=" + id + " ]";
    }
    
}
