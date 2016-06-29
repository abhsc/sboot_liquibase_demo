package com.premierinc.sboot.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable{

    @Id
    @SequenceGenerator(name="USER_ID_SEQ", sequenceName="USER_ID_SEQ", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="USER_ID_SEQ")
    @Column(name="USER_ID")
    private Integer userLoginName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="FIRST_NAME")
    private String firstName;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CommunicationPref> communicationPrefs;

    public UserInfo() {
    }

    public UserInfo(Integer userLoginName, String lastName, String firstName) {
        this.userLoginName = userLoginName;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(Integer userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<CommunicationPref> getCommunicationPrefs() {
        return communicationPrefs;
    }

    public void setCommunicationPrefs(List<CommunicationPref> communicationPrefs) {
        this.communicationPrefs = communicationPrefs;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userLoginName='" + userLoginName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", communicationPrefs=" + communicationPrefs +
                '}';
    }
}
