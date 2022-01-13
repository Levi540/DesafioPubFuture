package br.com.pubfuture.finances.service;

import static java.util.Objects.requireNonNull;

import br.com.pubfuture.finances.api.model.CreateIncomeDTO;
import br.com.pubfuture.finances.api.model.IncomeDTO;
import br.com.pubfuture.finances.domain.entity.Income;
import br.com.pubfuture.finances.domain.repository.IncomeRepository;
import br.com.pubfuture.finances.exception.IncomeNotFoundException;
import br.com.pubfuture.finances.mapper.IncomeMapper;
import br.com.pubfuture.finances.validator.IncomeValidator;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeValidator incomeValidator;
    private final IncomeMapper incomeMapper;

    public IncomeService(IncomeRepository incomeRepository, IncomeValidator incomeValidator, IncomeMapper incomeMapper) {
        this.incomeRepository = incomeRepository;
        this.incomeValidator = incomeValidator;
        this.incomeMapper = incomeMapper;
    }

    public IncomeDTO getIncome(Long id) {
        requireNonNull(id);
        Income income = incomeRepository.findById(id).orElseThrow(() -> new IncomeNotFoundException("Income not found: " + id));

        return incomeMapper.fromEntityToDto(income);
    }

    public IncomeDTO createIncome(CreateIncomeDTO createIncomeDTO) {
        incomeValidator.validate(createIncomeDTO);
        var income = incomeMapper.fromCreateIncomeDtoToEntity(createIncomeDTO);
        incomeRepository.save(income);
        return incomeMapper.fromEntityToDto(income);
    }
}
