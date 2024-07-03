package com.neoflex.prokhorov.tariff_service.web;

import com.neoflex.prokhorov.tariff_service.service.TariffService;
import com.neoflex.prokhorov.tariff_service.service.dto.TariffDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tariffs")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class TariffController {
    @Autowired
    TariffService tariffService;

    @PostMapping
    TariffDto create(@RequestBody TariffDto dto) {
        return tariffService.create(dto);
    }

    @PatchMapping("/{id}")
    TariffDto update(@PathVariable UUID id, @RequestBody TariffDto dto) {
        return tariffService.update(id, dto);
    }

    @GetMapping
    List<TariffDto> getAll() {
        return tariffService.getAll();
    }

    @GetMapping("/{id}")
    TariffDto getById(@PathVariable UUID id) {
        return tariffService.getById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        tariffService.delete(id);
    }
}
