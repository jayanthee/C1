/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import com.lrl.c1.entity.Creative;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class CreativelistData implements Serializable {

    private Integer cid;
    private String Name;
    private String Size;
    private String Link;
    private Integer creativeId;
    private Integer planId;
    private Integer planLineId;

    public CreativelistData() {
    }

    public CreativelistData(Integer cid, String Name, String Size, String Link) {
        this.cid = cid;
        this.Name = Name;
        this.Size = Size;
        this.Link = Link;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public void setCreativeId(Integer creativeId) {
       this.creativeId=creativeId;
    }

    
    
     public Integer getCreativeId() {
        return creativeId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getPlanLineId() {
        return planLineId;
    }

    public void setPlanLineId(Integer planLineId) {
        this.planLineId = planLineId;
    }

    
}
