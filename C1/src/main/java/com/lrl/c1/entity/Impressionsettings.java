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
@Table(name = "impressionsettings", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impressionsettings.findAll", query = "SELECT i FROM Impressionsettings i"),
    @NamedQuery(name = "Impressionsettings.findById", query = "SELECT i FROM Impressionsettings i WHERE i.id = :id"),
    @NamedQuery(name = "Impressionsettings.findByMonth", query = "SELECT i FROM Impressionsettings i WHERE i.month = :month"),
    @NamedQuery(name = "Impressionsettings.findByYear", query = "SELECT i FROM Impressionsettings i WHERE i.year = :year"),
    @NamedQuery(name = "Impressionsettings.findByMonthlyImpression", query = "SELECT i FROM Impressionsettings i WHERE i.monthlyImpression = :monthlyImpression"),
    @NamedQuery(name = "Impressionsettings.findByPublicInventoryPercent", query = "SELECT i FROM Impressionsettings i WHERE i.publicInventoryPercent = :publicInventoryPercent"),
    @NamedQuery(name = "Impressionsettings.findByPrivateInventoryPercent", query = "SELECT i FROM Impressionsettings i WHERE i.privateInventoryPercent = :privateInventoryPercent"),
    @NamedQuery(name = "Impressionsettings.findByDescription", query = "SELECT i FROM Impressionsettings i WHERE i.description = :description"),
    @NamedQuery(name = "Impressionsettings.findByCreated", query = "SELECT i FROM Impressionsettings i WHERE i.created = :created"),
    @NamedQuery(name = "Impressionsettings.findByUpdated", query = "SELECT i FROM Impressionsettings i WHERE i.updated = :updated")})
public class Impressionsettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Month")
    private Integer month;
    @Column(name = "Year")
    private Integer year;
    @Column(name = "MonthlyImpression")
    private Integer monthlyImpression;
    @Column(name = "PublicInventoryPercent")
    private Integer publicInventoryPercent;
    @Column(name = "PrivateInventoryPercent")
    private Integer privateInventoryPercent;
    @Size(max = 250)
    @Column(name = "Description")
    private String description;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "InventorySettingsId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inventorysettings inventorySettingsId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @OneToMany(mappedBy = "impressionSettingsId", fetch = FetchType.LAZY)
    private List<Adunitimpression> adunitimpressionList;

    public Impressionsettings() {
    }

    public Impressionsettings(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonthlyImpression() {
        return monthlyImpression;
    }

    public void setMonthlyImpression(Integer monthlyImpression) {
        this.monthlyImpression = monthlyImpression;
    }

    public Integer getPublicInventoryPercent() {
        return publicInventoryPercent;
    }

    public void setPublicInventoryPercent(Integer publicInventoryPercent) {
        this.publicInventoryPercent = publicInventoryPercent;
    }

    public Integer getPrivateInventoryPercent() {
        return privateInventoryPercent;
    }

    public void setPrivateInventoryPercent(Integer privateInventoryPercent) {
        this.privateInventoryPercent = privateInventoryPercent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Inventorysettings getInventorySettingsId() {
        return inventorySettingsId;
    }

    public void setInventorySettingsId(Inventorysettings inventorySettingsId) {
        this.inventorySettingsId = inventorySettingsId;
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

    @XmlTransient
    @JsonIgnore
    public List<Adunitimpression> getAdunitimpressionList() {
        return adunitimpressionList;
    }

    public void setAdunitimpressionList(List<Adunitimpression> adunitimpressionList) {
        this.adunitimpressionList = adunitimpressionList;
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
        if (!(object instanceof Impressionsettings)) {
            return false;
        }
        Impressionsettings other = (Impressionsettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Impressionsettings[ id=" + id + " ]";
    }
    
}
