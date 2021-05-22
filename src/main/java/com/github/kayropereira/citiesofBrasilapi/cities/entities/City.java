package com.github.kayropereira.citiesofBrasilapi.cities.entities;

import com.github.kayropereira.citiesofBrasilapi.utils.PointType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")

@TypeDefs({
        @TypeDef(name = "point", typeClass = PointType.class)
})

public class City {
    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;
    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public Point getLocation() {
        return location;
    }
}