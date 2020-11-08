package com.learning.atm.repository;
import org.springframework.data.repository.CrudRepository;

import com.learning.atm.model.Account;
public interface ATMRepository extends CrudRepository<Account, Integer>
{
}
