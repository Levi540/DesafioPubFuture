package br.com.pubfuture.finances.controller;

import static java.util.concurrent.CompletableFuture.*;

import br.com.pubfuture.finances.api.facade.IncomesApi;
import br.com.pubfuture.finances.api.model.CreateIncomeDTO;
import br.com.pubfuture.finances.api.model.IncomeDTO;
import br.com.pubfuture.finances.api.model.UpdateIncomeDTO;
import br.com.pubfuture.finances.service.IncomeService;
import br.com.pubfuture.finances.util.ResponseEntityUtils;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomeController implements IncomesApi {
    private final Executor controllersExecutor;
    private final IncomeService incomeService;

    public IncomeController(Executor controllersExecutor, IncomeService incomeService) {
        this.controllersExecutor = controllersExecutor;
        this.incomeService = incomeService;
    }

    @Override
    public CompletableFuture<ResponseEntity<IncomeDTO>> getIncome(Long id) {
        return supplyAsync(() -> incomeService.getIncome(id), controllersExecutor).thenApply(ResponseEntityUtils::ok);
    }

    @Override
    public CompletableFuture<ResponseEntity<IncomeDTO>> createIncome(CreateIncomeDTO createIncomeDTO) {
        return supplyAsync(() -> incomeService.createIncome(createIncomeDTO), controllersExecutor)
            .thenApply(ResponseEntityUtils::created);
    }

    @Override
    public CompletableFuture<ResponseEntity<Void>> deleteIncome(Long id) {
        return runAsync(() -> incomeService.deleteIncome(id), controllersExecutor).thenApply(ResponseEntityUtils::noContent);
    }
    //    @Override
    //    public CompletableFuture<ResponseEntity<List<IncomeDTO>>> listIncomes(String description, LocalDate startAt, LocalDate endAt, Long idAccount, String typeIncome) {
    //        return supplyAsync(() -> incomeService.listIncomes(description, startAt, endAt, idAccount, typeIncome), controllersExecutor)
    //                .thenApply(ResponseEntityUtils::ok);
    //    }

    //    @Override
    //    public CompletableFuture<ResponseEntity<Void>> updateIncome(Long id, UpdateIncomeDTO updateIncomeDTO) {
    //        return runAsync(() -> incomeService.updateIncome(id, updateIncomeDTO), controllersExecutor)
    //                .thenApply(ResponseEntityUtils::noContent);
    //    }
}
