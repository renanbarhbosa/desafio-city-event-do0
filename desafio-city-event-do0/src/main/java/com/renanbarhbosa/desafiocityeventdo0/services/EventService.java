package com.renanbarhbosa.desafiocityeventdo0.services;

import com.renanbarhbosa.desafiocityeventdo0.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;


}
