package br.com.pubfuture.finances.domain.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value_", nullable = false)
    private Double value;

    @Column(name = "payday", nullable = false)
    private Date payDay;

    @Column(name = "expected_payday", nullable = false)
    private Date expectedPayDay;

    @Column(name = "type_expense", nullable = false)
    private String typeExpense;

    @Column(name = "id_account", nullable = false)
    private Long idAccount;

    public Expense() {}

    private Expense(Long id, Double value, Date payDay, Date expectedPayDay, String typeExpense, Long idAccount) {
        this.id = id;
        this.value = value;
        this.payDay = payDay;
        this.expectedPayDay = expectedPayDay;
        this.typeExpense = typeExpense;
        this.idAccount = idAccount;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public Date getPayDay() {
        return payDay;
    }

    public Date getExpectedPayDay() {
        return expectedPayDay;
    }

    public String getTypeExpense() {
        return typeExpense;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return (
            Objects.equals(id, expense.id) &&
            Objects.equals(value, expense.value) &&
            Objects.equals(payDay, expense.payDay) &&
            Objects.equals(expectedPayDay, expense.expectedPayDay) &&
            Objects.equals(typeExpense, expense.typeExpense) &&
            Objects.equals(idAccount, expense.idAccount)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, payDay, expectedPayDay, typeExpense, idAccount);
    }

    @Override
    public String toString() {
        return (
            "Expense{" +
            "id=" +
            id +
            ", value=" +
            value +
            ", payDay=" +
            payDay +
            ", expectedPayDay=" +
            expectedPayDay +
            ", typeExpense='" +
            typeExpense +
            '\'' +
            ", idAccount=" +
            idAccount +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Double value;
        private Date payDay;
        private Date expectedPayDay;
        private String typeExpense;
        private Long idAccount;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder value(Double value) {
            this.value = value;
            return this;
        }

        public Builder payDay(Date payDay) {
            this.payDay = payDay;
            return this;
        }

        public Builder expectedPayDay(Date expectedPayDay) {
            this.expectedPayDay = expectedPayDay;
            return this;
        }

        public Builder typeExpense(String typeExpense) {
            this.typeExpense = typeExpense;
            return this;
        }

        public Builder idAccount(Long idAccount) {
            this.idAccount = idAccount;
            return this;
        }

        public Expense build() {
            return new Expense(id, value, payDay, expectedPayDay, typeExpense, idAccount);
        }
    }
}
