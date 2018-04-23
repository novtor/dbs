package com.egencia.codeacademy.databases.mongodb.service;

import com.egencia.codeacademy.databases.mongodb.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Iterable<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public void transfer(String fromAccountId, String toAccountId, BigDecimal amount) {
        if(fromAccountId.equals(toAccountId)) {
            System.out.println("no transfer from the same account");
            return;
        }
        Account fromAccount = accountRepository.findOne(fromAccountId);
        Account toAccount = accountRepository.findOne(toAccountId);

        fromAccount.setAmount(fromAccount.getAmount().add(amount.negate()));
        toAccount.setAmount(toAccount.getAmount().add(amount));
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

    }

}
