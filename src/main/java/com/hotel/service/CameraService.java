package com.hotel.service;

import com.hotel.repository.CameraRepository;
import com.hotel.entity.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private CameraRepository CameraRepository;

    public List<Camera> findAll() {
        return CameraRepository.findAll();
    }

    public Optional<Camera> findById(Long id) {
        return CameraRepository.findById(id);
    }

    public Camera save(Camera c) {
        return CameraRepository.save(c);
    }

    public void delete(Camera c) {
        CameraRepository.delete(c);
    }
}
