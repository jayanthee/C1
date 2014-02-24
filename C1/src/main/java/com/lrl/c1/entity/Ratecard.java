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
@Table(name = "ratecard", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratecard.findAll", query = "SELECT r FROM Ratecard r"),
    @NamedQuery(name = "Ratecard.findById", query = "SELECT r FROM Ratecard r WHERE r.id = :id"),
    @NamedQuery(name = "Ratecard.findByName", query = "SELECT r FROM Ratecard r WHERE r.name = :name"),
    @NamedQuery(name = "Ratecard.findByPrice", query = "SELECT r FROM Ratecard r WHERE r.price = :price"),
    @NamedQuery(name = "Ratecard.findByStatus", query = "SELECT r FROM Ratecard r WHERE r.status = :status"),
    @NamedQuery(name = "Ratecard.findByCreated", query = "SELECT r FROM Ratecard r WHERE r.created = :created"),
    @NamedQuery(name = "Ratecard.findByUpdated", query = "SELECT r FROM Ratecard r WHERE r.updated = :updated")})
public class Ratecard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Double price;
    @Size(max = 8)
    @Column(name = "Status")
    private String status;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "specialRateCardId", fetch = FetchType.LAZY)
    private List<Placements> placementsList;
    @OneToMany(mappedBy = "defaultRateCardId", fetch = FetchType.LAZY)
    private List<Placements> placementsList1;
    @OneToMany(mappedBy = "specialRateCardId", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList;
    @OneToMany(mappedBy = "defaultRateCardId", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList1;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "TimePeriodId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Timeperiod timePeriodId;
    @OneToMany(mappedBy = "specialRateCardId", fetch = FetchType.LAZY)
    private List<Adunitsplacements> adunitsplacementsList;
    @OneToMany(mappedBy = "defaultRateCardId", fetch = FetchType.LAZY)
    private List<Adunitsplacements> adunitsplacementsList1;

    public Ratecard() {
    }

    public Ratecard(Integer id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @XmlTransient
    @JsonIgnore
    public List<Placements> getPlacementsList() {
        return placementsList;
    }

    public void setPlacementsList(List<Placements> placementsList) {
        this.placementsList = placementsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Placements> getPlacementsList1() {
        return placementsList1;
    }

    public void setPlacementsList1(List<Placements> placementsList1) {
        this.placementsList1 = placementsList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunits> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<Adunits> adunitsList) {
        this.adunitsList = adunitsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunits> getAdunitsList1() {
        return adunitsList1;
    }

    public void setAdunitsList1(List<Adunits> adunitsList1) {
        this.adunitsList1 = adunitsList1;
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

    public Timeperiod getTimePeriodId() {
        return timePeriodId;
    }

    public void setTimePeriodId(Timeperiod timePeriodId) {
        this.timePeriodId = timePeriodId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitsplacements> getAdunitsplacementsList() {
        return adunitsplacementsList;
    }

    public void setAdunitsplacementsList(List<Adunitsplacements> adunitsplacementsList) {
        this.adunitsplacementsList = adunitsplacementsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitsplacements> getAdunitsplacementsList1() {
        return adunitsplacementsList1;
    }

    public void setAdunitsplacementsList1(List<Adunitsplacements> adunitsplacementsList1) {
        this.adunitsplacementsList1 = adunitsplacementsList1;
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
        if (!(object instanceof Ratecard)) {
            return false;
        }
        Ratecard other = (Ratecard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Ratecard[ id=" + id + " ]";
    }
    
}
