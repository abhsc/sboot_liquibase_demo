package com.premierinc.sboot.demo.logic;

import com.premierinc.sboot.demo.domain.UserInfo;
import com.premierinc.sboot.demo.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoLogicImpl implements UserInfoLogic{

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public void saveUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public Iterable<UserInfo> findAllUsers() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo findUser(String firstName, String lastName) {
        return userInfoRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}
