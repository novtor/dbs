package com.egencia.codeacademy.databases.postgresql.jpa.service;

import com.egencia.codeacademy.databases.postgresql.jpa.model.Account;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Account findOne(Long id);
}
