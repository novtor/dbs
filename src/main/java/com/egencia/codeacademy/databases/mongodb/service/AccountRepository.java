package com.egencia.codeacademy.databases.mongodb.service;

import com.egencia.codeacademy.databases.mongodb.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

}
