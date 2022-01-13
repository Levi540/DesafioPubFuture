package br.com.pubfuture.finances.mapper;

import br.com.pubfuture.finances.api.model.CreateExpenseDTO;
import br.com.pubfuture.finances.api.model.ExpenseDTO;
import br.com.pubfuture.finances.domain.entity.Expense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ExpenseMapper {

    public abstract ExpenseDTO fromEntityToDto(Expense expense);

    public abstract Expense fromCreateExpenseDtoToEntity(CreateExpenseDTO createExpenseDTO);
}
