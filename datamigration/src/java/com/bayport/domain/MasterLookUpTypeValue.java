package com.bayport.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="master_look_up_type_value")
public class MasterLookUpTypeValue implements Serializable {

	private Long id;

	private String lookUpTypeValue;

	private Integer version;

    private Integer flexiFlexId;

	private MasterLookUpType masterLookUpType;

    public MasterLookUpTypeValue() {
    }


    @Id
    @GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="look_up_type_value", nullable=false, length=255)
	public String getLookUpTypeValue() {
		return this.lookUpTypeValue;
	}

	public void setLookUpTypeValue(String lookUpTypeValue) {
		this.lookUpTypeValue = lookUpTypeValue;
	}


	@Column(nullable=false)
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

    @Column(name="flexi_fin_id")
    public Integer getFlexiFlexId() {
        return flexiFlexId;
    }

    public void setFlexiFlexId(Integer flexiFlexId) {
        this.flexiFlexId = flexiFlexId;
    }

    //bi-directional many-to-one association to MasterLookUpType
    @ManyToOne
	@JoinColumn(name="master_look_up_type_id", nullable=false)
	public MasterLookUpType getMasterLookUpType() {
		return this.masterLookUpType;
	}

	public void setMasterLookUpType(MasterLookUpType masterLookUpType) {
		this.masterLookUpType = masterLookUpType;
	}
	
}