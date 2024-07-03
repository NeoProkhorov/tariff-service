package com.neoflex.prokhorov.tariff_service.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, UUID> {
}