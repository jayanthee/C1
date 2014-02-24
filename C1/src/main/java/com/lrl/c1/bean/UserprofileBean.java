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
public class UserprofileBean implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String emailId;
    private String timeZone;
    private String contactNo;
    private String type;
    private String status;
    private String userName;
    private String passWord;
    private String userId;
    private List<DemographyBean> demographyList;
    private List<DemographyBean> demographyList1;
    private List<TargetingBean> targetingList;
    private List<TargetingBean> targetingList1;
    private List<PlacementsBean> placementsList;
    private List<PlacementsBean> placementsList1;
    private List<CreativeBean> creativeList;
    private List<CreativeBean> creativeList1;
    private List<InventorytypeBean> inventorytypeList;
    private List<InventorytypeBean> inventorytypeList1;
    private List<MediaplanBean> mediaplanList;
    private List<MediaplanBean> mediaplanList1;
    private List<AgencyBean> agencyList;
    private List<AgencyBean> agencyList1;
    private List<AdunitsplacementsBean> adunitsplacementsList;
    private List<AdunitsplacementsBean> adunitsplacementsList1;
    private List<PaymentmethodBean> paymentmethodList;
    private List<PaymentmethodBean> paymentmethodList1;
    private List<AdunitsBean> adunitsList;
    private List<AdunitsBean> adunitsList1;
    private List<MediaplanlineBean> mediaplanlineList;
    private List<MediaplanlineBean> mediaplanlineList1;
    private List<PlacementtypelistBean> placementtypelistList;
    private List<PlacementtypelistBean> placementtypelistList1;
    private List<PublisherBean> publisherList;
    private List<PublisherBean> publisherList1;
    private List<CategorylistBean> categorylistList;
    private List<CategorylistBean> categorylistList1;
    private List<GeographyBean> geographyList;
    private List<GeographyBean> geographyList1;
    private List<InvtargetingBean> invtargetingList;
    private List<InvtargetingBean> invtargetingList1;
    private List<AdvertiserBean> advertiserList;
    private List<AdvertiserBean> advertiserList1;
    private List<PublishercontactBean> publishercontactList;
    private List<PublishercontactBean> publishercontactList1;

    public UserprofileBean() {
    }

    public UserprofileBean(Integer id) {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<DemographyBean> getDemographyList() {
        return demographyList;
    }

    public void setDemographyList(List<DemographyBean> demographyList) {
        this.demographyList = demographyList;
    }

    public List<DemographyBean> getDemographyList1() {
        return demographyList1;
    }

    public void setDemographyList1(List<DemographyBean> demographyList1) {
        this.demographyList1 = demographyList1;
    }

    public List<TargetingBean> getTargetingList() {
        return targetingList;
    }

    public void setTargetingList(List<TargetingBean> targetingList) {
        this.targetingList = targetingList;
    }

    public List<TargetingBean> getTargetingList1() {
        return targetingList1;
    }

    public void setTargetingList1(List<TargetingBean> targetingList1) {
        this.targetingList1 = targetingList1;
    }

    public List<PlacementsBean> getPlacementsList() {
        return placementsList;
    }

    public void setPlacementsList(List<PlacementsBean> placementsList) {
        this.placementsList = placementsList;
    }

    public List<PlacementsBean> getPlacementsList1() {
        return placementsList1;
    }

    public void setPlacementsList1(List<PlacementsBean> placementsList1) {
        this.placementsList1 = placementsList1;
    }

    public List<CreativeBean> getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(List<CreativeBean> creativeList) {
        this.creativeList = creativeList;
    }

    public List<CreativeBean> getCreativeList1() {
        return creativeList1;
    }

    public void setCreativeList1(List<CreativeBean> creativeList1) {
        this.creativeList1 = creativeList1;
    }

    public List<InventorytypeBean> getInventorytypeList() {
        return inventorytypeList;
    }

    public void setInventorytypeList(List<InventorytypeBean> inventorytypeList) {
        this.inventorytypeList = inventorytypeList;
    }

    public List<InventorytypeBean> getInventorytypeList1() {
        return inventorytypeList1;
    }

    public void setInventorytypeList1(List<InventorytypeBean> inventorytypeList1) {
        this.inventorytypeList1 = inventorytypeList1;
    }

    public List<MediaplanBean> getMediaplanList() {
        return mediaplanList;
    }

    public void setMediaplanList(List<MediaplanBean> mediaplanList) {
        this.mediaplanList = mediaplanList;
    }

    public List<MediaplanBean> getMediaplanList1() {
        return mediaplanList1;
    }

    public void setMediaplanList1(List<MediaplanBean> mediaplanList1) {
        this.mediaplanList1 = mediaplanList1;
    }

    public List<AgencyBean> getAgencyList() {
        return agencyList;
    }

    public void setAgencyList(List<AgencyBean> agencyList) {
        this.agencyList = agencyList;
    }

    public List<AgencyBean> getAgencyList1() {
        return agencyList1;
    }

    public void setAgencyList1(List<AgencyBean> agencyList1) {
        this.agencyList1 = agencyList1;
    }

    public List<AdunitsplacementsBean> getAdunitsplacementsList() {
        return adunitsplacementsList;
    }

    public void setAdunitsplacementsList(List<AdunitsplacementsBean> adunitsplacementsList) {
        this.adunitsplacementsList = adunitsplacementsList;
    }

    public List<AdunitsplacementsBean> getAdunitsplacementsList1() {
        return adunitsplacementsList1;
    }

    public void setAdunitsplacementsList1(List<AdunitsplacementsBean> adunitsplacementsList1) {
        this.adunitsplacementsList1 = adunitsplacementsList1;
    }

    public List<PaymentmethodBean> getPaymentmethodList() {
        return paymentmethodList;
    }

    public void setPaymentmethodList(List<PaymentmethodBean> paymentmethodList) {
        this.paymentmethodList = paymentmethodList;
    }

    public List<PaymentmethodBean> getPaymentmethodList1() {
        return paymentmethodList1;
    }

    public void setPaymentmethodList1(List<PaymentmethodBean> paymentmethodList1) {
        this.paymentmethodList1 = paymentmethodList1;
    }

    public List<AdunitsBean> getAdunitsList() {
        return adunitsList;
    }

    public void setAdunitsList(List<AdunitsBean> adunitsList) {
        this.adunitsList = adunitsList;
    }

    public List<AdunitsBean> getAdunitsList1() {
        return adunitsList1;
    }

    public void setAdunitsList1(List<AdunitsBean> adunitsList1) {
        this.adunitsList1 = adunitsList1;
    }

    public List<MediaplanlineBean> getMediaplanlineList() {
        return mediaplanlineList;
    }

    public void setMediaplanlineList(List<MediaplanlineBean> mediaplanlineList) {
        this.mediaplanlineList = mediaplanlineList;
    }

    public List<MediaplanlineBean> getMediaplanlineList1() {
        return mediaplanlineList1;
    }

    public void setMediaplanlineList1(List<MediaplanlineBean> mediaplanlineList1) {
        this.mediaplanlineList1 = mediaplanlineList1;
    }

    public List<PlacementtypelistBean> getPlacementtypelistList() {
        return placementtypelistList;
    }

    public void setPlacementtypelistList(List<PlacementtypelistBean> placementtypelistList) {
        this.placementtypelistList = placementtypelistList;
    }

    public List<PlacementtypelistBean> getPlacementtypelistList1() {
        return placementtypelistList1;
    }

    public void setPlacementtypelistList1(List<PlacementtypelistBean> placementtypelistList1) {
        this.placementtypelistList1 = placementtypelistList1;
    }

    public List<PublisherBean> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<PublisherBean> publisherList) {
        this.publisherList = publisherList;
    }

    public List<PublisherBean> getPublisherList1() {
        return publisherList1;
    }

    public void setPublisherList1(List<PublisherBean> publisherList1) {
        this.publisherList1 = publisherList1;
    }

    public List<CategorylistBean> getCategorylistList() {
        return categorylistList;
    }

    public void setCategorylistList(List<CategorylistBean> categorylistList) {
        this.categorylistList = categorylistList;
    }

    public List<CategorylistBean> getCategorylistList1() {
        return categorylistList1;
    }

    public void setCategorylistList1(List<CategorylistBean> categorylistList1) {
        this.categorylistList1 = categorylistList1;
    }

    public List<GeographyBean> getGeographyList() {
        return geographyList;
    }

    public void setGeographyList(List<GeographyBean> geographyList) {
        this.geographyList = geographyList;
    }

    public List<GeographyBean> getGeographyList1() {
        return geographyList1;
    }

    public void setGeographyList1(List<GeographyBean> geographyList1) {
        this.geographyList1 = geographyList1;
    }

    public List<InvtargetingBean> getInvtargetingList() {
        return invtargetingList;
    }

    public void setInvtargetingList(List<InvtargetingBean> invtargetingList) {
        this.invtargetingList = invtargetingList;
    }

    public List<InvtargetingBean> getInvtargetingList1() {
        return invtargetingList1;
    }

    public void setInvtargetingList1(List<InvtargetingBean> invtargetingList1) {
        this.invtargetingList1 = invtargetingList1;
    }

    public List<AdvertiserBean> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(List<AdvertiserBean> advertiserList) {
        this.advertiserList = advertiserList;
    }

    public List<AdvertiserBean> getAdvertiserList1() {
        return advertiserList1;
    }

    public void setAdvertiserList1(List<AdvertiserBean> advertiserList1) {
        this.advertiserList1 = advertiserList1;
    }

    public List<PublishercontactBean> getPublishercontactList() {
        return publishercontactList;
    }

    public void setPublishercontactList(List<PublishercontactBean> publishercontactList) {
        this.publishercontactList = publishercontactList;
    }

    public List<PublishercontactBean> getPublishercontactList1() {
        return publishercontactList1;
    }

    public void setPublishercontactList1(List<PublishercontactBean> publishercontactList1) {
        this.publishercontactList1 = publishercontactList1;
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
        if (!(object instanceof UserprofileBean)) {
            return false;
        }
        UserprofileBean other = (UserprofileBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lrl.c1.buyside.entity.Userprofile[ id=" + id + " ]";
    }
}
