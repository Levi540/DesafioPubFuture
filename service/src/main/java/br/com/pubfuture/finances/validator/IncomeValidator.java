package br.com.pubfuture.finances.validator;

import static br.com.pubfuture.finances.validator.ValidatorConstants.*;
import static br.com.pubfuture.finances.validator.ValidatorUtils.*;

import br.com.pubfuture.finances.api.model.CreateIncomeDTO;
import org.springframework.stereotype.Component;

@Component
public class IncomeValidator {

    public void validate(CreateIncomeDTO createIncomeDTO) {
        var validationErrors = new ValidationErrors();

        validateRequired(createIncomeDTO.getDescription(), INCOME_DESCRIPTION, validationErrors);
        validateMaxLength(
            createIncomeDTO.getDescription(),
            INCOME_DESCRIPTION,
            INCOME_DESCRIPTION_MAX_LENGTH,
            validationErrors
        );

        validateDate(createIncomeDTO.getReceiptDate(), INCOME_RECEIPT_DATE, validationErrors);
        validateDate(createIncomeDTO.getReceiptDate(), INCOME_EXPECTED_RECEIPT_DATE, validationErrors);

        validateMaxValue(createIncomeDTO.getIdAccount(), INCOME_ID_ACCOUNT, LONG_MAX_VALUE, validationErrors);
        validateMinValue(createIncomeDTO.getIdAccount(), INCOME_ID_ACCOUNT, ID_MIN_VALUE, validationErrors);

        validateRequired(createIncomeDTO.getTypeIncome(), INCOME_TYPE_INCOME, validationErrors);
        validateMaxLength(createIncomeDTO.getTypeIncome(), INCOME_TYPE_INCOME, INCOME_TYPE_INCOME_MAX_LENGTH, validationErrors);

        throwOnError(validationErrors);
    }
}
