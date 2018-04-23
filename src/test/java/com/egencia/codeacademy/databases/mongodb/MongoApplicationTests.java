package com.egencia.codeacademy.databases.mongodb;

import com.egencia.codeacademy.databases.mongodb.model.Account;
import com.egencia.codeacademy.databases.mongodb.service.AccountService;
import com.mongodb.ReadPreference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MongoApplicationTests.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void init() {
        mongoTemplate.setReadPreference(ReadPreference.primary());
    }

    @Test
    public void createAccounts() {
        for (int i = 0; i < 2; i++) {
            Account account = new Account();
            account.setAmount(BigDecimal.TEN);
            Account result = accountService.save(account);
            System.out.println("is the same entity: " + (result == account));
            System.out.println("generated id: " + result.getId());
        }
    }

    @Test
    public void transferOne() {
        List<Account> allAccounts = new ArrayList<>();
        accountService.findAllAccounts().forEach(allAccounts::add);
        String fromAccount = allAccounts.get(1).getId();
        String toAccount = allAccounts.get(0).getId();
        accountService.transfer(fromAccount, toAccount, BigDecimal.ONE);
    }

    @Test
    public void transferOneManyTimes() {
        List<Account> allAccounts = new ArrayList<>();
        accountService.findAllAccounts().forEach(allAccounts::add);
        String fromAccount = allAccounts.get(0).getId();
        String toAccount = allAccounts.get(1).getId();
        IntStream.range(0, 300).forEach(
                i -> {
                    BigDecimal withdrawCoef = i % 2 == 0 ? BigDecimal.ONE : BigDecimal.ONE.negate();
                    accountService.transfer(fromAccount, toAccount, BigDecimal.ONE.multiply(withdrawCoef));
                    if(i%100 == 0) {
                        System.out.println("Transferred " + i + " times");
                    }
                });
    }
}
