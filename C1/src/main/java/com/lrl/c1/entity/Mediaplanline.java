/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "mediaplanline", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediaplanline.findAll", query = "SELECT m FROM Mediaplanline m"),
    @NamedQuery(name = "Mediaplanline.findById", query = "SELECT m FROM Mediaplanline m WHERE m.id = :id"),
    @NamedQuery(name = "Mediaplanline.findByName", query = "SELECT m FROM Mediaplanline m WHERE m.name = :name"),
    @NamedQuery(name = "Mediaplanline.findByCpm", query = "SELECT m FROM Mediaplanline m WHERE m.cpm = :cpm"),
    @NamedQuery(name = "Mediaplanline.findByCurrency", query = "SELECT m FROM Mediaplanline m WHERE m.currency = :currency"),
    @NamedQuery(name = "Mediaplanline.findByInventoryProposed", query = "SELECT m FROM Mediaplanline m WHERE m.inventoryProposed = :inventoryProposed"),
    @NamedQuery(name = "Mediaplanline.findByStatus", query = "SELECT m FROM Mediaplanline m WHERE m.status = :status"),
    @NamedQuery(name = "Mediaplanline.findByInventoryApproved", query = "SELECT m FROM Mediaplanline m WHERE m.inventoryApproved = :inventoryApproved"),
    @NamedQuery(name = "Mediaplanline.findByStartDate", query = "SELECT m FROM Mediaplanline m WHERE m.startDate = :startDate"),
    @NamedQuery(name = "Mediaplanline.findByEndDate", query = "SELECT m FROM Mediaplanline m WHERE m.endDate = :endDate"),
    @NamedQuery(name = "Mediaplanline.findByIntegrationId", query = "SELECT m FROM Mediaplanline m WHERE m.integrationId = :integrationId"),
    @NamedQuery(name = "Mediaplanline.findByCreated", query = "SELECT m FROM Mediaplanline m WHERE m.created = :created"),
    @NamedQuery(name = "Mediaplanline.findByUpdated", query = "SELECT m FROM Mediaplanline m WHERE m.updated = :updated")})
public class Mediaplanline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CPM")
    private BigDecimal cpm;
    @Size(max = 30)
    @Column(name = "Currency")
    private String currency;
    @Column(name = "InventoryProposed")
    private Integer inventoryProposed;
    @Size(max = 11)
    @Column(name = "Status")
    private String status;
    @Column(name = "InventoryApproved")
    private Integer inventoryApproved;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "mediaPlanId", fetch = FetchType.LAZY)
    private List<Targeting> targetingList;
    @OneToMany(mappedBy = "planLineId", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList;
    @OneToMany(mappedBy = "planLineId", fetch = FetchType.LAZY)
    private List<Creative> creativeList;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "PlanId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mediaplan planId;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;

    public Mediaplanline() {
    }

    public Mediaplanline(Integer id) {
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

    public Integer getInventoryProposed() {
        return inventoryProposed;
    }

    public void setInventoryProposed(Integer inventoryProposed) {
        this.inventoryProposed = inventoryProposed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInventoryApproved() {
        return inventoryApproved;
    }

    public void setInventoryApproved(Integer inventoryApproved) {
        this.inventoryApproved = inventoryApproved;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    @XmlTransient
    @JsonIgnore
    public List<Targeting> getTargetingList() {
        return targetingList;
    }

    public void setTargetingList(List<Targeting> targetingList) {
        this.targetingList = targetingList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Invtargeting> getInvtargetingList() {
        return invtargetingList;
    }

    public void setInvtargetingList(List<Invtargeting> invtargetingList) {
        this.invtargetingList = invtargetingList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Creative> getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(List<Creative> creativeList) {
        this.creativeList = creativeList;
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

    public Mediaplan getPlanId() {
        return planId;
    }

    public void setPlanId(Mediaplan planId) {
        this.planId = planId;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
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
        if (!(object instanceof Mediaplanline)) {
            return false;
        }
        Mediaplanline other = (Mediaplanline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Mediaplanline[ id=" + id + " ]";
    }
    
}
