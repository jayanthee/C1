/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@Entity
@Table(name = "adunitimpression", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adunitimpression.findAll", query = "SELECT a FROM Adunitimpression a"),
    @NamedQuery(name = "Adunitimpression.findById", query = "SELECT a FROM Adunitimpression a WHERE a.id = :id"),
    @NamedQuery(name = "Adunitimpression.findByAvailImpressions", query = "SELECT a FROM Adunitimpression a WHERE a.availImpressions = :availImpressions"),
    @NamedQuery(name = "Adunitimpression.findByPublicInventoryImpression", query = "SELECT a FROM Adunitimpression a WHERE a.publicInventoryImpression = :publicInventoryImpression"),
    @NamedQuery(name = "Adunitimpression.findByPrivateInventoryImpression", query = "SELECT a FROM Adunitimpression a WHERE a.privateInventoryImpression = :privateInventoryImpression"),
    @NamedQuery(name = "Adunitimpression.findByCreated", query = "SELECT a FROM Adunitimpression a WHERE a.created = :created"),
    @NamedQuery(name = "Adunitimpression.findByUpdated", query = "SELECT a FROM Adunitimpression a WHERE a.updated = :updated")})
public class Adunitimpression implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "AvailImpressions")
    private Integer availImpressions;
    @Column(name = "PublicInventoryImpression")
    private Integer publicInventoryImpression;
    @Column(name = "PrivateInventoryImpression")
    private Integer privateInventoryImpression;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "PlacementId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Placements placementId;
    @JoinColumn(name = "AdUnitId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adunits adUnitId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "ImpressionSettingsId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Impressionsettings impressionSettingsId;

    public Adunitimpression() {
    }

    public Adunitimpression(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailImpressions() {
        return availImpressions;
    }

    public void setAvailImpressions(Integer availImpressions) {
        this.availImpressions = availImpressions;
    }

    public Integer getPublicInventoryImpression() {
        return publicInventoryImpression;
    }

    public void setPublicInventoryImpression(Integer publicInventoryImpression) {
        this.publicInventoryImpression = publicInventoryImpression;
    }

    public Integer getPrivateInventoryImpression() {
        return privateInventoryImpression;
    }

    public void setPrivateInventoryImpression(Integer privateInventoryImpression) {
        this.privateInventoryImpression = privateInventoryImpression;
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

    public Placements getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Placements placementId) {
        this.placementId = placementId;
    }

    public Adunits getAdUnitId() {
        return adUnitId;
    }

    public void setAdUnitId(Adunits adUnitId) {
        this.adUnitId = adUnitId;
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

    public Impressionsettings getImpressionSettingsId() {
        return impressionSettingsId;
    }

    public void setImpressionSettingsId(Impressionsettings impressionSettingsId) {
        this.impressionSettingsId = impressionSettingsId;
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
        if (!(object instanceof Adunitimpression)) {
            return false;
        }
        Adunitimpression other = (Adunitimpression) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Adunitimpression[ id=" + id + " ]";
    }
    
}
