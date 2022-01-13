package br.com.pubfuture.finances.service;

import static java.util.Objects.requireNonNull;

import br.com.pubfuture.finances.api.model.CreateExpenseDTO;
import br.com.pubfuture.finances.api.model.ExpenseDTO;
import br.com.pubfuture.finances.domain.entity.Expense;
import br.com.pubfuture.finances.domain.repository.ExpenseRepository;
import br.com.pubfuture.finances.exception.ExpenseNotFoundException;
import br.com.pubfuture.finances.mapper.ExpenseMapper;
import br.com.pubfuture.finances.validator.ExpenseValidator;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseValidator expenseValidator;
    private final ExpenseMapper expenseMapper;

    public ExpenseService(ExpenseRepository expenseRepository, ExpenseValidator expenseValidator, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseValidator = expenseValidator;
        this.expenseMapper = expenseMapper;
    }

    public ExpenseDTO getExpense(Long id) {
        requireNonNull(id);
        Expense expense = expenseRepository
            .findById(id)
            .orElseThrow(() -> new ExpenseNotFoundException("Expense not found: " + id));

        return expenseMapper.fromEntityToDto(expense);
    }

    public ExpenseDTO createExpense(CreateExpenseDTO createExpenseDTO) {
        expenseValidator.validate(createExpenseDTO);
        var expense = expenseMapper.fromCreateExpenseDtoToEntity(createExpenseDTO);
        expenseRepository.save(expense);
        return expenseMapper.fromEntityToDto(expense);
    }
}
