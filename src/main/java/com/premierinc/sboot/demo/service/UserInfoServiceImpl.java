package com.premierinc.sboot.demo.service;

import com.premierinc.sboot.demo.domain.UserInfo;
import com.premierinc.sboot.demo.dto.UserInfoDTO;
import com.premierinc.sboot.demo.logic.UserInfoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoLogic userInfoLogic;

    @Override
    public void update(UserInfoDTO userInfoDTO) {

        UserInfo userInfo = userInfoLogic.findUser(userInfoDTO.getFirstName()
                ,userInfoDTO.getLastName());
        if(null == userInfo){
            userInfo = new UserInfo(userInfoDTO.getId(),userInfoDTO.getLastName()
                    ,userInfoDTO.getFirstName(),userInfoDTO.getEmailAddress());
        }else{
            userInfo.setPrimaryEmail(userInfoDTO.getEmailAddress());
        }
        userInfoLogic.saveUser(userInfo);
    }

    @Override
    public List<UserInfoDTO> getAllUsers() {
        List<UserInfoDTO> userInfoDTOs = new ArrayList();
        Iterable<UserInfo> userInfos = userInfoLogic.findAllUsers();
        for(UserInfo userInfo : userInfos){
            userInfoDTOs.add(new UserInfoDTO(userInfo.getUserId(),userInfo.getFirstName()
                    ,userInfo.getLastName(), userInfo.getPrimaryEmail()));
        }
        return userInfoDTOs;
    }
}
