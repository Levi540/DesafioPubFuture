package br.com.pubfuture.finances.validator;

import static br.com.pubfuture.finances.validator.ValidatorConstants.*;
import static br.com.pubfuture.finances.validator.ValidatorUtils.*;

import br.com.pubfuture.finances.api.model.CreateExpenseDTO;
import org.springframework.stereotype.Component;

@Component
public class ExpenseValidator {

    public void validate(CreateExpenseDTO createExpenseDTO) {
        var validationErrors = new ValidationErrors();

        validateDoubleRange(createExpenseDTO.getValue(), EXPENSE_VALUE, DECIMAL_MIN_VALUE, DECIMAL_MAX_VALUE, validationErrors);

        validateDate(createExpenseDTO.getPayday(), EXPENSE_PAYDAY, validationErrors);
        validateDate(createExpenseDTO.getExpectedPayday(), EXPENSE_EXPECTED_PAYDAY, validationErrors);

        validateRequired(createExpenseDTO.getTypeExpense(), EXPENSE_TYPE_EXPENSE, validationErrors);
        validateMaxLength(
            createExpenseDTO.getTypeExpense(),
            EXPENSE_TYPE_EXPENSE,
            EXPENSE_TYPE_EXPENSE_MAX_LENGTH,
            validationErrors
        );

        validateMaxValue(createExpenseDTO.getIdAccount(), EXPENSE_ID_ACCOUNT, LONG_MAX_VALUE, validationErrors);
        validateMinValue(createExpenseDTO.getIdAccount(), EXPENSE_ID_ACCOUNT, ID_MIN_VALUE, validationErrors);

        throwOnError(validationErrors);
    }
}
