package com.fpoly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
