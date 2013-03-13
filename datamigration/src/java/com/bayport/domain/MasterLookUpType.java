package com.bayport.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="master_look_up_type")
public class MasterLookUpType implements Serializable {

	private Long id;

	private String lookUpType;

	private Integer version;

    private String description;

	private Collection<MasterLookUpTypeValue> masterLookUpTypeValues  = new HashSet<MasterLookUpTypeValue>();

    public MasterLookUpType() {
    }


    @Id
    @GeneratedValue
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="look_up_type", nullable=false, length=255)
	public String getLookUpType() {
		return this.lookUpType;
	}

	public void setLookUpType(String lookUpType) {
		this.lookUpType = lookUpType;
	}


	@Column(nullable=false)
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

    @Column(name="description", nullable=false, length=255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //bi-directional many-to-one association to MasterLookUpTypeValue
	@OneToMany(mappedBy="masterLookUpType")
	public Collection<MasterLookUpTypeValue> getMasterLookUpTypeValues() {
		return this.masterLookUpTypeValues;
	}

	public void setMasterLookUpTypeValues(Collection<MasterLookUpTypeValue> masterLookUpTypeValues) {
		this.masterLookUpTypeValues = masterLookUpTypeValues;
	}
	
}