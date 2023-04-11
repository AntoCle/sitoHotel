package com.hotel.service;

import com.hotel.entity.Camera;
import com.hotel.entity.Prenotazione;
import com.hotel.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository PrenotazioneRepository;

    public List<Prenotazione> findAll() {
        return PrenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> findById(Long id) {
        return PrenotazioneRepository.findById(id);
    }

    public Prenotazione save(Prenotazione p) {
        return PrenotazioneRepository.save(p);
    }

    public void delete(Prenotazione p) {
        PrenotazioneRepository.delete(p);
    }

    /*public List<Camera> findCamereByDate(Date dataInizio, Date dataFine) {
        return PrenotazioneRepository.findCamereByDate(dataInizio, dataFine);
    }*/
}
