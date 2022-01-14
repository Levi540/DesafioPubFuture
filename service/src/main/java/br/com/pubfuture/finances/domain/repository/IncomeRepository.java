package br.com.pubfuture.finances.domain.repository;

import br.com.pubfuture.finances.domain.entity.Income;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    //    @Query(
    //        "SELECT i FROM income i WHERE " +
    //        "(:description IS NULL OR i.description = :description) AND " +
    //        "(:startAt IS NULL OR i.receipt_date >= :startAt) AND " +
    //        "(:endAt IS NULL OR i.expected_receipt_date <= :endAt) AND " +
    //        "(:idAccount IS NULL OR i.idAccount = :idAccount) AND " +
    //        "(:typeIncome IS NULL OR i.typeIncome = :typeIncome)"
    //    )
    //    List<Income> findAllWithFilters(
    //        @Param("description") String description,
    //        @Param("startAt") LocalDate startAt,
    //        @Param("endAt") LocalDate endAt,
    //        @Param("idAccount") Long idAccount,
    //        @Param("typeIncome") String typeIncome
    //    );

    //    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //    @Query(
    //        "UPDATE income i " +
    //        "SET i.description = :description, " +
    //        "i.receipt_date = :receiptDate, " +
    //        "i.expected_receipt_date = :expectedReceiptDate, " +
    //        "i.idAccount = :id_account, " +
    //        "i.type_income = :typeIncome " +
    //        "WHERE i.id = :incomeId"
    //    )
    //    void updateIncome(
    //        @Param("incomeId") Long incomeId,
    //        @Param("description") String description,
    //        @Param("receiptDate") LocalDate receiptDate,
    //        @Param("expectedReceiptDate") LocalDate expectedReceiptDate,
    //        @Param("idAccount") Long idAccount,
    //        @Param("typeIncome") String typeIncome
    //    );
}
