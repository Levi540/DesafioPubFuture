package br.com.pubfuture.finances.utils;

import java.time.LocalDate;

public class TestConstants {
    public static final Long DEFAULT_INCOME_ID = 1L;
    public static final String DEFAULT_INCOME_DESCRIPTION = "Income 1";
    public static final LocalDate DEFAULT_INCOME_RECEIPT_DATE = LocalDate.parse("2022-01-08");
    public static final LocalDate DEFAULT_INCOME_EXPECTED_RECEIPT_DATE = LocalDate.parse("2022-01-08");
    public static final Long DEFAULT_INCOME_ID_ACCOUNT = 1L;
    public static final String DEFAULT_INCOME_TYPE_ACCOUNT = "Type 1";

    private TestConstants() {}
}
