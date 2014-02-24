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
@Table(name = "userprofile", catalog = "c1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userprofile.findAll", query = "SELECT u FROM Userprofile u"),
    @NamedQuery(name = "Userprofile.findById", query = "SELECT u FROM Userprofile u WHERE u.id = :id"),
    @NamedQuery(name = "Userprofile.findByFirstName", query = "SELECT u FROM Userprofile u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Userprofile.findByLastName", query = "SELECT u FROM Userprofile u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Userprofile.findByMiddleName", query = "SELECT u FROM Userprofile u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "Userprofile.findByEmailId", query = "SELECT u FROM Userprofile u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "Userprofile.findByTimeZone", query = "SELECT u FROM Userprofile u WHERE u.timeZone = :timeZone"),
    @NamedQuery(name = "Userprofile.findByContactNo", query = "SELECT u FROM Userprofile u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "Userprofile.findByType", query = "SELECT u FROM Userprofile u WHERE u.type = :type"),
    @NamedQuery(name = "Userprofile.findByStatus", query = "SELECT u FROM Userprofile u WHERE u.status = :status"),
    @NamedQuery(name = "Userprofile.findByUserName", query = "SELECT u FROM Userprofile u WHERE u.userName = :userName"),
    @NamedQuery(name = "Userprofile.findByPassWord", query = "SELECT u FROM Userprofile u WHERE u.passWord = :passWord")})
