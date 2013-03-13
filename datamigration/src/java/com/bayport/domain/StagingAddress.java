package com.bayport.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "staging_address")
public class StagingAddress {

    private Long addressId;

    private DateTime fromDate;

    private DateTime toDate;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String postalCode;

    private String comments;

    private MasterLookUpTypeValue addressLookUpType;

    private MasterLookUpTypeValue cityLookUpValue;

    private MasterLookUpTypeValue residenceLookUpType;

    private Integer monthsAtResidence;

    private MasterLookUpTypeValue residentStatusLookUpValue;

//    private StagingAgent stagingAgent;

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }


    @Column(name = "from_date")
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(DateTime fromDate) {
        this.fromDate = fromDate;
    }

    @Column(name = "to_date")
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getToDate() {
        return toDate;
    }

    public void setToDate(DateTime toDate) {
        this.toDate = toDate;
    }

    @javax.persistence.Column(name = "address_line_1")
    @Basic
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @javax.persistence.Column(name = "address_line_2")
    @Basic
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @javax.persistence.Column(name = "address_line_3")
    @Basic
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    @javax.persistence.Column(name = "postal_code")
    @Basic
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @javax.persistence.Column(name = "comments")
    @Basic
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "address_type_id", referencedColumnName = "id", nullable = false)
    public MasterLookUpTypeValue getAddressLookUpType() {
        return addressLookUpType;
    }

    public void setAddressLookUpType(MasterLookUpTypeValue addressLookUpType) {
        this.addressLookUpType = addressLookUpType;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    public MasterLookUpTypeValue getCityLookUpValue() {
        return cityLookUpValue;
    }

    public void setCityLookUpValue(MasterLookUpTypeValue cityLookUpValue) {
        this.cityLookUpValue = cityLookUpValue;
    }

    @ManyToOne
    @JoinColumn(name = "residence_type_id")
    public MasterLookUpTypeValue getResidenceLookUpType() {
        return residenceLookUpType;
    }

    public void setResidenceLookUpType(MasterLookUpTypeValue residenceLookUpType) {
        this.residenceLookUpType = residenceLookUpType;
    }

    @Column(name = "months_at_residence")
    public Integer getMonthsAtResidence() {
        return monthsAtResidence;
    }

    public void setMonthsAtResidence(Integer monthsAtResidence) {
        this.monthsAtResidence = monthsAtResidence;
    }

    @ManyToOne
    @JoinColumn(name = "resident_status_id")
    public MasterLookUpTypeValue getResidentStatusLookUpValue() {
        return residentStatusLookUpValue;
    }

    public void setResidentStatusLookUpValue(MasterLookUpTypeValue residentStatusLookUpValue) {
        this.residentStatusLookUpValue = residentStatusLookUpValue;
    }

/*    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = true)
    public StagingAgent getStagingAgent() {
        return stagingAgent;
    }

    public void setStagingAgent(StagingAgent stagingAgent) {
        this.stagingAgent = stagingAgent;
    }*/
}
