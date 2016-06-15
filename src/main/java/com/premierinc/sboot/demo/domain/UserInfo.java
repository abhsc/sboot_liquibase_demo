package com.premierinc.sboot.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="USER_INFO")
public class UserInfo implements Serializable{

    @Id
    @Column(name="USER_LOGIN_NAME")
    private String userLoginName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="PRIMARY_EMAIL")
    private String primaryEmail;

    public UserInfo() {
    }

    public UserInfo(String userLoginName, String lastName, String firstName, String primaryEmail) {
        this.userLoginName = userLoginName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.primaryEmail = primaryEmail;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
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

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (userLoginName != null ? !userLoginName.equals(userInfo.userLoginName) : userInfo.userLoginName != null)
            return false;
        if (lastName != null ? !lastName.equals(userInfo.lastName) : userInfo.lastName != null) return false;
        if (firstName != null ? !firstName.equals(userInfo.firstName) : userInfo.firstName != null) return false;
        return primaryEmail != null ? primaryEmail.equals(userInfo.primaryEmail) : userInfo.primaryEmail == null;

    }

    @Override
    public int hashCode() {
        int result = userLoginName != null ? userLoginName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (primaryEmail != null ? primaryEmail.hashCode() : 0);
        return result;
    }
}
