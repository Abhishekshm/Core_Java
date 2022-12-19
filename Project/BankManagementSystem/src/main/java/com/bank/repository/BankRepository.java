package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

	@Query("from Bank where bankName like :s%")
	List<Bank> getBankByName(@Param("s") String bankName);
	@Query("from Bank where branchName like :s%")
	List<Bank> getBankByBranchName(@Param("s") String branchName);
	@Query("from Bank where branchLocation like :s%")
	List<Bank> getBankbyBranchLocation(@Param("s") String branchLocation);
}
