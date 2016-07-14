package com.premierinc.sboot.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CommunicationPrefId implements Serializable{

    private static final long serialVersionUID = 3541377415778960611L;

    @Column(name="USER_ID")
    private Integer userId;

    @Column(name="COMMUNICATION_ID")
    private String communicationId;

    public CommunicationPrefId() {
    }

    public CommunicationPrefId(Integer userId, String communicationId) {
        this.userId = userId;
        this.communicationId = communicationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(String communicationId) {
        this.communicationId = communicationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommunicationPrefId that = (CommunicationPrefId) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return communicationId != null ? communicationId.equals(that.communicationId) : that.communicationId == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (communicationId != null ? communicationId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommunicationPrefId{" +
                "userId=" + userId +
                ", communicationId='" + communicationId + '\'' +
                '}';
    }
}
