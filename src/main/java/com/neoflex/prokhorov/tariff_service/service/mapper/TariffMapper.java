package com.neoflex.prokhorov.tariff_service.service.mapper;

import com.neoflex.prokhorov.tariff_service.domain.Tariff;
import com.neoflex.prokhorov.tariff_service.service.dto.TariffDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    Tariff toEntity(TariffDto source);

    TariffDto toDto(Tariff source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", expression = "java(tariff.updateVersion())")
    Tariff update(@MappingTarget Tariff tariff, TariffDto source);

    default List<TariffDto> toDtoList(List<Tariff> sourceList) {
        return sourceList.stream().map(this::toDto).toList();
    }
}
