package com.egencia.codeacademy.databases.postgresql.jpa.service;

import com.egencia.codeacademy.databases.postgresql.jpa.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
