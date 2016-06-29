package com.premierinc.sboot.demo.repository;

import com.premierinc.sboot.demo.domain.CommunicationPref;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationPrefRepository extends CrudRepository<CommunicationPref, String>{

}
