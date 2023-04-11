package com.hotel.service;

import com.hotel.entity.Servizi;
import com.hotel.repository.ServiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiziService {

    @Autowired
    private ServiziRepository ServiziRepository;

    public List<Servizi> findAll() {
        return ServiziRepository.findAll();
    }

    public Optional<Servizi> findById(Long id) {
        return ServiziRepository.findById(id);
    }

    public Servizi save(Servizi s) {
        return ServiziRepository.save(s);
    }

    public void delete(Servizi s) {
        ServiziRepository.delete(s);
    }
}
