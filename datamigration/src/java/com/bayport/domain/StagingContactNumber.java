package com.bayport.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "staging_contact_number")
public class StagingContactNumber {

    private Long contactNumberId;

    private DateTime fromDate;

    private DateTime toDate;

    private String contactNumber;

    private MasterLookUpTypeValue contactNumberLookUpType;

//    private StagingAgent stagingAgent;

    @Id
    @GeneratedValue
    @Column(name = "contact_number_id")
    public Long getContactNumberId() {
        return contactNumberId;
    }

    public void setContactNumberId(Long contactNumberId) {
        this.contactNumberId = contactNumberId;
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

    @Column(name = "contact_number")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "contact_number_type_id", referencedColumnName = "id", nullable = false)
    public MasterLookUpTypeValue getContactNumberLookUpType() {
        return contactNumberLookUpType;
    }

    public void setContactNumberLookUpType(MasterLookUpTypeValue contactNumberLookUpType) {
        this.contactNumberLookUpType = contactNumberLookUpType;
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
