package br.com.pubfuture.finances.unit;

import static br.com.pubfuture.finances.utils.MapperUtils.incomeMapper;
import static br.com.pubfuture.finances.utils.TestDataCreator.newIncomeBuilder;

import br.com.pubfuture.finances.core.BaseUnitTest;
import br.com.pubfuture.finances.mapper.IncomeMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IncomeMapperUnitTest extends BaseUnitTest {
    private IncomeMapper victim;

    @BeforeEach
    void setupEach() {
        victim = incomeMapper();
    }

    @Test
    void testFromEntityToDto() {
        var income = newIncomeBuilder().build();
        var dto = victim.fromEntityToDto(income);

        Assertions.assertEquals(income.getId(), dto.getId());
        Assertions.assertEquals(income.getDescription(), dto.getDescription());
        Assertions.assertEquals(income.getReceiptDate(), dto.getReceiptDate());
        Assertions.assertEquals(income.getExpectedReceiptDate(), dto.getExpectedReceiptDate());
        Assertions.assertEquals(income.getIdAccount(), dto.getIdAccount());
        Assertions.assertEquals(income.getTypeIncome(), dto.getTypeIncome());
    }
}
