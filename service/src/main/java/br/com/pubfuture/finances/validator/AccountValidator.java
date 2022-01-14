package br.com.pubfuture.finances.validator;

import static br.com.pubfuture.finances.validator.ValidatorConstants.*;
import static br.com.pubfuture.finances.validator.ValidatorUtils.*;

import br.com.pubfuture.finances.api.model.CreateAccountDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountValidator {

    public void validate(CreateAccountDTO createAccountDTO) {
        var validateErrors = new ValidationErrors();

        validateDoubleRange(
            createAccountDTO.getBalance(),
            ACCOUNT_BALANCE,
            DECIMAL_MIN_VALUE,
            DECIMAL_MAX_VALUE,
            validateErrors
        );

        validateRequired(createAccountDTO.getTypeAccount(), ACCOUNT_TYPE_ACCOUNT, validateErrors);
        validateMaxLength(
            createAccountDTO.getTypeAccount(),
            ACCOUNT_TYPE_ACCOUNT,
            ACCOUNT_TYPE_ACCOUNT_MAX_LENGTH,
            validateErrors
        );

        validateRequired(createAccountDTO.getFinancialInstitution(), ACCOUNT_FINANCIAL_INSTITUTION, validateErrors);
        validateMaxLength(
            createAccountDTO.getTypeAccount(),
            ACCOUNT_FINANCIAL_INSTITUTION,
            ACCOUNT_FINANCIAL_INSTITUTION_MAX_LENGTH,
            validateErrors
        );

        throwOnError(validateErrors);
    }
}
