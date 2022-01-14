package br.com.pubfuture.finances.mapper;

import br.com.pubfuture.finances.api.model.CreateIncomeDTO;
import br.com.pubfuture.finances.api.model.IncomeDTO;
import br.com.pubfuture.finances.domain.entity.Income;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class IncomeMapper {

    public abstract IncomeDTO fromEntityToDto(Income income);

    public abstract Income fromCreateIncomeDtoToEntity(CreateIncomeDTO createIncomeDTO);
}
