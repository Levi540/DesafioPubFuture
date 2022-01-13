package br.com.pubfuture.finances.validator;

public class ValidatorConstants {
    public static final String INCOME_DESCRIPTION = "description";
    public static final int INCOME_DESCRIPTION_MAX_LENGTH = 45;
    public static final String INCOME_RECEIPT_DATE = "receipt_date";
    public static final String INCOME_EXPECTED_RECEIPT_DATE = "expected_receipt_date";
    public static final String INCOME_ID_ACCOUNT = "id_account";
    public static final String INCOME_TYPE_INCOME = "type_income";
    public static final int INCOME_TYPE_INCOME_MAX_LENGTH = 30;
    public static final String INCOME_DATE_FORMAT = "yyyy-MM-dd";
    public static final Long LONG_MAX_VALUE = 9223372036854775807L;
    public static final byte ID_MIN_VALUE = 0;

    public static final String EXPENSE_VALUE = "value_";
    public static final String EXPENSE_PAYDAY = "payday";
    public static final String EXPENSE_EXPECTED_PAYDAY = "expected_payday";
    public static final String EXPENSE_TYPE_EXPENSE = "type_expense";
    public static final int EXPENSE_TYPE_EXPENSE_MAX_LENGTH = 30;
    public static final String EXPENSE_ID_ACCOUNT = "id_account";
    public static final Double DECIMAL_MAX_VALUE = 99999999.99;
    public static final Double DECIMAL_MIN_VALUE = 0.00;

    public static final String ACCOUNT_BALANCE = "balance";
    public static final String ACCOUNT_TYPE_ACCOUNT = "type_account";
    public static final int ACCOUNT_TYPE_ACCOUNT_MAX_LENGTH = 45;
    public static final String ACCOUNT_FINANCIAL_INSTITUTION = "financial_institution";
    public static final int ACCOUNT_FINANCIAL_INSTITUTION_MAX_LENGTH = 65;

    public static final String MISSING = ".missing";
    public static final String EXCEEDS_MAX_LENGTH = ".exceedsMaxLength";
    public static final String INVALID_DATE = ".invalidDate";
    public static final String EXCEEDS_MAX_VALUE = ".belowMinValue";
    public static final String BELOW_MIN_VALUE = ".belowMinValue";
    public static final String EXCEEDS_DOUBLE_RANGE = ".exceedsDoubleRange";

    private ValidatorConstants() {}
}
