package com.renanbarhbosa.desafiocityeventdo0.services;

import com.renanbarhbosa.desafiocityeventdo0.dtos.EventDTO;
import com.renanbarhbosa.desafiocityeventdo0.entities.Event;
import com.renanbarhbosa.desafiocityeventdo0.repositories.EventRepository;
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
public class EventService {

    @Autowired
    private EventRepository repository;

    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> list = repository.findAll(pageable);
        return list.map(x -> new EventDTO(x));
    }

    @Transactional(readOnly = true)
    public EventDTO findById(Long id) {
        Optional<Event> obj = repository.findById(id);
        Event entity = obj.orElseThrow(() -> new RuntimeException("Entity not found."));
        return new EventDTO(entity);
    }

    @Transactional
    public EventDTO insert(EventDTO dto) {
        Event entity = new Event();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity = repository.save(entity);
        return new EventDTO(entity);
    }

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            Event entity = repository.getOne(id);
            entity.setName(dto.getName());
            entity.setDate(dto.getDate());
            entity.setUrl(dto.getUrl());
            entity = repository.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Id not found." + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Id not found." + id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Integrity violation.");
        }
    }
}
