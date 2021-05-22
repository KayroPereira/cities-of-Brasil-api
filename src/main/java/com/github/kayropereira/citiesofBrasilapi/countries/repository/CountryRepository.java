package com.github.kayropereira.citiesofBrasilapi.countries.repository;

import com.github.kayropereira.citiesofBrasilapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
