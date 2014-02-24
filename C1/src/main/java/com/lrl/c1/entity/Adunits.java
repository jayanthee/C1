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
@Table(name = "adunits", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adunits.findAll", query = "SELECT a FROM Adunits a"),
    @NamedQuery(name = "Adunits.findById", query = "SELECT a FROM Adunits a WHERE a.id = :id"),
    @NamedQuery(name = "Adunits.findByName", query = "SELECT a FROM Adunits a WHERE a.name = :name"),
    @NamedQuery(name = "Adunits.findBySizes", query = "SELECT a FROM Adunits a WHERE a.sizes = :sizes"),
    @NamedQuery(name = "Adunits.findByStyle", query = "SELECT a FROM Adunits a WHERE a.style = :style"),
    @NamedQuery(name = "Adunits.findByCpm", query = "SELECT a FROM Adunits a WHERE a.cpm = :cpm"),
    @NamedQuery(name = "Adunits.findByCurrency", query = "SELECT a FROM Adunits a WHERE a.currency = :currency"),
    @NamedQuery(name = "Adunits.findByImageLink", query = "SELECT a FROM Adunits a WHERE a.imageLink = :imageLink"),
    @NamedQuery(name = "Adunits.findByKeyWords", query = "SELECT a FROM Adunits a WHERE a.keyWords = :keyWords"),
    @NamedQuery(name = "Adunits.findByPositions", query = "SELECT a FROM Adunits a WHERE a.positions = :positions"),
    @NamedQuery(name = "Adunits.findByInventoryType", query = "SELECT a FROM Adunits a WHERE a.inventoryType = :inventoryType"),
    @NamedQuery(name = "Adunits.findByPublicInventoryPercent", query = "SELECT a FROM Adunits a WHERE a.publicInventoryPercent = :publicInventoryPercent"),
    @NamedQuery(name = "Adunits.findByPublicImpressionAvailable", query = "SELECT a FROM Adunits a WHERE a.publicImpressionAvailable = :publicImpressionAvailable"),
    @NamedQuery(name = "Adunits.findByPrivateImpressionAvailable", query = "SELECT a FROM Adunits a WHERE a.privateImpressionAvailable = :privateImpressionAvailable"),
    @NamedQuery(name = "Adunits.findByIntegrationId", query = "SELECT a FROM Adunits a WHERE a.integrationId = :integrationId"),
    @NamedQuery(name = "Adunits.findByImpression", query = "SELECT a FROM Adunits a WHERE a.impression = :impression"),
    @NamedQuery(name = "Adunits.findByCreated", query = "SELECT a FROM Adunits a WHERE a.created = :created"),
    @NamedQuery(name = "Adunits.findByUpdated", query = "SELECT a FROM Adunits a WHERE a.updated = :updated")})
public class Adunits implements Serializable {
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
    @Column(name = "Sizes")
    private String sizes;
    @Size(max = 45)
    @Column(name = "Style")
    private String style;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CPM")
    private BigDecimal cpm;
    @Size(max = 30)
    @Column(name = "Currency")
    private String currency;
    @Size(max = 300)
    @Column(name = "ImageLink")
    private String imageLink;
    @Size(max = 6000)
    @Column(name = "KeyWords")
    private String keyWords;
    @Size(max = 100)
    @Column(name = "Positions")
    private String positions;
    @Size(max = 100)
    @Column(name = "InventoryType")
    private String inventoryType;
    @Column(name = "PublicInventoryPercent")
    private Integer publicInventoryPercent;
    @Column(name = "PublicImpressionAvailable")
    private Integer publicImpressionAvailable;
    @Column(name = "PrivateImpressionAvailable")
    private Integer privateImpressionAvailable;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Column(name = "Impression")
    private Integer impression;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "PlacementType", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Listofvalues placementType;
    @JoinColumn(name = "SpecialRateCardId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ratecard specialRateCardId;
    @JoinColumn(name = "DefaultRateCardId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ratecard defaultRateCardId;
    @JoinColumn(name = "VendorId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendors vendorId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;
    @OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList;
    @JoinColumn(name = "ParentId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adunits parentId;
    @OneToMany(mappedBy = "parentAdUnitId", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList;
    @OneToMany(mappedBy = "adUnitId", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList1;
    @OneToMany(mappedBy = "adUnitId", fetch = FetchType.LAZY)
    private List<Adunitimpression> adunitimpressionList;
    @OneToMany(mappedBy = "adUnitId", fetch = FetchType.LAZY)
    private List<Adunitsplacements> adunitsplacementsList;

    public Adunits() {
    }

    public Adunits(Integer id) {
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

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public Integer getPublicInventoryPercent() {
        return publicInventoryPercent;
    }

    public void setPublicInventoryPercent(Integer publicInventoryPercent) {
        this.publicInventoryPercent = publicInventoryPercent;
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

    public String getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(String integrationId) {
        this.integrationId = integrationId;
    }

    public Integer getImpression() {
        return impression;
    }

    public void setImpression(Integer impression) {
        this.impression = impression;
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

    public Listofvalues getPlacementType() {
        return placementType;
    }

    public void setPlacementType(Listofvalues placementType) {
        this.placementType = placementType;
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

    public Vendors getVendorId() {
        return vendorId;
    }

    public void setVendorId(Vendors vendorId) {
        this.vendorId = vendorId;
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

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunits> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<Adunits> adunitsList) {
        this.adunitsList = adunitsList;
    }

    public Adunits getParentId() {
        return parentId;
    }

    public void setParentId(Adunits parentId) {
        this.parentId = parentId;
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
    public List<Invtargeting> getInvtargetingList1() {
        return invtargetingList1;
    }

    public void setInvtargetingList1(List<Invtargeting> invtargetingList1) {
        this.invtargetingList1 = invtargetingList1;
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
        if (!(object instanceof Adunits)) {
            return false;
        }
        Adunits other = (Adunits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Adunits[ id=" + id + " ]";
    }
    
}
