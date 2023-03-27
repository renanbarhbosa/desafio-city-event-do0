package com.renanbarhbosa.desafiocityeventdo0.dtos;

import com.renanbarhbosa.desafiocityeventdo0.entities.City;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class CityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 5, max = 20, message = "A cidade deve ter entre 5 e 20 caracteres.")
    private String name;

    public CityDTO() {
    }

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDTO(City entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
