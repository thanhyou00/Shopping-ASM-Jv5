package com.fpoly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	public Account findByEmailEquals(String email);

	@Query(value = "SELECT acc FROM Account acc")
	public List<Account> getDemo();
	
	

}
