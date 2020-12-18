package com.mtbc.graphQL.service.datafetcher;

import com.google.common.collect.Lists;
import com.mtbc.graphQL.model.Account;
import com.mtbc.graphQL.repository.AccountRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllAccountsDataFetcher implements DataFetcher<List<Account>> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return Lists.newArrayList(accountRepository.findAll());
    }
}
