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
@Table(name = "paymentmethod", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentmethod.findAll", query = "SELECT p FROM Paymentmethod p"),
    @NamedQuery(name = "Paymentmethod.findById", query = "SELECT p FROM Paymentmethod p WHERE p.id = :id"),
    @NamedQuery(name = "Paymentmethod.findByPaymentMethod", query = "SELECT p FROM Paymentmethod p WHERE p.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Paymentmethod.findByPaymentDetails", query = "SELECT p FROM Paymentmethod p WHERE p.paymentDetails = :paymentDetails"),
    @NamedQuery(name = "Paymentmethod.findByCreditName", query = "SELECT p FROM Paymentmethod p WHERE p.creditName = :creditName"),
    @NamedQuery(name = "Paymentmethod.findByCreditNumber", query = "SELECT p FROM Paymentmethod p WHERE p.creditNumber = :creditNumber"),
    @NamedQuery(name = "Paymentmethod.findByExpireDate", query = "SELECT p FROM Paymentmethod p WHERE p.expireDate = :expireDate"),
    @NamedQuery(name = "Paymentmethod.findByCreated", query = "SELECT p FROM Paymentmethod p WHERE p.created = :created"),
    @NamedQuery(name = "Paymentmethod.findByUpdated", query = "SELECT p FROM Paymentmethod p WHERE p.updated = :updated")})
public class Paymentmethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Size(max = 300)
    @Column(name = "PaymentDetails")
    private String paymentDetails;
    @Size(max = 150)
    @Column(name = "CreditName")
    private String creditName;
    @Size(max = 150)
    @Column(name = "CreditNumber")
    private String creditNumber;
    @Column(name = "ExpireDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;
    @Column(name = "Created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "Updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account accountId;
    @JoinColumn(name = "UpdatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile updatedBy;
    @JoinColumn(name = "CreatedBy", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Userprofile createdBy;

    public Paymentmethod() {
    }

    public Paymentmethod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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
        if (!(object instanceof Paymentmethod)) {
            return false;
        }
        Paymentmethod other = (Paymentmethod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Paymentmethod[ id=" + id + " ]";
    }
    
}
