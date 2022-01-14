package br.com.pubfuture.finances.utils;

import br.com.pubfuture.finances.mapper.IncomeMapper;
import org.mapstruct.factory.Mappers;

public final class MapperUtils {

    private MapperUtils() {}

    public static IncomeMapper incomeMapper() {
        return Mappers.getMapper(IncomeMapper.class);
    }
}
