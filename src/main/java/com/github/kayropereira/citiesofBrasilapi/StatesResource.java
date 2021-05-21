package com.github.kayropereira.citiesofBrasilapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StatesResource {

    private StatesRepository repository;

    public StatesResource(StatesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<State> states(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getOne(@PathVariable Long id){

        Optional<State> optional = repository.findById(id);

        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "name/{state}")
    public ResponseEntity getPorNome(@PathVariable("state") String name){

        Optional<State> optional = repository.findByName(name);

        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
