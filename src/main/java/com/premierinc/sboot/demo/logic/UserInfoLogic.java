package com.premierinc.sboot.demo.logic;

import com.premierinc.sboot.demo.domain.UserInfo;

public interface UserInfoLogic {
    void saveUser(UserInfo userInfo);
    Iterable<UserInfo> findAllUsers();
    UserInfo findUser(String firstName, String lastName);
}
