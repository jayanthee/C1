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
@Table(name = "timeperiod", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeperiod.findAll", query = "SELECT t FROM Timeperiod t"),
    @NamedQuery(name = "Timeperiod.findById", query = "SELECT t FROM Timeperiod t WHERE t.id = :id"),
    @NamedQuery(name = "Timeperiod.findByName", query = "SELECT t FROM Timeperiod t WHERE t.name = :name"),
    @NamedQuery(name = "Timeperiod.findByStartDate", query = "SELECT t FROM Timeperiod t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Timeperiod.findByEndDate", query = "SELECT t FROM Timeperiod t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "Timeperiod.findByStatus", query = "SELECT t FROM Timeperiod t WHERE t.status = :status"),
    @NamedQuery(name = "Timeperiod.findByCreated", query = "SELECT t FROM Timeperiod t WHERE t.created = :created"),
    @NamedQuery(name = "Timeperiod.findByUpdated", query = "SELECT t FROM Timeperiod t WHERE t.updated = :updated")})
public class Timeperiod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Name")
    private String name;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 8)
    @Column(name = "Status")
    private String status;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "timePeriodId", fetch = FetchType.LAZY)
    private List<Volumediscount> volumediscountList;
    @OneToMany(mappedBy = "timePeriodId", fetch = FetchType.LAZY)
    private List<Ratecard> ratecardList;
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;

    public Timeperiod() {
    }

    public Timeperiod(Integer id) {
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
    public List<Volumediscount> getVolumediscountList() {
        return volumediscountList;
    }

    public void setVolumediscountList(List<Volumediscount> volumediscountList) {
        this.volumediscountList = volumediscountList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ratecard> getRatecardList() {
        return ratecardList;
    }

    public void setRatecardList(List<Ratecard> ratecardList) {
        this.ratecardList = ratecardList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timeperiod)) {
            return false;
        }
        Timeperiod other = (Timeperiod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Timeperiod[ id=" + id + " ]";
    }
    
}
