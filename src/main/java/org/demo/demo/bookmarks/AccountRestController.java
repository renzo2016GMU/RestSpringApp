package org.demo.demo.bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AccountRestController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/accounts")
    Collection<Account> accounts() {
        return this.accountRepository.findAll();
    }
}
