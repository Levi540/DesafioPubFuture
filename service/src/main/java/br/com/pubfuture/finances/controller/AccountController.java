package br.com.pubfuture.finances.controller;

import static java.util.concurrent.CompletableFuture.*;

import br.com.pubfuture.finances.api.facade.AccountApi;
import br.com.pubfuture.finances.api.model.AccountDTO;
import br.com.pubfuture.finances.api.model.CreateAccountDTO;
import br.com.pubfuture.finances.service.AccountService;
import br.com.pubfuture.finances.util.ResponseEntityUtils;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountApi {
    private final Executor controllerExecutor;
    private final AccountService accountService;

    public AccountController(Executor controllerExecutor, AccountService accountService) {
        this.controllerExecutor = controllerExecutor;
        this.accountService = accountService;
    }

    @Override
    public CompletableFuture<ResponseEntity<AccountDTO>> getAccount(Long id) {
        return supplyAsync(() -> accountService.getAccount(id), controllerExecutor).thenApply(ResponseEntityUtils::ok);
    }

    @Override
    public CompletableFuture<ResponseEntity<AccountDTO>> createAccount(CreateAccountDTO createAccountDTO) {
        return supplyAsync(() -> accountService.createAccount(createAccountDTO), controllerExecutor)
            .thenApply(ResponseEntityUtils::created);
    }
}
