/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class UploadData implements Serializable {
    
    private Integer cid;
    private Integer mediaPlanId;
    private Integer mediaPlanLineId; 
    private String Name;
    private String Size;
    private String Link;
    
    public UploadData(){
        
    }

    public UploadData(Integer cid, Integer mediaPlanId, Integer mediaPlanLineId, String Name, String Size, String Link) {
        this.cid = cid;
        this.mediaPlanId = mediaPlanId;
        this.mediaPlanLineId = mediaPlanLineId;
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

    public Integer getMediaPlanId() {
        return mediaPlanId;
    }

    public void setMediaPlanId(Integer mediaPlanId) {
        this.mediaPlanId = mediaPlanId;
    }

    public Integer getMediaPlanLineId() {
        return mediaPlanLineId;
    }

    public void setMediaPlanLineId(Integer mediaPlanLineId) {
        this.mediaPlanLineId = mediaPlanLineId;
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
     
    
    
}
