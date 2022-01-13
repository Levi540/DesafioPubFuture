package br.com.pubfuture.finances.controller;

import static java.util.concurrent.CompletableFuture.*;

import br.com.pubfuture.finances.api.facade.ExpenseApi;
import br.com.pubfuture.finances.api.model.CreateExpenseDTO;
import br.com.pubfuture.finances.api.model.ExpenseDTO;
import br.com.pubfuture.finances.service.ExpenseService;
import br.com.pubfuture.finances.util.ResponseEntityUtils;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController implements ExpenseApi {
    private final Executor controllerExecutor;
    private final ExpenseService expenseService;

    public ExpenseController(Executor controllerExecutor, ExpenseService expenseService) {
        this.controllerExecutor = controllerExecutor;
        this.expenseService = expenseService;
    }

    @Override
    public CompletableFuture<ResponseEntity<ExpenseDTO>> getExpense(Long id) {
        return supplyAsync(() -> expenseService.getExpense(id), controllerExecutor).thenApply(ResponseEntityUtils::ok);
    }

    @Override
    public CompletableFuture<ResponseEntity<ExpenseDTO>> createExpense(CreateExpenseDTO createExpenseDTO) {
        return supplyAsync(() -> expenseService.createExpense(createExpenseDTO), controllerExecutor)
            .thenApply(ResponseEntityUtils::created);
    }
}
