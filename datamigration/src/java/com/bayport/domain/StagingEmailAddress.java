package com.bayport.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: JAVADEV05
 * Date: 2013/03/12
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "staging_email_address")
public class StagingEmailAddress {

    private Long emailAddressId;

    private DateTime fromDate;

    private DateTime toDate;

    private String emailAddress;

//    private StagingAgent stagingAgent;

    @Id
    @GeneratedValue
    @Column(name = "email_address_id")
    public Long getEmailAddressId() {
        return emailAddressId;
    }

    public void setEmailAddressId(Long emailAddressId) {
        this.emailAddressId = emailAddressId;
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

    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
