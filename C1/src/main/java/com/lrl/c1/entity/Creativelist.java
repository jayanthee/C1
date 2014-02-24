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
@Table(name = "creativelist", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creativelist.findAll", query = "SELECT c FROM Creativelist c"),
    @NamedQuery(name = "Creativelist.findById", query = "SELECT c FROM Creativelist c WHERE c.id = :id"),
    @NamedQuery(name = "Creativelist.findByName", query = "SELECT c FROM Creativelist c WHERE c.name = :name"),
    @NamedQuery(name = "Creativelist.findByLink", query = "SELECT c FROM Creativelist c WHERE c.link = :link"),
    @NamedQuery(name = "Creativelist.findBySizes", query = "SELECT c FROM Creativelist c WHERE c.sizes = :sizes"),
    @NamedQuery(name = "Creativelist.findByTag", query = "SELECT c FROM Creativelist c WHERE c.tag = :tag"),
    @NamedQuery(name = "Creativelist.findByIntegrationId", query = "SELECT c FROM Creativelist c WHERE c.integrationId = :integrationId"),
    @NamedQuery(name = "Creativelist.findByCreated", query = "SELECT c FROM Creativelist c WHERE c.created = :created"),
    @NamedQuery(name = "Creativelist.findByUpdated", query = "SELECT c FROM Creativelist c WHERE c.updated = :updated")})
public class Creativelist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 180)
    @Column(name = "Name")
    private String name;
    @Size(max = 6000)
    @Column(name = "Link")
    private String link;
    @Size(max = 300)
    @Column(name = "Sizes")
    private String sizes;
    @Size(max = 6000)
    @Column(name = "Tag")
    private String tag;
    @Size(max = 50)
    @Column(name = "IntegrationId")
    private String integrationId;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "PlanId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mediaplan planId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;
    @OneToMany(mappedBy = "creativeListId", fetch = FetchType.LAZY)
    private List<Creative> creativeList;

    public Creativelist() {
    }

    public Creativelist(Integer id) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public Mediaplan getPlanId() {
        return planId;
    }

    public void setPlanId(Mediaplan planId) {
        this.planId = planId;
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
    public List<Creative> getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(List<Creative> creativeList) {
        this.creativeList = creativeList;
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
        if (!(object instanceof Creativelist)) {
            return false;
        }
        Creativelist other = (Creativelist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Creativelist[ id=" + id + " ]";
    }
    
}
