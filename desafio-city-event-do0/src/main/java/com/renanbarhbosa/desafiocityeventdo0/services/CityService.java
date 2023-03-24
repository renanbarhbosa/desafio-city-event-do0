package com.renanbarhbosa.desafiocityeventdo0.services;

import com.renanbarhbosa.desafiocityeventdo0.dtos.CityDTO;
import com.renanbarhbosa.desafiocityeventdo0.entities.City;
import com.renanbarhbosa.desafiocityeventdo0.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> cities = repository.findAll();
        return cities.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }

    public CityDTO findById(Long id) {
        Optional<City> obj = repository.findById(id);
        City entity = obj.orElseThrow(() -> new IllegalArgumentException("Id not found."));
        return new CityDTO(entity);
    }

    public CityDTO insert(CityDTO dto) {

    }
}
