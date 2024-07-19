package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accRepo;

    public Account getAccountByUsername(String username) {
        return accRepo.findByUsername(username);
    }

    public Account saveAccount(Account account) {
        return accRepo.save(account);
    }

    public Account verify(String username, String password) {
        Account acc = accRepo.findByUsername(username);
        if(acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        return null;
    }
}
