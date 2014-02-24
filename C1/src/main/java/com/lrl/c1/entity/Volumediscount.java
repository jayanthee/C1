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
@Table(name = "volumediscount", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Volumediscount.findAll", query = "SELECT v FROM Volumediscount v"),
    @NamedQuery(name = "Volumediscount.findById", query = "SELECT v FROM Volumediscount v WHERE v.id = :id"),
    @NamedQuery(name = "Volumediscount.findByName", query = "SELECT v FROM Volumediscount v WHERE v.name = :name"),
    @NamedQuery(name = "Volumediscount.findByStartImpression", query = "SELECT v FROM Volumediscount v WHERE v.startImpression = :startImpression"),
    @NamedQuery(name = "Volumediscount.findByEndImpression", query = "SELECT v FROM Volumediscount v WHERE v.endImpression = :endImpression"),
    @NamedQuery(name = "Volumediscount.findByDiscountPercent", query = "SELECT v FROM Volumediscount v WHERE v.discountPercent = :discountPercent"),
    @NamedQuery(name = "Volumediscount.findByTotalDays", query = "SELECT v FROM Volumediscount v WHERE v.totalDays = :totalDays"),
    @NamedQuery(name = "Volumediscount.findByCreated", query = "SELECT v FROM Volumediscount v WHERE v.created = :created"),
    @NamedQuery(name = "Volumediscount.findByUpdated", query = "SELECT v FROM Volumediscount v WHERE v.updated = :updated")})
public class Volumediscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Column(name = "StartImpression")
    private Integer startImpression;
    @Column(name = "EndImpression")
    private Integer endImpression;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DiscountPercent")
    private BigDecimal discountPercent;
    @Column(name = "TotalDays")
    private Integer totalDays;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @JoinColumn(name = "TimePeriodId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Timeperiod timePeriodId;

    public Volumediscount() {
    }

    public Volumediscount(Integer id) {
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

    public Integer getStartImpression() {
        return startImpression;
    }

    public void setStartImpression(Integer startImpression) {
        this.startImpression = startImpression;
    }

    public Integer getEndImpression() {
        return endImpression;
    }

    public void setEndImpression(Integer endImpression) {
        this.endImpression = endImpression;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volumediscount)) {
            return false;
        }
        Volumediscount other = (Volumediscount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Volumediscount[ id=" + id + " ]";
    }
    
}
