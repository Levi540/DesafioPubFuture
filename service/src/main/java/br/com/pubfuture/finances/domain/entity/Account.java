package br.com.pubfuture.finances.domain.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "type_account", nullable = false)
    private String typeAccount;

    @Column(name = "financial_institution", nullable = false)
    private String financialInstitution;

    public Account() {}

    private Account(Long id, Double balance, String typeAccount, String financialInstitution) {
        this.id = id;
        this.balance = balance;
        this.typeAccount = typeAccount;
        this.financialInstitution = financialInstitution;
    }

    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return (
            Objects.equals(id, account.id) &&
            Objects.equals(balance, account.balance) &&
            Objects.equals(typeAccount, account.typeAccount) &&
            Objects.equals(financialInstitution, account.financialInstitution)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, typeAccount, financialInstitution);
    }

    @Override
    public String toString() {
        return (
            "Account{" +
            "id=" +
            id +
            ", balance=" +
            balance +
            ", typeAccount='" +
            typeAccount +
            '\'' +
            ", financialInstitution='" +
            financialInstitution +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Double balance;
        private String typeAccount;
        private String financialInstitution;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder balance(Double balance) {
            this.balance = balance;
            return this;
        }

        public Builder typeAccount(String typeAccount) {
            this.typeAccount = typeAccount;
            return this;
        }

        public Builder financialInstitution(String financialInstitution) {
            this.financialInstitution = financialInstitution;
            return this;
        }

        public Account build() {
            return new Account(id, balance, typeAccount, financialInstitution);
        }
    }
}
