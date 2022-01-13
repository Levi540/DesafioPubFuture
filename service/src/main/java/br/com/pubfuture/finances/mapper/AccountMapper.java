package br.com.pubfuture.finances.mapper;

import br.com.pubfuture.finances.api.model.AccountDTO;
import br.com.pubfuture.finances.api.model.CreateAccountDTO;
import br.com.pubfuture.finances.domain.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    public abstract AccountDTO fromEntityToDto(Account account);

    public abstract Account fromCreateAccountDtoToEntity(CreateAccountDTO createAccountDTO);
}