public class Userprofile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 300)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 300)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 300)
    @Column(name = "MiddleName")
    private String middleName;
    @Size(max = 600)
    @Column(name = "EmailId")
    private String emailId;
    @Size(max = 300)
    @Column(name = "TimeZone")
    private String timeZone;
    @Size(max = 300)
    @Column(name = "ContactNo")
    private String contactNo;
    @Size(max = 13)
    @Column(name = "Type")
    private String type;
    @Size(max = 8)
    @Column(name = "Status")
    private String status;
    @Size(max = 300)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 600)
    @Column(name = "PassWord")
    private String passWord;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Targeting> targetingList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Targeting> targetingList1;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Placements> placementsList;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Placements> placementsList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Inventorytype> inventorytypeList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Inventorytype> inventorytypeList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Mediaplan> mediaplanList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Mediaplan> mediaplanList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Creativelist> creativelistList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Creativelist> creativelistList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Paymentmethod> paymentmethodList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Paymentmethod> paymentmethodList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Adunits> adunitsList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Publisher> publisherList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Publisher> publisherList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Inventorysettings> inventorysettingsList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Inventorysettings> inventorysettingsList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Volumediscount> volumediscountList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Volumediscount> volumediscountList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Ratecard> ratecardList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Ratecard> ratecardList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Invtargeting> invtargetingList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Impressionsettings> impressionsettingsList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Impressionsettings> impressionsettingsList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Creative> creativeList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Creative> creativeList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Adunitimpression> adunitimpressionList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Adunitimpression> adunitimpressionList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Timeperiod> timeperiodList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Timeperiod> timeperiodList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Adunitsplacements> adunitsplacementsList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Adunitsplacements> adunitsplacementsList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Mediaplanline> mediaplanlineList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Mediaplanline> mediaplanlineList1;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Advertiser> advertiserList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Advertiser> advertiserList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Vendors> vendorsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Vendors> vendorsList1;
    @JoinColumn(name = "AccountId", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Account accountId;
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<Publishercontact> publishercontactList;
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Publishercontact> publishercontactList1;

    public Userprofile() {
    }

    public Userprofile(Integer id) {
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

    @XmlTransient
    @JsonIgnore
    public List<Targeting> getTargetingList() {
        return targetingList;
    }

    public void setTargetingList(List<Targeting> targetingList) {
        this.targetingList = targetingList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Targeting> getTargetingList1() {
        return targetingList1;
    }

    public void setTargetingList1(List<Targeting> targetingList1) {
        this.targetingList1 = targetingList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Placements> getPlacementsList() {
        return placementsList;
    }

    public void setPlacementsList(List<Placements> placementsList) {
        this.placementsList = placementsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Placements> getPlacementsList1() {
        return placementsList1;
    }

    public void setPlacementsList1(List<Placements> placementsList1) {
        this.placementsList1 = placementsList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Inventorytype> getInventorytypeList() {
        return inventorytypeList;
    }

    public void setInventorytypeList(List<Inventorytype> inventorytypeList) {
        this.inventorytypeList = inventorytypeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Inventorytype> getInventorytypeList1() {
        return inventorytypeList1;
    }

    public void setInventorytypeList1(List<Inventorytype> inventorytypeList1) {
        this.inventorytypeList1 = inventorytypeList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplan> getMediaplanList() {
        return mediaplanList;
    }

    public void setMediaplanList(List<Mediaplan> mediaplanList) {
        this.mediaplanList = mediaplanList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplan> getMediaplanList1() {
        return mediaplanList1;
    }

    public void setMediaplanList1(List<Mediaplan> mediaplanList1) {
        this.mediaplanList1 = mediaplanList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Creativelist> getCreativelistList() {
        return creativelistList;
    }

    public void setCreativelistList(List<Creativelist> creativelistList) {
        this.creativelistList = creativelistList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Creativelist> getCreativelistList1() {
        return creativelistList1;
    }

    public void setCreativelistList1(List<Creativelist> creativelistList1) {
        this.creativelistList1 = creativelistList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Paymentmethod> getPaymentmethodList() {
        return paymentmethodList;
    }

    public void setPaymentmethodList(List<Paymentmethod> paymentmethodList) {
        this.paymentmethodList = paymentmethodList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Paymentmethod> getPaymentmethodList1() {
        return paymentmethodList1;
    }

    public void setPaymentmethodList1(List<Paymentmethod> paymentmethodList1) {
        this.paymentmethodList1 = paymentmethodList1;
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
    public List<Adunits> getAdunitsList1() {
        return adunitsList1;
    }

    public void setAdunitsList1(List<Adunits> adunitsList1) {
        this.adunitsList1 = adunitsList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Publisher> getPublisherList1() {
        return publisherList1;
    }

    public void setPublisherList1(List<Publisher> publisherList1) {
        this.publisherList1 = publisherList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Inventorysettings> getInventorysettingsList() {
        return inventorysettingsList;
    }

    public void setInventorysettingsList(List<Inventorysettings> inventorysettingsList) {
        this.inventorysettingsList = inventorysettingsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Inventorysettings> getInventorysettingsList1() {
        return inventorysettingsList1;
    }

    public void setInventorysettingsList1(List<Inventorysettings> inventorysettingsList1) {
        this.inventorysettingsList1 = inventorysettingsList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Volumediscount> getVolumediscountList() {
        return volumediscountList;
    }

    public void setVolumediscountList(List<Volumediscount> volumediscountList) {
        this.volumediscountList = volumediscountList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Volumediscount> getVolumediscountList1() {
        return volumediscountList1;
    }

    public void setVolumediscountList1(List<Volumediscount> volumediscountList1) {
        this.volumediscountList1 = volumediscountList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ratecard> getRatecardList() {
        return ratecardList;
    }

    public void setRatecardList(List<Ratecard> ratecardList) {
        this.ratecardList = ratecardList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ratecard> getRatecardList1() {
        return ratecardList1;
    }

    public void setRatecardList1(List<Ratecard> ratecardList1) {
        this.ratecardList1 = ratecardList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Invtargeting> getInvtargetingList() {
        return invtargetingList;
    }

    public void setInvtargetingList(List<Invtargeting> invtargetingList) {
        this.invtargetingList = invtargetingList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Invtargeting> getInvtargetingList1() {
        return invtargetingList1;
    }

    public void setInvtargetingList1(List<Invtargeting> invtargetingList1) {
        this.invtargetingList1 = invtargetingList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Impressionsettings> getImpressionsettingsList() {
        return impressionsettingsList;
    }

    public void setImpressionsettingsList(List<Impressionsettings> impressionsettingsList) {
        this.impressionsettingsList = impressionsettingsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Impressionsettings> getImpressionsettingsList1() {
        return impressionsettingsList1;
    }

    public void setImpressionsettingsList1(List<Impressionsettings> impressionsettingsList1) {
        this.impressionsettingsList1 = impressionsettingsList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Creative> getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(List<Creative> creativeList) {
        this.creativeList = creativeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Creative> getCreativeList1() {
        return creativeList1;
    }

    public void setCreativeList1(List<Creative> creativeList1) {
        this.creativeList1 = creativeList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitimpression> getAdunitimpressionList() {
        return adunitimpressionList;
    }

    public void setAdunitimpressionList(List<Adunitimpression> adunitimpressionList) {
        this.adunitimpressionList = adunitimpressionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitimpression> getAdunitimpressionList1() {
        return adunitimpressionList1;
    }

    public void setAdunitimpressionList1(List<Adunitimpression> adunitimpressionList1) {
        this.adunitimpressionList1 = adunitimpressionList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Timeperiod> getTimeperiodList() {
        return timeperiodList;
    }

    public void setTimeperiodList(List<Timeperiod> timeperiodList) {
        this.timeperiodList = timeperiodList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Timeperiod> getTimeperiodList1() {
        return timeperiodList1;
    }

    public void setTimeperiodList1(List<Timeperiod> timeperiodList1) {
        this.timeperiodList1 = timeperiodList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitsplacements> getAdunitsplacementsList() {
        return adunitsplacementsList;
    }

    public void setAdunitsplacementsList(List<Adunitsplacements> adunitsplacementsList) {
        this.adunitsplacementsList = adunitsplacementsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Adunitsplacements> getAdunitsplacementsList1() {
        return adunitsplacementsList1;
    }

    public void setAdunitsplacementsList1(List<Adunitsplacements> adunitsplacementsList1) {
        this.adunitsplacementsList1 = adunitsplacementsList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplanline> getMediaplanlineList() {
        return mediaplanlineList;
    }

    public void setMediaplanlineList(List<Mediaplanline> mediaplanlineList) {
        this.mediaplanlineList = mediaplanlineList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Mediaplanline> getMediaplanlineList1() {
        return mediaplanlineList1;
    }

    public void setMediaplanlineList1(List<Mediaplanline> mediaplanlineList1) {
        this.mediaplanlineList1 = mediaplanlineList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Advertiser> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(List<Advertiser> advertiserList) {
        this.advertiserList = advertiserList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Advertiser> getAdvertiserList1() {
        return advertiserList1;
    }

    public void setAdvertiserList1(List<Advertiser> advertiserList1) {
        this.advertiserList1 = advertiserList1;
    }

    @XmlTransient
    @JsonIgnore
    public List<Vendors> getVendorsList() {
        return vendorsList;
    }

    public void setVendorsList(List<Vendors> vendorsList) {
        this.vendorsList = vendorsList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Vendors> getVendorsList1() {
        return vendorsList1;
    }

    public void setVendorsList1(List<Vendors> vendorsList1) {
        this.vendorsList1 = vendorsList1;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Publishercontact> getPublishercontactList() {
        return publishercontactList;
    }

    public void setPublishercontactList(List<Publishercontact> publishercontactList) {
        this.publishercontactList = publishercontactList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Publishercontact> getPublishercontactList1() {
        return publishercontactList1;
    }

    public void setPublishercontactList1(List<Publishercontact> publishercontactList1) {
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
        if (!(object instanceof Userprofile)) {
            return false;
        }
        Userprofile other = (Userprofile) object;
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
