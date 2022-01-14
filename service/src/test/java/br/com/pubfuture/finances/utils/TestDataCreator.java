package br.com.pubfuture.finances.utils;

import static br.com.pubfuture.finances.utils.TestConstants.*;

import br.com.pubfuture.finances.domain.entity.Income;
import java.time.LocalDate;

public class TestDataCreator {

    private TestDataCreator() {}

    public static Income.Builder newIncomeBuilder() {
        return Income
            .newBuilder()
            .id(DEFAULT_INCOME_ID)
            .description(DEFAULT_INCOME_DESCRIPTION)
            .receiptDate(DEFAULT_INCOME_RECEIPT_DATE)
            .expectedReceiptDate(DEFAULT_INCOME_EXPECTED_RECEIPT_DATE)
            .idAccount(DEFAULT_INCOME_ID_ACCOUNT)
            .typeIncome(DEFAULT_INCOME_TYPE_ACCOUNT);
    }
}
