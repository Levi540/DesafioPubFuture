package br.com.pubfuture.finances.domain.repository;

import br.com.pubfuture.finances.domain.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {}
