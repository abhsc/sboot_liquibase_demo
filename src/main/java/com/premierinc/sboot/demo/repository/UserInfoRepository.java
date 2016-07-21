package com.premierinc.sboot.demo.repository;

import com.premierinc.sboot.demo.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, String>{
    UserInfo findByFirstNameAndLastName(String firstName, String lastName);
}
