package com.app.clinicaZeroBackend.repository;

import com.app.clinicaZeroBackend.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Integer> {
    Optional<Paciente> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
