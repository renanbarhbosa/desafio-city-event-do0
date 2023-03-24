package com.renanbarhbosa.desafiocityeventdo0.dtos;

import com.renanbarhbosa.desafiocityeventdo0.entities.City;
import com.renanbarhbosa.desafiocityeventdo0.entities.Event;

import java.io.Serializable;
import java.time.LocalDate;

public class EventDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDate date;
    private String url;

    private City city;

    public EventDTO() {
    }

    public EventDTO(Long id, String name, LocalDate date, String url) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
    }

    public EventDTO(Event entity) {
        name = entity.getName();
        date = entity.getDate();
        url = entity.getUrl();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public City getCity() {
        return city;
    }
}
