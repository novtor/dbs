package com.egencia.codeacademy.databases.postgresql.jpa.service;

import com.egencia.codeacademy.databases.postgresql.jpa.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void transfer(long fromAccountId, long toAccountId, BigDecimal amount) {
        if(fromAccountId == toAccountId) {
            System.out.println("no transfer from the same account");
            return;
        }
        Account fromAccount = accountRepository.findOne(fromAccountId);
        Account toAccount = accountRepository.findOne(toAccountId);
        BigDecimal sumBefore = fromAccount.getAmount().add(toAccount.getAmount());

        fromAccount.setAmount(fromAccount.getAmount().add(amount.negate()));
        toAccount.setAmount(toAccount.getAmount().add(amount));
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        BigDecimal sumAfter = fromAccount.getAmount().add(toAccount.getAmount());

        if(!sumAfter.equals(sumBefore)) {
            System.out.println("not equals");
        }
    }
}
