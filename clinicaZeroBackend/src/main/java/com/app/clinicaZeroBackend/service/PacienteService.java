package com.app.clinicaZeroBackend.service;

import com.app.clinicaZeroBackend.entity.Paciente;
import com.app.clinicaZeroBackend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> listPacientes(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getPacienteById(int id){
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> getPacienteByNombre(String nombre){
        return pacienteRepository.findByNombre(nombre);
    }

    public void createPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    public void deletePaciente(int id){
        pacienteRepository.deleteById(id);
    }

    public boolean existById(int id){
        return pacienteRepository.existsById(id);
    }
    public boolean existByNombre(String nombre){
            return pacienteRepository.existsByNombre(nombre);
    }
}
