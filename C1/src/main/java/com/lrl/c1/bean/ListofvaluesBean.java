/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.bean;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author logic
 */
public class ListofvaluesBean implements Serializable {
    private Integer id;
    private String name;    
    private String value;    
    private String description;    
    private List<ListofvaluesBean> listofvaluesList;    
    private ListofvaluesBean parentId;

    public ListofvaluesBean() {
    }

    public ListofvaluesBean(Integer id) {
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

    public List<ListofvaluesBean> getListofvaluesList() {
        return listofvaluesList;
    }

    public void setListofvaluesList(List<ListofvaluesBean> listofvaluesList) {
        this.listofvaluesList = listofvaluesList;
    }

    public ListofvaluesBean getParentId() {
        return parentId;
    }

    public void setParentId(ListofvaluesBean parentId) {
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
        if (!(object instanceof ListofvaluesBean)) {
            return false;
        }
        ListofvaluesBean other = (ListofvaluesBean) object;
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
