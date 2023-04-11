package com.hotel.controller;

import com.hotel.entity.Camera;
import com.hotel.entity.CameraServizi;
import com.hotel.service.CameraServiziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cameraServizi")
@CrossOrigin(allowedHeaders = {"*"})
public class CameraServiziController {

    @Autowired
    private CameraServiziService cameraServiziService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<CameraServizi>> getAllCamera_Servizi(){
        try {
            List<CameraServizi> listCameraServizi = cameraServiziService.findAll();
            if(listCameraServizi.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listCameraServizi, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }


    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<CameraServizi> getCameraServiziById(@PathVariable Long id) {
        Optional<CameraServizi> existingCameraServizi = cameraServiziService.findById(id);
        try {
            if (existingCameraServizi.isPresent()) {
                return new ResponseEntity<>(existingCameraServizi.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<CameraServizi> createCameraServizi(@RequestBody CameraServizi cameraServizi) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            cameraServizi.setData_creazione(timestamp);
            CameraServizi p = cameraServiziService.save(cameraServizi); //APPOGGINO
            if (p == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CameraServizi> updateCameraServizi(@PathVariable Long id, @RequestBody CameraServizi cs) {
        Optional<CameraServizi> existingCameraServizi = cameraServiziService.findById(id);

        try {
            if (!existingCameraServizi.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                CameraServizi csDiAppoggio = existingCameraServizi.get();
                csDiAppoggio.setServizi(cs.getServizi());
                csDiAppoggio.setCamera(cs.getCamera());
                csDiAppoggio.setVersione(cs.getVersione());
                csDiAppoggio.setData_ultima_modifica(cs.getData_ultima_modifica());
                CameraServizi csAggiornata = cameraServiziService.save(csDiAppoggio);
                return new ResponseEntity<>(csAggiornata, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCameraServizi(@PathVariable Long id) {
        Optional<CameraServizi> existingCameraServizi = cameraServiziService.findById(id);
        try {
            if (existingCameraServizi.isPresent()) {
                cameraServiziService.delete(existingCameraServizi.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}