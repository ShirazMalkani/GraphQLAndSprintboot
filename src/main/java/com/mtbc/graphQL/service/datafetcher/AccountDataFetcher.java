package com.mtbc.graphQL.service.datafetcher;

import com.mtbc.graphQL.model.Account;
import com.mtbc.graphQL.repository.AccountRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDataFetcher implements DataFetcher<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account get(DataFetchingEnvironment dataFetchingEnvironment) {
        String account_number = dataFetchingEnvironment.getArgument("account_number");
        return accountRepository.findByAccountNumber(account_number);
    }
}
