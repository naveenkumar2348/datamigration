package com.bayport.domain;


import com.bayport.enums.MigrationStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "staging_agent")
@Entity
public class StagingAgent {

    private Long agentId;

    private String agentCode;

    private MasterLookUpTypeValue agentLookUpType;

    private DateTime appointmentDate;

    private Boolean active;

    private Boolean eligibleForCommission;

    private String outletName;

    private StagingPerson stagingPerson;

    private Set<StagingAddress> stagingAddresses = new HashSet<StagingAddress>(0);

    private Set<StagingContactNumber> stagingContactNumbers = new HashSet<StagingContactNumber>(0);

    private Set<StagingEmailAddress> stagingEmailAddresses = new HashSet<StagingEmailAddress>(0);

    private Set<StagingBankAccount> stagingBankAccounts = new HashSet<StagingBankAccount>(0);

    Integer uploadedAgentSheetLineNumber;

    MigrationStatus migrationStatus;

    Integer flexiFinId;

    @Id
    @GeneratedValue
    @Column(name = "agent_id")
    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    @Column(name = "agent_code")
    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "agent_type_id", referencedColumnName = "id", nullable = false)
    public MasterLookUpTypeValue getAgentLookUpType() {
        return agentLookUpType;
    }

    public void setAgentLookUpType(MasterLookUpTypeValue agentLookUpType) {
        this.agentLookUpType = agentLookUpType;
    }


    @Column(name = "appointment_date")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(DateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Column(name = "active")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column(name = "eligible_for_commission")
    public Boolean getEligibleForCommission() {
        return eligibleForCommission;
    }

    public void setEligibleForCommission(Boolean eligibleForCommission) {
        this.eligibleForCommission = eligibleForCommission;
    }

    @Column(name = "outlet_name")
    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public StagingPerson getStagingPerson() {
        return stagingPerson;
    }

    public void setStagingPerson(StagingPerson stagingPerson) {
        this.stagingPerson = stagingPerson;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "staging_agent_address", joinColumns = { @JoinColumn(name = "agent_id") },
            inverseJoinColumns = { @JoinColumn(name = "address_id") })
    public Set<StagingAddress> getStagingAddresses() {
        return stagingAddresses;
    }

    public void setStagingAddresses(Set<StagingAddress> stagingAddresses) {
        this.stagingAddresses = stagingAddresses;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "staging_agent_contact_number", joinColumns = { @JoinColumn(name = "agent_id") },
            inverseJoinColumns = @JoinColumn(name = "contact_number_id"))
    public Set<StagingContactNumber> getStagingContactNumbers() {
        return stagingContactNumbers;
    }

    public void setStagingContactNumbers(Set<StagingContactNumber> stagingContactNumbers) {
        this.stagingContactNumbers = stagingContactNumbers;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "staging_agent_email_address", joinColumns = { @JoinColumn(name = "agent_id") },
            inverseJoinColumns = @JoinColumn(name = "email_address_id"))
    public Set<StagingEmailAddress> getStagingEmailAddresses() {
        return stagingEmailAddresses;
    }

    public void setStagingEmailAddresses(Set<StagingEmailAddress> stagingEmailAddresses) {
        this.stagingEmailAddresses = stagingEmailAddresses;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "staging_agent_bank_account", joinColumns = { @JoinColumn(name = "agent_id") },
            inverseJoinColumns = @JoinColumn(name = "bank_account_id"))
    public Set<StagingBankAccount> getStagingBankAccounts() {
        return stagingBankAccounts;
    }

    public void setStagingBankAccounts(Set<StagingBankAccount> stagingBankAccounts) {
        this.stagingBankAccounts = stagingBankAccounts;
    }

    @Column(name = "uploaded_agent_sheet_line_number")
    public Integer getUploadedAgentSheetLineNumber() {
        return uploadedAgentSheetLineNumber;
    }

    public void setUploadedAgentSheetLineNumber(Integer uploadedAgentSheetLineNumber) {
        this.uploadedAgentSheetLineNumber = uploadedAgentSheetLineNumber;
    }

    @Column(name = "migration_status")
    public MigrationStatus getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(MigrationStatus migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    @Column(name = "flexi_fin_id")
    public Integer getFlexiFinId() {
        return flexiFinId;
    }

    public void setFlexiFinId(Integer flexiFinId) {
        this.flexiFinId = flexiFinId;
    }
}
