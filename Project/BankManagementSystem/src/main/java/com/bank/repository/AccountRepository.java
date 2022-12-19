package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query("from Account where accountHolderName like :s%")
	List<Account> getAccountByName(@Param("s") String accountName);
	@Query("from Account where accountType like :s%")
	List<Account> getAccountByType(@Param("s") String accountType);
	@Query("from Account where phoneNo =:s")
	List<Account> getAccountByPhoneNo(@Param("s") long phoneNo);
	@Query("from Account where bank_id =:s")
	List<Account> getAccountByBank(@Param("s") int id);
}
