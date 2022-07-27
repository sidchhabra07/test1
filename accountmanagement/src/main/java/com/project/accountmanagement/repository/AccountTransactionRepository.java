package com.project.accountmanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.accountmanagement.entity.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Integer> {
	List<AccountTransaction> getByAccountNumber(long accountNumber);

	List<AccountTransaction> getByTransactionDate(LocalDate transactionDate);
	
	@Query(value = "SELECT t FROM AccountTransaction t where t.accountNumber=?1 order by t.transactionDate DESC")
	List<AccountTransaction> findTop5ByOrderByTransactionDateDesc(long accountNumber);

	List<AccountTransaction> findByAccountNumber(long accountId);

}
