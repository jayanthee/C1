/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "invtargeting", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invtargeting.findAll", query = "SELECT i FROM Invtargeting i"),
    @NamedQuery(name = "Invtargeting.findById", query = "SELECT i FROM Invtargeting i WHERE i.id = :id"),
    @NamedQuery(name = "Invtargeting.findByCpm", query = "SELECT i FROM Invtargeting i WHERE i.cpm = :cpm"),
    @NamedQuery(name = "Invtargeting.findByCurrency", query = "SELECT i FROM Invtargeting i WHERE i.currency = :currency"),
    @NamedQuery(name = "Invtargeting.findByImpressionBooked", query = "SELECT i FROM Invtargeting i WHERE i.impressionBooked = :impressionBooked"),
    @NamedQuery(name = "Invtargeting.findByPrivateFlag", query = "SELECT i FROM Invtargeting i WHERE i.privateFlag = :privateFlag"),
    @NamedQuery(name = "Invtargeting.findByMediaCost", query = "SELECT i FROM Invtargeting i WHERE i.mediaCost = :mediaCost"),
    @NamedQuery(name = "Invtargeting.findByDiscountPercentage", query = "SELECT i FROM Invtargeting i WHERE i.discountPercentage = :discountPercentage"),
    @NamedQuery(name = "Invtargeting.findByStatus", query = "SELECT i FROM Invtargeting i WHERE i.status = :status"),
    @NamedQuery(name = "Invtargeting.findByIntegrationId", query = "SELECT i FROM Invtargeting i WHERE i.integrationId = :integrationId"),
    @NamedQuery(name = "Invtargeting.findByCreated", query = "SELECT i FROM Invtargeting i WHERE i.created = :created"),
    @NamedQuery(name = "Invtargeting.findByUpdated", query = "SELECT i FROM Invtargeting i WHERE i.updated = :updated")})
public class Invtargeting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CPM")
    private BigDecimal cpm;
    @Size(max = 30)
    @Column(name = "Currency")
    private String currency;
    @Column(name = "ImpressionBooked")
    private Integer impressionBooked;
    @Size(max = 2)
    @Column(name = "PrivateFlag")
    private String privateFlag;
    @Column(name = "MediaCost")
    private BigDecimal mediaCost;
    @Column(name = "DiscountPercentage")
    private BigDecimal discountPercentage;
    @Size(max = 11)
    @Column(name = "Status")
    private String status;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "PlacementId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Placements placementId;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "PlanLineId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mediaplanline planLineId;
    @JoinColumn(name = "ParentAdUnitId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adunits parentAdUnitId;
    @JoinColumn(name = "AdUnitId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adunits adUnitId;

    public Invtargeting() {
    }

    public Invtargeting(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getImpressionBooked() {
        return impressionBooked;
    }

    public void setImpressionBooked(Integer impressionBooked) {
        this.impressionBooked = impressionBooked;
    }

    public String getPrivateFlag() {
        return privateFlag;
    }

    public void setPrivateFlag(String privateFlag) {
        this.privateFlag = privateFlag;
    }

    public BigDecimal getMediaCost() {
        return mediaCost;
    }

    public void setMediaCost(BigDecimal mediaCost) {
        this.mediaCost = mediaCost;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Placements getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Placements placementId) {
        this.placementId = placementId;
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

    public Mediaplanline getPlanLineId() {
        return planLineId;
    }

    public void setPlanLineId(Mediaplanline planLineId) {
        this.planLineId = planLineId;
    }

    public Adunits getParentAdUnitId() {
        return parentAdUnitId;
    }

    public void setParentAdUnitId(Adunits parentAdUnitId) {
        this.parentAdUnitId = parentAdUnitId;
    }

    public Adunits getAdUnitId() {
        return adUnitId;
    }

    public void setAdUnitId(Adunits adUnitId) {
        this.adUnitId = adUnitId;
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
        if (!(object instanceof Invtargeting)) {
            return false;
        }
        Invtargeting other = (Invtargeting) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Invtargeting[ id=" + id + " ]";
    }
    
}
