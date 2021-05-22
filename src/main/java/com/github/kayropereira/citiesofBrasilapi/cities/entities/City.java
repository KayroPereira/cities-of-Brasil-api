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

        /*
      Column   |          Type          | Collation | Nullable |              Default
-----------+------------------------+-----------+----------+------------------------------------
 id        | bigint                 |           | not null | nextval('cidade_id_seq'::regclass)
 nome      | character varying(120) |           |          |
 uf        | integer                |           |          |
 ibge      | integer                |           |          |
 lat_lon   | point                  |           |          |
 latitude  | double precision       |           |          |
 longitude | double precision       |           |          |
 cod_tom   | smallint               |           |          | 0
Indexes:
    "cidade_pkey" PRIMARY KEY, btree (id)
     */

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;
    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

//    private Double latitude;
//    private Double longitude;

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