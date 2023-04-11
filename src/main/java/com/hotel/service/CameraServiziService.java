package com.hotel.service;

import com.hotel.entity.CameraServizi;
import com.hotel.repository.CameraServiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraServiziService {

    @Autowired
    private CameraServiziRepository CameraServiziRepository;

    public List<CameraServizi> findAll() {
        return CameraServiziRepository.findAll();
    }

    public Optional<CameraServizi> findById(Long id) {
        return CameraServiziRepository.findById(id);
    }

    public CameraServizi save(CameraServizi cs) {
        return CameraServiziRepository.save(cs);
    }

    public void delete(CameraServizi cs) {
        CameraServiziRepository.delete(cs);
    }
}
