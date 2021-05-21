package com.github.kayropereira.citiesofBrasilapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private CityRepository repository;

    public CityResource(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<City> cities(Pageable page){

        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<City> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path="uf/{state}")
    public List<City> getUf(@PathVariable("state") Integer uf){
        List<City> cidades = repository.findByUf(uf);

        return cidades;
    }

    @GetMapping("filter")
    public ResponseEntity getCityNameAndUf(@RequestParam("city") String name, @RequestParam("uf") Integer uf){
        Optional<City> optional = repository.findByNameAndUf(name, uf);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("name/{city}")
//    public ResponseEntity getCityName(@PathVariable("city") String name){
//        Optional<City> optional = repository.findByName(name);
//
//        if(optional.isPresent()){
//            return ResponseEntity.ok().body(optional.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
}
