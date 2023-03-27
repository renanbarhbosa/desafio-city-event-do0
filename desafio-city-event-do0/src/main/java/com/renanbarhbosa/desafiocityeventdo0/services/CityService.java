package com.renanbarhbosa.desafiocityeventdo0.services;

import com.renanbarhbosa.desafiocityeventdo0.dtos.CityDTO;
import com.renanbarhbosa.desafiocityeventdo0.entities.City;
import com.renanbarhbosa.desafiocityeventdo0.repositories.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public Page<CityDTO> findAll(Pageable pageable) {
        Page<City> list = repository.findAll(pageable);
        return list.map(x -> new CityDTO(x));
    }

    @Transactional(readOnly = true)
    public CityDTO findById(Long id) {
        Optional<City> obj = repository.findById(id);
        City entity = obj.orElseThrow(() -> new IllegalArgumentException("Id not found."));
        return new CityDTO(entity);
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CityDTO(entity);
    }

    @Transactional(readOnly = true)
    public CityDTO update(Long id, CityDTO dto) {
        try {
            City entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CityDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Entity not found.");
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Id not found." + id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Integrity violation");
        }
    }
}
