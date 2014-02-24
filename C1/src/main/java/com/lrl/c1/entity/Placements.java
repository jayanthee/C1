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
@Table(name = "placements", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placements.findAll", query = "SELECT p FROM Placements p"),
    @NamedQuery(name = "Placements.findById", query = "SELECT p FROM Placements p WHERE p.id = :id"),
    @NamedQuery(name = "Placements.findByName", query = "SELECT p FROM Placements p WHERE p.name = :name"),
    @NamedQuery(name = "Placements.findByCpm", query = "SELECT p FROM Placements p WHERE p.cpm = :cpm"),
    @NamedQuery(name = "Placements.findByIntegrationId", query = "SELECT p FROM Placements p WHERE p.integrationId = :integrationId"),
    @NamedQuery(name = "Placements.findByCurrency", query = "SELECT p FROM Placements p WHERE p.currency = :currency"),
    @NamedQuery(name = "Placements.findByImpression", query = "SELECT p FROM Placements p WHERE p.impression = :impression"),
    @NamedQuery(name = "Placements.findByPublicImpressionAvailable", query = "SELECT p FROM Placements p WHERE p.publicImpressionAvailable = :publicImpressionAvailable"),
    @NamedQuery(name = "Placements.findByPrivateImpressionAvailable", query = "SELECT p FROM Placements p WHERE p.privateImpressionAvailable = :privateImpressionAvailable"),
    @NamedQuery(name = "Placements.findByCreated", query = "SELECT p FROM Placements p WHERE p.created = :created"),
    @NamedQuery(name = "Placements.findByUpdated", query = "SELECT p FROM Placements p WHERE p.updated = :updated")})
public class Placements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 3000)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CPM")
    private BigDecimal cpm;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Size(max = 30)
    @Column(name = "Currency")
    private String currency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Impression")
    private int impression;
    @Column(name = "PublicImpressionAvailable")
    private Integer publicImpressionAvailable;
    @Column(name = "PrivateImpressionAvailable")
    private Integer privateImpressionAvailable;
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
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;
    @OneToMany(mappedBy = "placementId", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList;
    @OneToMany(mappedBy = "placementId", fetch = FetchType.LAZY)
    private List<Adunitimpression> adunitimpressionList;
    @OneToMany(mappedBy = "placementId", fetch = FetchType.LAZY)
    private List<Adunitsplacements> adunitsplacementsList;

    public Placements() {
    }

    public Placements(Integer id) {
        this.id = id;
    }

    public Placements(Integer id, int impression) {
        this.id = id;
        this.impression = impression;
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

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }

    public Integer getPublicImpressionAvailable() {
        return publicImpressionAvailable;
    }

    public void setPublicImpressionAvailable(Integer publicImpressionAvailable) {
        this.publicImpressionAvailable = publicImpressionAvailable;
    }

    public Integer getPrivateImpressionAvailable() {
        return privateImpressionAvailable;
    }

    public void setPrivateImpressionAvailable(Integer privateImpressionAvailable) {
        this.privateImpressionAvailable = privateImpressionAvailable;
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

    public Userprofile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Userprofile createdBy) {
        this.createdBy = createdBy;
    }

    public Userprofile getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Userprofile updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
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
    public List<Adunitimpression> getAdunitimpressionList() {
        return adunitimpressionList;
    }

    public void setAdunitimpressionList(List<Adunitimpression> adunitimpressionList) {
        this.adunitimpressionList = adunitimpressionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitsplacements> getAdunitsplacementsList() {
        return adunitsplacementsList;
    }

    public void setAdunitsplacementsList(List<Adunitsplacements> adunitsplacementsList) {
        this.adunitsplacementsList = adunitsplacementsList;
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
        if (!(object instanceof Placements)) {
            return false;
        }
        Placements other = (Placements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Placements[ id=" + id + " ]";
    }
    
}
