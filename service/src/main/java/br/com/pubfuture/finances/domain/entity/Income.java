package br.com.pubfuture.finances.domain.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "receipt_date", nullable = false)
    private LocalDate receiptDate;

    @Column(name = "expected_receipt_date", nullable = false)
    private LocalDate expectedReceiptDate;

    @Column(name = "id_account", nullable = false)
    private Long idAccount;

    @Column(name = "type_income", nullable = false)
    private String typeIncome;

    public Income() {}

    private Income(
        Long id,
        String description,
        LocalDate receiptDate,
        LocalDate expectedReceiptDate,
        Long idAccount,
        String typeIncome
    ) {
        this.id = id;
        this.description = description;
        this.receiptDate = receiptDate;
        this.expectedReceiptDate = expectedReceiptDate;
        this.idAccount = idAccount;
        this.typeIncome = typeIncome;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public LocalDate getExpectedReceiptDate() {
        return expectedReceiptDate;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public String getTypeIncome() {
        return typeIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return (
            Objects.equals(id, income.id) &&
            Objects.equals(description, income.description) &&
            Objects.equals(receiptDate, income.receiptDate) &&
            Objects.equals(expectedReceiptDate, income.expectedReceiptDate) &&
            Objects.equals(idAccount, income.idAccount) &&
            Objects.equals(typeIncome, income.typeIncome)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, receiptDate, expectedReceiptDate, idAccount, typeIncome);
    }

    @Override
    public String toString() {
        return (
            "Income{" +
            "id=" +
            id +
            ", description='" +
            description +
            '\'' +
            ", receiptDate=" +
            receiptDate +
            ", expectedReceiptDate=" +
            expectedReceiptDate +
            ", idAccount=" +
            idAccount +
            ", typeIncome='" +
            typeIncome +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String description;
        private LocalDate receiptDate;
        private LocalDate expectedReceiptDate;
        private Long idAccount;
        private String typeIncome;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder receiptDate(LocalDate receiptDate) {
            this.receiptDate = receiptDate;
            return this;
        }

        public Builder expectedReceiptDate(LocalDate expectedReceiptDate) {
            this.expectedReceiptDate = expectedReceiptDate;
            return this;
        }

        public Builder idAccount(Long idAccount) {
            this.idAccount = idAccount;
            return this;
        }

        public Builder typeIncome(String typeIncome) {
            this.typeIncome = typeIncome;
            return this;
        }

        public Income build() {
            return new Income(id, description, receiptDate, expectedReceiptDate, idAccount, typeIncome);
        }
    }
}
