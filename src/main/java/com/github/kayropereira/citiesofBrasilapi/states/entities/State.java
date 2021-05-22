package com.github.kayropereira.citiesofBrasilapi.states.entities;

import com.github.kayropereira.citiesofBrasilapi.countries.entities.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")

@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {
/*
                                  Table "public.estado"
 Column |         Type          | Collation | Nullable |              Default
--------+-----------------------+-----------+----------+------------------------------------
 id     | bigint                |           | not null | nextval('estado_id_seq'::regclass)
 nome   | character varying(60) |           |          |
 uf     | character varying(2)  |           |          |
 ibge   | integer               |           |          |
 pais   | integer               |           |          |
 ddd    | json                  |           |          |
Indexes:
    "estado_pkey" PRIMARY KEY, btree (id)
 */

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

//    @Column(name = "pais")
//    private Integer countryId;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

//    public Integer getCountryId() {
//        return countryId;
//    }

    public Country getCountry() {
        return country;
    }

    public List<Integer> getDdd() {
        return ddd;
    }
}