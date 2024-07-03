package com.neoflex.prokhorov.tariff_service.service;

import com.neoflex.prokhorov.tariff_service.domain.Tariff;
import com.neoflex.prokhorov.tariff_service.domain.TariffRepository;
import com.neoflex.prokhorov.tariff_service.service.dto.TariffDto;
import com.neoflex.prokhorov.tariff_service.service.mapper.TariffMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TariffService {
    @Autowired
    TariffRepository repository;
    @Autowired
    TariffMapper mapper;

    static final String ENTITY_FIND_EXCEPTION = "Не найден тариф с id %s";

    public TariffDto create(TariffDto dto) {
        Tariff tariff = mapper.toEntity(dto);
        return mapper.toDto(repository.save(tariff));
    }

    public TariffDto update(UUID id, TariffDto dto) {
        Tariff tariff = findById(id);
        tariff = mapper.update(tariff, dto);
        return mapper.toDto(repository.save(tariff));
    }

    public List<TariffDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public TariffDto getById(UUID id) {
        Tariff tariff = findById(id);
        return mapper.toDto(tariff);
    }

    private Tariff findById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(String.format(ENTITY_FIND_EXCEPTION, id)));
    }

    public void delete(UUID id) {
        Tariff tariff = findById(id);
        repository.delete(tariff);
    }
}
