package com.kiru.rest.assignment.repository;

import com.kiru.rest.assignment.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BalanceRepository extends JpaRepository<Balance,String> {
	
}
