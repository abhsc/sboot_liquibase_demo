package com.premierinc.sboot.demo.service;

import com.premierinc.sboot.demo.domain.UserInfo;
import com.premierinc.sboot.demo.dto.UserInfoDTO;

import java.util.List;

public interface UserInfoService {
    void update(UserInfoDTO userInfoDTO);
    List<UserInfoDTO> getAllUsers();
}
