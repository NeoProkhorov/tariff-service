package com.neoflex.prokhorov.tariff_service.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tariff extends AbstractPersistable<UUID> {
    @NotNull
    String name;
    @NotNull
    LocalDate startDate;
    @NotNull
    LocalDate endDate;
    String description;
    double rate;
    int version;

    public int updateVersion() {
        return ++ this.version;
    }
}
