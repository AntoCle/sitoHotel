package com.hotel.service;

import com.hotel.entity.Recensioni;
import com.hotel.repository.RecensioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecensioniService {

    @Autowired
    private RecensioniRepository RecensioniRepository;

    public List<Recensioni> findAll() {
        return RecensioniRepository.findAll();
    }

    public Optional<Recensioni> findById(Long id) {
        return RecensioniRepository.findById(id);
    }

    public Recensioni save(Recensioni s) {
        return RecensioniRepository.save(s);
    }

    public void delete(Recensioni s) {
        RecensioniRepository.delete(s);
    }
}
