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
@Table(name = "advertiser", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertiser.findAll", query = "SELECT a FROM Advertiser a"),
    @NamedQuery(name = "Advertiser.findById", query = "SELECT a FROM Advertiser a WHERE a.id = :id"),
    @NamedQuery(name = "Advertiser.findByName", query = "SELECT a FROM Advertiser a WHERE a.name = :name"),
    @NamedQuery(name = "Advertiser.findByAddress", query = "SELECT a FROM Advertiser a WHERE a.address = :address"),
    @NamedQuery(name = "Advertiser.findByAddress2", query = "SELECT a FROM Advertiser a WHERE a.address2 = :address2"),
    @NamedQuery(name = "Advertiser.findByCity", query = "SELECT a FROM Advertiser a WHERE a.city = :city"),
    @NamedQuery(name = "Advertiser.findByState", query = "SELECT a FROM Advertiser a WHERE a.state = :state"),
    @NamedQuery(name = "Advertiser.findByZipCode", query = "SELECT a FROM Advertiser a WHERE a.zipCode = :zipCode"),
    @NamedQuery(name = "Advertiser.findByCreated", query = "SELECT a FROM Advertiser a WHERE a.created = :created"),
    @NamedQuery(name = "Advertiser.findByUpdated", query = "SELECT a FROM Advertiser a WHERE a.updated = :updated")})
public class Advertiser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Size(max = 100)
    @Column(name = "Address")
    private String address;
    @Size(max = 100)
    @Column(name = "Address2")
    private String address2;
    @Size(max = 90)
    @Column(name = "City")
    private String city;
    @Size(max = 30)
    @Column(name = "State")
    private String state;
    @Size(max = 30)
    @Column(name = "ZipCode")
    private String zipCode;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "advertiserId", fetch = FetchType.LAZY)
    private List<Mediaplan> mediaplanList;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;

    public Advertiser() {
    }

    public Advertiser(Integer id) {
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

    @XmlTransient
    @JsonIgnore
    public List<Mediaplan> getMediaplanList() {
        return mediaplanList;
    }

    public void setMediaplanList(List<Mediaplan> mediaplanList) {
        this.mediaplanList = mediaplanList;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertiser)) {
            return false;
        }
        Advertiser other = (Advertiser) object;
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
