package com.app.clinicaZeroBackend.repository;

import com.app.clinicaZeroBackend.entity.Diente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DienteRepository extends JpaRepository<Diente, Integer> {
    Optional<Diente> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
