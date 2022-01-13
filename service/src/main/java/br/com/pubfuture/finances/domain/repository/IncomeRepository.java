package br.com.pubfuture.finances.domain.repository;

import br.com.pubfuture.finances.domain.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {}
