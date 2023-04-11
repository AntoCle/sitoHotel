package com.hotel.service;

import com.hotel.entity.Utente;
import com.hotel.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository UtenteRepository;


    public List<Utente> findAll() {
        return UtenteRepository.findAll();
    }

    public Optional<Utente> findById(Long id) {
        return UtenteRepository.findById(id);
    }

    public Utente save(Utente u) {
        return UtenteRepository.save(u);
    }

    public void delete(Utente u) {
        UtenteRepository.delete(u);
    }
}

/*public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    public Dipendente insertDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Optional<Dipendente> findById(Long id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente save(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public void delete(Dipendente dipendente) {
        dipendenteRepository.delete(dipendente);
    }

    public List<Servizio> findAllServiziByDipendente(Long id) {
        return dipendenteRepository.findAllServiziByDipendente(id);
    }*/
