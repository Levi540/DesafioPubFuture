package br.com.pubfuture.finances.validator;

import static br.com.pubfuture.finances.validator.ValidatorConstants.*;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

import br.com.pubfuture.finances.exception.InvalidRequestException;
import java.time.LocalDate;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.DoubleValidator;

public final class ValidatorUtils {

    private ValidatorUtils() {}

    public static void throwOnError(ValidationErrors validationErrors) {
        if (validationErrors.hasErrors()) {
            throw new InvalidRequestException(validationErrors);
        }
    }

    public static boolean validateRequired(String field, String fieldName, ValidationErrors validationErrors) {
        if (isBlank(field)) {
            validationErrors.add(fieldName, fieldName + MISSING);
            return false;
        }
        return true;
    }

    public static boolean validateRequired(Object field, String fieldName, ValidationErrors validationErrors) {
        if (isNull(field)) {
            validationErrors.add(fieldName, fieldName + MISSING);
            return false;
        }
        return true;
    }

    public static boolean validateMaxLength(String field, String fieldName, int maxLength, ValidationErrors validationErrors) {
        if (!isBlank(field) && field.trim().length() > maxLength) {
            validationErrors.add(fieldName, fieldName + EXCEEDS_MAX_LENGTH);
            return false;
        }
        return true;
    }

    public static boolean validateDate(LocalDate field, String fieldName, ValidationErrors validationErrors) {
        if (!isNull(field) && !DateValidator.getInstance().isValid(field.toString(), INCOME_DATE_FORMAT)) {
            validationErrors.add(fieldName, fieldName + INVALID_DATE);
            return false;
        }
        return true;
    }

    public static boolean validateMaxValue(Long field, String fieldName, Long maxValue, ValidationErrors validationErrors) {
        if (!isNull(field) && field > maxValue) {
            validationErrors.add(fieldName, fieldName + EXCEEDS_MAX_VALUE);
            return false;
        }
        return true;
    }

    public static boolean validateMinValue(Long field, String fieldName, int minValue, ValidationErrors validationErrors) {
        if (!isNull(field) && field < minValue) {
            validationErrors.add(fieldName, fieldName + BELOW_MIN_VALUE);
            return false;
        }
        return true;
    }

    public static boolean validateDoubleRange(
        Double field,
        String fieldName,
        Double minValue,
        Double maxValue,
        ValidationErrors validationErrors
    ) {
        if (!isNull(field) && !DoubleValidator.getInstance().isInRange(field, minValue, maxValue)) {
            validationErrors.add(fieldName, fieldName + EXCEEDS_DOUBLE_RANGE);
            return false;
        }
        return true;
    }
}
