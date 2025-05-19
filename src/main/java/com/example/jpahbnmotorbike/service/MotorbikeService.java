package com.example.jpahbnmotorbike.service;

import com.example.jpahbnmotorbike.model.Motorbike;
import com.example.jpahbnmotorbike.repository.IMotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorbikeService implements IMotorbikeService {

    @Autowired
    private IMotorbikeRepository motorbikeRepository;

    @Override
    public List<Motorbike> findAll() {
        return motorbikeRepository.findAll();
    }

    @Override
    public Motorbike findById(long id) {
        return motorbikeRepository.findById(id);
    }

    @Override
    public List<Motorbike> findByName(String name) {
        return motorbikeRepository.findByName(name);
    }

    @Override
    public List<Motorbike> findByBestSelling() {
        return motorbikeRepository.findByBestSelling();
    }

    @Override
    public void save(Motorbike motorbike) {
        motorbikeRepository.save(motorbike);
    }

    @Override
    public void delete(long id) {
        motorbikeRepository.delete(id);
    }
}
