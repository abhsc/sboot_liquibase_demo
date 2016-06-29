package com.premierinc.sboot.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMUNICATION_PREF")
public class CommunicationPref {

    @Id
    @Column(name="COMMUNICATION_ID")
    private String communicationId;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserInfo userInfo;

    public CommunicationPref() {
    }

    public CommunicationPref(String communicationId, UserInfo userInfo) {
        this.communicationId = communicationId;
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(String communicationId) {
        this.communicationId = communicationId;
    }

    @Override
    public String toString() {
        return "CommunicationPref{" +
                "communicationId='" + communicationId + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
