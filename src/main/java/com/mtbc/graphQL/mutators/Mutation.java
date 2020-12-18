package com.mtbc.graphQL.mutators;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.mtbc.graphQL.model.Account;
import com.mtbc.graphQL.repository.AccountRepository;

public class Mutation implements GraphQLMutationResolver {

    private AccountRepository accountRepository;

    public Mutation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account newAccount(String account_number, Integer balance, String firstName, String lastName, Integer age,
                              String gender, String address, String employer, String email, String city, String state) {
        Account newAccount = new Account();
        newAccount.setAccount_number(Integer.parseInt(account_number));
        newAccount.setBalance(balance);
        newAccount.setFirstname(firstName);
        newAccount.setLastname(lastName);
        newAccount.setAge(age);
        newAccount.setGender(gender);
        newAccount.setAddress(address);
        newAccount.setEmployer(employer);
        newAccount.setEmail(email);
        newAccount.setCity(city);
        newAccount.setState(state);

        return accountRepository.save(newAccount);
    }
}
