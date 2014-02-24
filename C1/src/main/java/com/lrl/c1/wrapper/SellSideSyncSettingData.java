/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lrl.c1.wrapper;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author logic
 */
@XmlRootElement
public class SellSideSyncSettingData implements Serializable {
    // vendors table
    private Integer VenId;
    private String VenName;
    private String VenLogo;
    private String VenLink;
    private byte[] VenImage;
    // Inventory settings table 
    private Integer InvSyncId;
    private Integer VenInvSyncId;
    private String InvSyncUserName;
    private String InvSyncPwd;
    private String InvSyncStatus;
    private Integer InvSyncTotImp;
    private Integer InvSyncPubInvPercent;
    private Integer InvSyncPrInvPercent;  
    private Integer InvSyncPubId;
    
    
    private static final Logger LOG = Logger.getLogger(SellSideSyncSettingData.class.getName());

    public SellSideSyncSettingData() {
    }

    public SellSideSyncSettingData(Integer VenId, String VenName, String VenLogo, String VenLink) {
        this.VenId = VenId;
        this.VenName = VenName;
        this.VenLogo = VenLogo;
        this.VenLink = VenLink;    
    }
    
    public SellSideSyncSettingData(Integer VenId, String VenName, String VenLogo, String VenLink, byte[] VenImage) {
        this.VenId = VenId;
        this.VenName = VenName;
        this.VenLogo = VenLogo;
        this.VenLink = VenLink;
        this.VenImage = VenImage;
    }

    public SellSideSyncSettingData(Integer InvSyncId, Integer VenInvSyncId, String InvSyncUserName, String InvSyncPwd, String InvSyncStatus, Integer InvSyncTotImp, Integer InvSyncPubInvPercent, Integer InvSyncPrInvPercent, Integer InvSyncPubId) {
        this.InvSyncId = InvSyncId;
        this.VenInvSyncId = VenInvSyncId;
        this.InvSyncUserName = InvSyncUserName;
        this.InvSyncPwd = InvSyncPwd;
        this.InvSyncStatus = InvSyncStatus;
        this.InvSyncTotImp = InvSyncTotImp;
        this.InvSyncPubInvPercent = InvSyncPubInvPercent;
        this.InvSyncPrInvPercent = InvSyncPrInvPercent;
        this.InvSyncPubId = InvSyncPubId;
    }

    public SellSideSyncSettingData(Integer VenId, String VenName, String VenLogo, String VenLink, Integer InvSyncId, Integer VenInvSyncId, String InvSyncUserName, String InvSyncPwd, String InvSyncStatus, Integer InvSyncTotImp, Integer InvSyncPubInvPercent, Integer InvSyncPrInvPercent,Integer InvSyncPubId) {
        this.VenId = VenId;
        this.VenName = VenName;
        this.VenLogo = VenLogo;
        this.VenLink = VenLink;
        this.InvSyncId = InvSyncId;
        this.VenInvSyncId = VenInvSyncId;
        this.InvSyncUserName = InvSyncUserName;
        this.InvSyncPwd = InvSyncPwd;
        this.InvSyncStatus = InvSyncStatus;
        this.InvSyncTotImp = InvSyncTotImp;
        this.InvSyncPubInvPercent = InvSyncPubInvPercent;
        this.InvSyncPrInvPercent = InvSyncPrInvPercent;
        this.InvSyncPubId = InvSyncPubId;
    }

       
    
    public Integer getVenId() {
        return VenId;
    }

    public void setVenId(Integer VenId) {
        this.VenId = VenId;
    }

    public String getVenName() {
        return VenName;
    }

    public void setVenName(String VenName) {
        this.VenName = VenName;
    }

    public String getVenLogo() {
        return VenLogo;
    }

    public void setVenLogo(String VenLogo) {
        this.VenLogo = VenLogo;
    }

    public String getVenLink() {
        return VenLink;
    }

    public void setVenLink(String VenLink) {
        this.VenLink = VenLink;
    }

    public byte[] getVenImage() {
        return VenImage;
    }

    public void setVenImage(byte[] VenImage) {
        this.VenImage = VenImage;
    }
    
    public Integer getInvSyncId() {
        return InvSyncId;
    }

    public void setInvSyncId(Integer InvSyncId) {
        this.InvSyncId = InvSyncId;
    }

    public Integer getVenInvSyncId() {
        return VenInvSyncId;
    }

    public void setVenInvSyncId(Integer VenInvSyncId) {
        this.VenInvSyncId = VenInvSyncId;
    }

    public String getInvSyncUserName() {
        return InvSyncUserName;
    }

    public void setInvSyncUserName(String InvSyncUserName) {
        this.InvSyncUserName = InvSyncUserName;
    }

    public String getInvSyncPwd() {
        return InvSyncPwd;
    }

    public void setInvSyncPwd(String InvSyncPwd) {
        this.InvSyncPwd = InvSyncPwd;
    }

    public String getInvSyncStatus() {
        return InvSyncStatus;
    }

    public void setInvSyncStatus(String InvSyncStatus) {
        this.InvSyncStatus = InvSyncStatus;
    }

    public Integer getInvSyncTotImp() {
        return InvSyncTotImp;
    }

    public void setInvSyncTotImp(Integer InvSyncTotImp) {
        this.InvSyncTotImp = InvSyncTotImp;
    }

    public Integer getInvSyncPubInvPercent() {
        return InvSyncPubInvPercent;
    }

    public void setInvSyncPubInvPercent(Integer InvSyncPubInvPercent) {
        this.InvSyncPubInvPercent = InvSyncPubInvPercent;
    }

    public Integer getInvSyncPrInvPercent() {
        return InvSyncPrInvPercent;
    }

    public void setInvSyncPrInvPercent(Integer InvSyncPrInvPercent) {
        this.InvSyncPrInvPercent = InvSyncPrInvPercent;
    }

    public Integer getInvSyncPubId() {
        return InvSyncPubId;
    }

    public void setInvSyncPubId(Integer InvSyncPubId) {
        this.InvSyncPubId = InvSyncPubId;
    }
   
    
    
    
}
