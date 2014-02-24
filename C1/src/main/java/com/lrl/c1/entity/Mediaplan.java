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
@Table(name = "mediaplan", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediaplan.findAll", query = "SELECT m FROM Mediaplan m"),
    @NamedQuery(name = "Mediaplan.findById", query = "SELECT m FROM Mediaplan m WHERE m.id = :id"),
    @NamedQuery(name = "Mediaplan.findByName", query = "SELECT m FROM Mediaplan m WHERE m.name = :name"),
    @NamedQuery(name = "Mediaplan.findByStartDate", query = "SELECT m FROM Mediaplan m WHERE m.startDate = :startDate"),
    @NamedQuery(name = "Mediaplan.findByEndDate", query = "SELECT m FROM Mediaplan m WHERE m.endDate = :endDate"),
    @NamedQuery(name = "Mediaplan.findByTotalImpression", query = "SELECT m FROM Mediaplan m WHERE m.totalImpression = :totalImpression"),
    @NamedQuery(name = "Mediaplan.findByPublisherList", query = "SELECT m FROM Mediaplan m WHERE m.publisherList = :publisherList"),
    @NamedQuery(name = "Mediaplan.findByIntegrationId", query = "SELECT m FROM Mediaplan m WHERE m.integrationId = :integrationId"),
    @NamedQuery(name = "Mediaplan.findByOwner", query = "SELECT m FROM Mediaplan m WHERE m.owner = :owner"),
    @NamedQuery(name = "Mediaplan.findByTotalCost", query = "SELECT m FROM Mediaplan m WHERE m.totalCost = :totalCost"),
    @NamedQuery(name = "Mediaplan.findByTermsandCondition", query = "SELECT m FROM Mediaplan m WHERE m.termsandCondition = :termsandCondition"),
    @NamedQuery(name = "Mediaplan.findByStatus", query = "SELECT m FROM Mediaplan m WHERE m.status = :status"),
    @NamedQuery(name = "Mediaplan.findByCreated", query = "SELECT m FROM Mediaplan m WHERE m.created = :created"),
    @NamedQuery(name = "Mediaplan.findByUpdated", query = "SELECT m FROM Mediaplan m WHERE m.updated = :updated")})
public class Mediaplan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "TotalImpression")
    private Integer totalImpression;
    @Size(max = 6000)
    @Column(name = "PublisherList")
    private String publisherList;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Size(max = 50)
    @Column(name = "Owner")
    private String owner;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalCost")
    private BigDecimal totalCost;
    @Size(max = 3000)
    @Column(name = "TermsandCondition")
    private String termsandCondition;
    @Size(max = 11)
    @Column(name = "Status")
    private String status;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "AdvertiserId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Advertiser advertiserId;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @OneToMany(mappedBy = "planId", fetch = FetchType.LAZY)
    private List<Creativelist> creativelistList;
    @OneToMany(mappedBy = "planId", fetch = FetchType.LAZY)
    private List<Mediaplanline> mediaplanlineList;

    public Mediaplan() {
    }

    public Mediaplan(Integer id) {
        this.id = id;
    }

    public Mediaplan(Integer id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Integer getTotalImpression() {
        return totalImpression;
    }

    public void setTotalImpression(Integer totalImpression) {
        this.totalImpression = totalImpression;
    }

    public String getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(String publisherList) {
        this.publisherList = publisherList;
    }

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getTermsandCondition() {
        return termsandCondition;
    }

    public void setTermsandCondition(String termsandCondition) {
        this.termsandCondition = termsandCondition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Advertiser getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Advertiser advertiserId) {
        this.advertiserId = advertiserId;
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

    @XmlTransient
    @JsonIgnore
    public List<Creativelist> getCreativelistList() {
        return creativelistList;
    }

    public void setCreativelistList(List<Creativelist> creativelistList) {
        this.creativelistList = creativelistList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplanline> getMediaplanlineList() {
        return mediaplanlineList;
    }

    public void setMediaplanlineList(List<Mediaplanline> mediaplanlineList) {
        this.mediaplanlineList = mediaplanlineList;
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
        if (!(object instanceof Mediaplan)) {
            return false;
        }
        Mediaplan other = (Mediaplan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Mediaplan[ id=" + id + " ]";
    }
    
}
