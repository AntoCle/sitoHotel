package com.hotel.repository;

import com.hotel.entity.Camera;
import com.hotel.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    /*@Query("SELECT * FROM camera c WHERE c.id NOT IN ( SELECT c.id_hotel  FROM camera c JOIN prenotazione p ON c.id = p.id_camera WHERE (DATE(p.data_inizio) BETWEEN DATE(p.data_inizio) AND DATE(p.data_fine)))")
    List<Camera> findCamereByDate(@Param("dataInizio") Date dataInizio, @Param("dataFine") Date dataFine);*/
}
