package com.egencia.codeacademy.databases.postgresql;

import com.egencia.codeacademy.databases.postgresql.jpa.model.Account;
import com.egencia.codeacademy.databases.postgresql.jpa.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresqlApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(PostgresqlApplicationTests.class);
    @Autowired
    private AccountService accountService;

    @Test
    public void createAccounts() {
        for (int i = 0; i < 10; i++) {
            Account account = new Account();
            account.setAmount(BigDecimal.TEN);
            Account result = accountService.save(account);
            System.out.println("is the same entity: " + (result == account));
            System.out.println("generated id: " + result.getId());
        }
    }

    @Test
    public void simulateTransferOne() {
        Random rnd = new Random(System.nanoTime());
        List<Long> allIds = new ArrayList<>();
        accountService.findAllAccounts().forEach(a -> allIds.add(a.getId()));
        int accountIndexToWithdraw = Math.abs(rnd.nextInt() % allIds.size());
        int accountIndexToAdd = Math.abs(rnd.nextInt() % allIds.size());
        long fromAccount = allIds.get(accountIndexToWithdraw);
        long toAccount = allIds.get(accountIndexToAdd);
        accountService.transfer(fromAccount, toAccount, BigDecimal.ONE);
    }


    @Test
    public void simulateRealTransfer() {
        Random rnd = new Random(System.nanoTime());
        List<Long> allIds = new ArrayList<>();
        accountService.findAllAccounts().forEach(a -> allIds.add(a.getId()));
        logger.info("Starting transfers");
        for (int i = 0; i < 100; i++) {
            int accountIndexToWithdraw = Math.abs(rnd.nextInt() % allIds.size());
            int accountIndexToAdd = Math.abs(rnd.nextInt() % allIds.size());
            long fromAccountId = allIds.get(accountIndexToWithdraw);
            long toAccountId = allIds.get(accountIndexToAdd);
            logger.info("Transferring from {} to {}", fromAccountId, toAccountId);
            accountService.transfer(fromAccountId, toAccountId, BigDecimal.ONE);
        }
    }
}
