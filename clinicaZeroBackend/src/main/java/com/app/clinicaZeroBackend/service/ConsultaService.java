package com.app.clinicaZeroBackend.service;

import com.app.clinicaZeroBackend.entity.Consulta;
import com.app.clinicaZeroBackend.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository;

    public List<Consulta> listConsulta(){
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getConsultaById(int id){
        return consultaRepository.findById(id);
    }

    public Optional<Consulta> getConsultaByNumero(int numero){
        return consultaRepository.findByNumero(numero);
    }

    public void create(Consulta consulta){
        consultaRepository.save(consulta);
    }

    public void delete(int id){
        consultaRepository.deleteById(id);
    }

    public boolean existById(int id){
        return consultaRepository.existsById(id);
    }

    public boolean existByNumero(int numero){
        return consultaRepository.existsByNumero(numero);
    }
}
