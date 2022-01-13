package br.com.pubfuture.finances.service;

import static java.util.Objects.requireNonNull;

import br.com.pubfuture.finances.api.model.AccountDTO;
import br.com.pubfuture.finances.api.model.CreateAccountDTO;
import br.com.pubfuture.finances.domain.entity.Account;
import br.com.pubfuture.finances.domain.repository.AccountRepository;
import br.com.pubfuture.finances.exception.AccountNotFoundException;
import br.com.pubfuture.finances.mapper.AccountMapper;
import br.com.pubfuture.finances.validator.AccountValidator;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountValidator accountValidator;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountValidator accountValidator, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountValidator = accountValidator;
        this.accountMapper = accountMapper;
    }

    public AccountDTO getAccount(Long id) {
        requireNonNull(id);
        Account account = accountRepository
            .findById(id)
            .orElseThrow(() -> new AccountNotFoundException("Account not found: " + id));

        return accountMapper.fromEntityToDto(account);
    }

    public AccountDTO createAccount(CreateAccountDTO createAccountDTO) {
        accountValidator.validate(createAccountDTO);
        var account = accountMapper.fromCreateAccountDtoToEntity(createAccountDTO);
        accountRepository.save(account);
        return accountMapper.fromEntityToDto(account);
    }
}
