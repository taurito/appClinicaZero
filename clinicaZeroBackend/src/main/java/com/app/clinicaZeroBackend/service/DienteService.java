package com.app.clinicaZeroBackend.service;

import com.app.clinicaZeroBackend.entity.Diente;
import com.app.clinicaZeroBackend.repository.DienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DienteService {
    @Autowired
    DienteRepository dienteRepository;

    public List<Diente> list(){
        return dienteRepository.findAll();
    }

    public Optional<Diente> getById(int id){
        return  dienteRepository.findById(id);
    }

    public Optional<Diente> getByNombre(String nombre){
        return dienteRepository.findByNombre(nombre);
    }

    public void create(Diente diente){
        dienteRepository.save(diente);
    }

    public void delete(int id){
        dienteRepository.deleteById(id);
    }

    public boolean existById(int id){
        return dienteRepository.existsById(id);
    }

    public boolean existByNombre(String nombre){
        return dienteRepository.existsByNombre(nombre);
    }
}
