package br.com.pubfuture.finances;

import br.com.pubfuture.finances.api.facade.IncomesApi;
import br.com.pubfuture.finances.api.model.Income;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomeController implements IncomesApi {

    @Override
    public CompletableFuture<ResponseEntity<Income>> listIncomes(Long id) {
        return IncomesApi.super.listIncomes(id);
    }
}
