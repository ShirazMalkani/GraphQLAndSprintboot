package com.mtbc.graphQL.repository;

import com.mtbc.graphQL.model.Account;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccountRepository extends ElasticsearchRepository<Account, String> {

    Account findByFirstname(String firstname);

    Account findByLastname(String lastname);

    @Query("{\n" +
            "  \"bool\": {\n" +
            "    \"must\": [\n" +
            "      {\n" +
            "        \"match\": {\n" +
            "          \"account_number\": \"?0\"\n" +
            "        }\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}")
    Account findByAccountNumber(String accountNumber);

}
