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
import javax.persistence.Lob;
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
@Table(name = "vendors", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendors.findAll", query = "SELECT v FROM Vendors v"),
    @NamedQuery(name = "Vendors.findById", query = "SELECT v FROM Vendors v WHERE v.id = :id"),
    @NamedQuery(name = "Vendors.findByName", query = "SELECT v FROM Vendors v WHERE v.name = :name"),
    @NamedQuery(name = "Vendors.findByLink", query = "SELECT v FROM Vendors v WHERE v.link = :link"),
    @NamedQuery(name = "Vendors.findByCreated", query = "SELECT v FROM Vendors v WHERE v.created = :created"),
    @NamedQuery(name = "Vendors.findByUpdated", query = "SELECT v FROM Vendors v WHERE v.updated = :updated")})
public class Vendors implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Lob
    @Column(name = "Logo")
    private byte[] logo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "vendorId", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList;
    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private List<Inventorysettings> inventorysettingsList;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Userprofile createdBy;

    public Vendors() {
    }

    public Vendors(Integer id) {
        this.id = id;
    }

    public Vendors(Integer id, String name, String link, Date created, Date updated) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.created = created;
        this.updated = updated;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
    public List<Adunits> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<Adunits> adunitsList) {
        this.adunitsList = adunitsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Inventorysettings> getInventorysettingsList() {
        return inventorysettingsList;
    }

    public void setInventorysettingsList(List<Inventorysettings> inventorysettingsList) {
        this.inventorysettingsList = inventorysettingsList;
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
        if (!(object instanceof Vendors)) {
            return false;
        }
        Vendors other = (Vendors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Vendors[ id=" + id + " ]";
    }
    
}
