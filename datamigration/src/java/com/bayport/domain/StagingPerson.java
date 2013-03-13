package com.bayport.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Naveen Kumar
 * Date: 2013/03/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "staging_person")
@Entity
public class StagingPerson {

    private Long personId;

    private String lastName;

    private String firstName;

    private String middleName;

    private MasterLookUpTypeValue titleLookUpValue;

    private String suffix;

    private DateTime birthDate;

    private String nickname;

    private String motherMaidenName;

    private MasterLookUpTypeValue maritalStatusLookUpValue;

    private String idNumber;

    private String passportNumber;

    private DateTime passportExpireDate;

    private Integer totalYearsWorkExperience;

    private Integer dependants;

    private String comments;

    private MasterLookUpTypeValue genderLookUpValue;

    private MasterLookUpTypeValue idTypeLookUpValue;

    private DateTime idIssueDate;

    private MasterLookUpTypeValue idIssueCityLookUpValue;

    private Integer children;

    private MasterLookUpTypeValue educationLevelLookUpValue;

    private MasterLookUpTypeValue occupationLookUpValue;

    private MasterLookUpTypeValue occupationStatusLookUpValue;

    private MasterLookUpTypeValue occupationPositionLookUpValue;

    private MasterLookUpTypeValue birthCityLookUpValue;

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @javax.persistence.Column(name = "last_name")
    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @javax.persistence.Column(name = "first_name")
    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @javax.persistence.Column(name = "middle_name")
    @Basic
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @ManyToOne
    @JoinColumn(name = "title_id")
    public MasterLookUpTypeValue getTitleLookUpValue() {
        return titleLookUpValue;
    }

    public void setTitleLookUpValue(MasterLookUpTypeValue titleLookUpValue) {
        this.titleLookUpValue = titleLookUpValue;
    }

    @javax.persistence.Column(name = "suffix")
    @Basic
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @javax.persistence.Column(name = "nickname")
    @Basic
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @javax.persistence.Column(name = "birth_date")
    @Basic
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    @javax.persistence.Column(name = "mother_maiden_name")
    @Basic
    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    @ManyToOne
    @JoinColumn(name = "marital_status_id")
    public MasterLookUpTypeValue getMaritalStatusLookUpValue() {
        return maritalStatusLookUpValue;
    }

    public void setMaritalStatusLookUpValue(MasterLookUpTypeValue maritalStatusLookUpValue) {
        this.maritalStatusLookUpValue = maritalStatusLookUpValue;
    }

    @javax.persistence.Column(name = "id_number")
    @Basic
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @javax.persistence.Column(name = "passport_number")
    @Basic
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @javax.persistence.Column(name = "passport_expire_date")
    @Basic
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getPassportExpireDate() {
        return passportExpireDate;
    }

    public void setPassportExpireDate(DateTime passportExpireDate) {
        this.passportExpireDate = passportExpireDate;
    }

    @javax.persistence.Column(name = "total_years_work_experience")
    @Basic
    public Integer getTotalYearsWorkExperience() {
        return totalYearsWorkExperience;
    }

    public void setTotalYearsWorkExperience(Integer totalYearsWorkExperience) {
        this.totalYearsWorkExperience = totalYearsWorkExperience;
    }

    @javax.persistence.Column(name = "dependants")
    @Basic
    public Integer getDependants() {
        return dependants;
    }

    public void setDependants(Integer dependants) {
        this.dependants = dependants;
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
    @JoinColumn(name = "gender_id")
    public MasterLookUpTypeValue getGenderLookUpValue() {
        return genderLookUpValue;
    }

    public void setGenderLookUpValue(MasterLookUpTypeValue genderLookUpValue) {
        this.genderLookUpValue = genderLookUpValue;
    }

    @ManyToOne
    @JoinColumn(name = "id_type_id")
    public MasterLookUpTypeValue getIdTypeLookUpValue() {
        return idTypeLookUpValue;
    }

    public void setIdTypeLookUpValue(MasterLookUpTypeValue idTypeLookUpValue) {
        this.idTypeLookUpValue = idTypeLookUpValue;
    }

    @Column(name = "id_issue_date")
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getIdIssueDate() {
        return idIssueDate;
    }

    public void setIdIssueDate(DateTime idIssueDate) {
        this.idIssueDate = idIssueDate;
    }

    @ManyToOne
    @JoinColumn(name = "id_issue_city_id")
    public MasterLookUpTypeValue getIdIssueCityLookUpValue() {
        return idIssueCityLookUpValue;
    }

    public void setIdIssueCityLookUpValue(MasterLookUpTypeValue idIssueCityLookUpValue) {
        this.idIssueCityLookUpValue = idIssueCityLookUpValue;
    }

    @Column(name = "children")
    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    @ManyToOne
    @JoinColumn(name = "education_level_id")
    public MasterLookUpTypeValue getEducationLevelLookUpValue() {
        return educationLevelLookUpValue;
    }

    public void setEducationLevelLookUpValue(MasterLookUpTypeValue educationLevelLookUpValue) {
        this.educationLevelLookUpValue = educationLevelLookUpValue;
    }

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    public MasterLookUpTypeValue getOccupationLookUpValue() {
        return occupationLookUpValue;
    }

    public void setOccupationLookUpValue(MasterLookUpTypeValue occupationLookUpValue) {
        this.occupationLookUpValue = occupationLookUpValue;
    }

    @ManyToOne
    @JoinColumn(name = "occupation_status_id")
    public MasterLookUpTypeValue getOccupationStatusLookUpValue() {
        return occupationStatusLookUpValue;
    }

    public void setOccupationStatusLookUpValue(MasterLookUpTypeValue occupationStatusLookUpValue) {
        this.occupationStatusLookUpValue = occupationStatusLookUpValue;
    }

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    public MasterLookUpTypeValue getOccupationPositionLookUpValue() {
        return occupationPositionLookUpValue;
    }

    public void setOccupationPositionLookUpValue(MasterLookUpTypeValue occupationPositionLookUpValue) {
        this.occupationPositionLookUpValue = occupationPositionLookUpValue;
    }

    @ManyToOne
    @JoinColumn(name = "birth_city_id")
    public MasterLookUpTypeValue getBirthCityLookUpValue() {
        return birthCityLookUpValue;
    }

    public void setBirthCityLookUpValue(MasterLookUpTypeValue birthCityLookUpValue) {
        this.birthCityLookUpValue = birthCityLookUpValue;
    }

}
