package com.bayport.domain;

import com.qualica.flexifin.domain.Bank;
import com.qualica.flexifin.domain.BankAccountStatus;
import com.qualica.flexifin.domain.BankAccountType;
import com.qualica.flexifin.domain.BankBranch;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */

@Table(name = "staging_bank_account")
@Entity
public class StagingBankAccount {

    private Long bankAccountId;

    private String accountHolder;

    private String accountNumber;

    private MasterLookUpTypeValue bankAccountLookUpType;

    private String bankBranch;

//    private StagingAgent stagingAgent;

    @Id
    @GeneratedValue
    @Column(name = "bank_account_id")
    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Column(name = "account_holder")
    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @ManyToOne
    @JoinColumn(name = "bank_account_type_id", referencedColumnName = "id")
    @NotAudited
    public MasterLookUpTypeValue getBankAccountLookUpType() {
        return bankAccountLookUpType;
    }

    public void setBankAccountLookUpType(MasterLookUpTypeValue bankAccountLookUpType) {
        this.bankAccountLookUpType = bankAccountLookUpType;
    }

    @Column(name = "bank_branch")
    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
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
