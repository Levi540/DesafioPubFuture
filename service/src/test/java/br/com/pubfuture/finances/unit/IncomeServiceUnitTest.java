package br.com.pubfuture.finances.unit;

import static br.com.pubfuture.finances.utils.MapperUtils.incomeMapper;
import static br.com.pubfuture.finances.utils.TestConstants.DEFAULT_INCOME_ID;
import static br.com.pubfuture.finances.utils.TestDataCreator.newIncomeBuilder;
import static org.mockito.Mockito.when;

import br.com.pubfuture.finances.core.BaseUnitTest;
import br.com.pubfuture.finances.domain.repository.IncomeRepository;
import br.com.pubfuture.finances.service.IncomeService;
import br.com.pubfuture.finances.validator.IncomeValidator;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class IncomeServiceUnitTest extends BaseUnitTest {
    private IncomeService victim;

    @Mock
    private IncomeRepository incomeRepository;

    @Mock
    private IncomeValidator incomeValidator;

    @BeforeEach
    void setupEach() {
        victim = new IncomeService(incomeRepository, incomeValidator, incomeMapper());
    }

    @Test
    void testGetIncome() {
        var income = newIncomeBuilder().build();
        when(incomeRepository.findById(DEFAULT_INCOME_ID)).thenReturn(Optional.of(income));

        var dto = victim.getIncome(DEFAULT_INCOME_ID);
        Assertions.assertEquals(income.getId(), dto.getId());
        Assertions.assertEquals(income.getDescription(), dto.getDescription());
        Assertions.assertEquals(income.getReceiptDate(), dto.getReceiptDate());
        Assertions.assertEquals(income.getExpectedReceiptDate(), dto.getExpectedReceiptDate());
        Assertions.assertEquals(income.getIdAccount(), dto.getIdAccount());
        Assertions.assertEquals(income.getTypeIncome(), dto.getTypeIncome());
    }
}
