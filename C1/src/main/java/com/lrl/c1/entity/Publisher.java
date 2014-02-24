/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "publisher", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publisher.findAll", query = "SELECT p FROM Publisher p"),
    @NamedQuery(name = "Publisher.findById", query = "SELECT p FROM Publisher p WHERE p.id = :id"),
    @NamedQuery(name = "Publisher.findByName", query = "SELECT p FROM Publisher p WHERE p.name = :name"),
    @NamedQuery(name = "Publisher.findByOverview", query = "SELECT p FROM Publisher p WHERE p.overview = :overview"),
    @NamedQuery(name = "Publisher.findByCreated", query = "SELECT p FROM Publisher p WHERE p.created = :created"),
    @NamedQuery(name = "Publisher.findByUpdated", query = "SELECT p FROM Publisher p WHERE p.updated = :updated")})
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "Name")
    private String name;
    @Size(max = 6000)
    @Column(name = "Overview")
    private String overview;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Placements> placementsList;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Inventorytype> inventorytypeList;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Inventorysettings> inventorysettingsList;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisherid", fetch = FetchType.LAZY)
    private List<Publishercategory> publishercategoryList;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Timeperiod> timeperiodList;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Mediaplanline> mediaplanlineList;
    @OneToMany(mappedBy = "publisherId", fetch = FetchType.LAZY)
    private List<Publishercontact> publishercontactList;

    public Publisher() {
    }

    public Publisher(Integer id) {
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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
    public List<Inventorytype> getInventorytypeList() {
        return inventorytypeList;
    }

    public void setInventorytypeList(List<Inventorytype> inventorytypeList) {
        this.inventorytypeList = inventorytypeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunits> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<Adunits> adunitsList) {
        this.adunitsList = adunitsList;
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
    public List<Inventorysettings> getInventorysettingsList() {
        return inventorysettingsList;
    }

    public void setInventorysettingsList(List<Inventorysettings> inventorysettingsList) {
        this.inventorysettingsList = inventorysettingsList;
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
    public List<Publishercategory> getPublishercategoryList() {
        return publishercategoryList;
    }

    public void setPublishercategoryList(List<Publishercategory> publishercategoryList) {
        this.publishercategoryList = publishercategoryList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Timeperiod> getTimeperiodList() {
        return timeperiodList;
    }

    public void setTimeperiodList(List<Timeperiod> timeperiodList) {
        this.timeperiodList = timeperiodList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplanline> getMediaplanlineList() {
        return mediaplanlineList;
    }

    public void setMediaplanlineList(List<Mediaplanline> mediaplanlineList) {
        this.mediaplanlineList = mediaplanlineList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Publishercontact> getPublishercontactList() {
        return publishercontactList;
    }

    public void setPublishercontactList(List<Publishercontact> publishercontactList) {
        this.publishercontactList = publishercontactList;
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
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Publisher[ id=" + id + " ]";
    }
    
}
