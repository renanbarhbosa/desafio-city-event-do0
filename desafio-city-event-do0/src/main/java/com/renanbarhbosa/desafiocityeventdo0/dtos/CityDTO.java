package com.renanbarhbosa.desafiocityeventdo0.dtos;

import com.renanbarhbosa.desafiocityeventdo0.entities.City;
import com.renanbarhbosa.desafiocityeventdo0.entities.Event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private List<Event> events = new ArrayList<>();

    public CityDTO() {
    }

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDTO(City entity) {
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

    public List<Event> getEvents() {
        return events;
    }
}
