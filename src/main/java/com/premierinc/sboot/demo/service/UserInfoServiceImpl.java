package com.premierinc.sboot.demo.service;

import com.premierinc.sboot.demo.domain.UserInfo;
import com.premierinc.sboot.demo.dto.UserInfoDTO;
import com.premierinc.sboot.demo.logic.UserInfoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoLogic userInfoLogic;

    @Override
    public void update(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = new UserInfo(userInfoDTO.getId(),userInfoDTO.getLastName()
                ,userInfoDTO.getFirstName(),userInfoDTO.getEmailAddress());
        userInfoLogic.saveUser(userInfo);
    }

    @Override
    public List<UserInfoDTO> getAllUsers() {
        List<UserInfoDTO> userInfoDTOs = new ArrayList();
        Iterable<UserInfo> userInfos = userInfoLogic.findAllUsers();
        for(UserInfo userInfo : userInfos){
            userInfoDTOs.add(new UserInfoDTO(userInfo.getUserLoginName(),userInfo.getLastName()
                    ,userInfo.getFirstName(),userInfo.getPrimaryEmail()));
        }
        return userInfoDTOs;
    }
}
