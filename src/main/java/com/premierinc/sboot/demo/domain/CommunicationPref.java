package com.premierinc.sboot.demo.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="COMMUNICATION_PREF")
public class CommunicationPref implements Serializable{

    private static final long serialVersionUID = 3541377415778960612L;

    @EmbeddedId
    private CommunicationPrefId communicationPrefId;

    @MapsId(value = "userId")
    @ManyToOne
    @JoinColumn(name="USER_ID", referencedColumnName = "USER_ID")
    private UserInfo userInfo;

    public CommunicationPref() {
    }

    public CommunicationPref(String communicationId, UserInfo userInfo) {
        this.communicationPrefId = new CommunicationPrefId(userInfo.getUserId(),communicationId);
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public CommunicationPrefId getCommunicationPrefId() {
        return communicationPrefId;
    }

    public void setCommunicationPrefId(CommunicationPrefId communicationPrefId) {
        this.communicationPrefId = communicationPrefId;
    }

    @Override
    public String toString() {
        return "CommunicationPref{" +
                "communicationPrefId=" + communicationPrefId +
                ", userInfo=" + userInfo +
                '}';
    }
}
