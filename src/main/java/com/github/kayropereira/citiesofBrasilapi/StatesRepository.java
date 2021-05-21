package com.github.kayropereira.citiesofBrasilapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatesRepository extends JpaRepository<State, Long> {

    Optional<State> findById(Long id);
    Optional<State> findByName(String name);
}
