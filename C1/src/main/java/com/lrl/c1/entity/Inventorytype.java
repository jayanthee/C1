/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
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
@Table(name = "inventorytype", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventorytype.findAll", query = "SELECT i FROM Inventorytype i"),
    @NamedQuery(name = "Inventorytype.findById", query = "SELECT i FROM Inventorytype i WHERE i.id = :id"),
    @NamedQuery(name = "Inventorytype.findByInventoryType", query = "SELECT i FROM Inventorytype i WHERE i.inventoryType = :inventoryType"),
    @NamedQuery(name = "Inventorytype.findByUserId", query = "SELECT i FROM Inventorytype i WHERE i.userId = :userId"),
    @NamedQuery(name = "Inventorytype.findByPassword", query = "SELECT i FROM Inventorytype i WHERE i.password = :password"),
    @NamedQuery(name = "Inventorytype.findByToken", query = "SELECT i FROM Inventorytype i WHERE i.token = :token"),
    @NamedQuery(name = "Inventorytype.findByStatus", query = "SELECT i FROM Inventorytype i WHERE i.status = :status"),
    @NamedQuery(name = "Inventorytype.findByCreated", query = "SELECT i FROM Inventorytype i WHERE i.created = :created"),
    @NamedQuery(name = "Inventorytype.findByUpdated", query = "SELECT i FROM Inventorytype i WHERE i.updated = :updated")})
public class Inventorytype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "InventoryType")
    private String inventoryType;
    @Size(max = 300)
    @Column(name = "UserId")
    private String userId;
    @Size(max = 300)
    @Column(name = "Password")
    private String password;
    @Size(max = 300)
    @Column(name = "Token")
    private String token;
    @Size(max = 150)
    @Column(name = "Status")
    private String status;
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
    @JoinColumn(name = "PublisherId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisherId;

    public Inventorytype() {
    }

    public Inventorytype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventorytype)) {
            return false;
        }
        Inventorytype other = (Inventorytype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Inventorytype[ id=" + id + " ]";
    }
    
}
