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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@Entity
@Table(name = "adunitsplacements", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adunitsplacements.findAll", query = "SELECT a FROM Adunitsplacements a"),
    @NamedQuery(name = "Adunitsplacements.findById", query = "SELECT a FROM Adunitsplacements a WHERE a.id = :id"),
    @NamedQuery(name = "Adunitsplacements.findByIntegrationId", query = "SELECT a FROM Adunitsplacements a WHERE a.integrationId = :integrationId"),
    @NamedQuery(name = "Adunitsplacements.findByCreated", query = "SELECT a FROM Adunitsplacements a WHERE a.created = :created"),
    @NamedQuery(name = "Adunitsplacements.findByUpdated", query = "SELECT a FROM Adunitsplacements a WHERE a.updated = :updated")})
public class Adunitsplacements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "SpecialRateCardId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ratecard specialRateCardId;
    @JoinColumn(name = "DefaultRateCardId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ratecard defaultRateCardId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "AdUnitId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adunits adUnitId;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "PlacementId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Placements placementId;

    public Adunitsplacements() {
    }

    public Adunitsplacements(Integer id) {
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

    public Ratecard getSpecialRateCardId() {
        return specialRateCardId;
    }

    public void setSpecialRateCardId(Ratecard specialRateCardId) {
        this.specialRateCardId = specialRateCardId;
    }

    public Ratecard getDefaultRateCardId() {
        return defaultRateCardId;
    }

    public void setDefaultRateCardId(Ratecard defaultRateCardId) {
        this.defaultRateCardId = defaultRateCardId;
    }

    public Userprofile getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Userprofile updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Adunits getAdUnitId() {
        return adUnitId;
    }

    public void setAdUnitId(Adunits adUnitId) {
        this.adUnitId = adUnitId;
    }

    public Userprofile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Userprofile createdBy) {
        this.createdBy = createdBy;
    }

    public Placements getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Placements placementId) {
        this.placementId = placementId;
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
        if (!(object instanceof Adunitsplacements)) {
            return false;
        }
        Adunitsplacements other = (Adunitsplacements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Adunitsplacements[ id=" + id + " ]";
    }
    
}
