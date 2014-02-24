/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author logic
 */
@Entity
@Table(name = "listofvalues", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listofvalues.findAll", query = "SELECT l FROM Listofvalues l"),
    @NamedQuery(name = "Listofvalues.findById", query = "SELECT l FROM Listofvalues l WHERE l.id = :id"),
    @NamedQuery(name = "Listofvalues.findByName", query = "SELECT l FROM Listofvalues l WHERE l.name = :name"),
    @NamedQuery(name = "Listofvalues.findByValue", query = "SELECT l FROM Listofvalues l WHERE l.value = :value"),
    @NamedQuery(name = "Listofvalues.findByDescription", query = "SELECT l FROM Listofvalues l WHERE l.description = :description")})
public class Listofvalues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Size(max = 50)
    @Column(name = "Value")
    private String value;
    @Size(max = 200)
    @Column(name = "Description")
    private String description;
    @OneToMany(mappedBy = "placementType", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryid", fetch = FetchType.LAZY)
    private List<Publishercategory> publishercategoryList;
    @OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
    private List<Listofvalues> listofvaluesList;
    @JoinColumn(name = "ParentId", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Listofvalues parentId;

    public Listofvalues() {
    }

    public Listofvalues(Integer id) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public List<Publishercategory> getPublishercategoryList() {
        return publishercategoryList;
    }

    public void setPublishercategoryList(List<Publishercategory> publishercategoryList) {
        this.publishercategoryList = publishercategoryList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Listofvalues> getListofvaluesList() {
        return listofvaluesList;
    }

    public void setListofvaluesList(List<Listofvalues> listofvaluesList) {
        this.listofvaluesList = listofvaluesList;
    }

    public Listofvalues getParentId() {
        return parentId;
    }

    public void setParentId(Listofvalues parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof Listofvalues)) {
            return false;
        }
        Listofvalues other = (Listofvalues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Listofvalues[ id=" + id + " ]";
    }
    
}
