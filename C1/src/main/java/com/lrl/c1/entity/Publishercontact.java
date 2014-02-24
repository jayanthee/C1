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
@Table(name = "publishercontact", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publishercontact.findAll", query = "SELECT p FROM Publishercontact p"),
    @NamedQuery(name = "Publishercontact.findById", query = "SELECT p FROM Publishercontact p WHERE p.id = :id"),
    @NamedQuery(name = "Publishercontact.findByFirstName", query = "SELECT p FROM Publishercontact p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Publishercontact.findByLastName", query = "SELECT p FROM Publishercontact p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Publishercontact.findByEmailId", query = "SELECT p FROM Publishercontact p WHERE p.emailId = :emailId"),
    @NamedQuery(name = "Publishercontact.findByContactNo", query = "SELECT p FROM Publishercontact p WHERE p.contactNo = :contactNo"),
    @NamedQuery(name = "Publishercontact.findByRole", query = "SELECT p FROM Publishercontact p WHERE p.role = :role"),
    @NamedQuery(name = "Publishercontact.findByImage", query = "SELECT p FROM Publishercontact p WHERE p.image = :image"),
    @NamedQuery(name = "Publishercontact.findByCreated", query = "SELECT p FROM Publishercontact p WHERE p.created = :created"),
    @NamedQuery(name = "Publishercontact.findByUpdated", query = "SELECT p FROM Publishercontact p WHERE p.updated = :updated")})
public class Publishercontact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 300)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 300)
    @Column(name = "EmailId")
    private String emailId;
    @Size(max = 300)
    @Column(name = "ContactNo")
    private String contactNo;
    @Size(max = 300)
    @Column(name = "Role")
    private String role;
    @Size(max = 3000)
    @Column(name = "Image")
    private String image;
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

    public Publishercontact() {
    }

    public Publishercontact(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof Publishercontact)) {
            return false;
        }
        Publishercontact other = (Publishercontact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Publishercontact[ id=" + id + " ]";
    }
    
}
