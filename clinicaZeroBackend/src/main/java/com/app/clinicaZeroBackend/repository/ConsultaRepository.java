package com.app.clinicaZeroBackend.repository;

import com.app.clinicaZeroBackend.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    Optional<Consulta> findByNumero(int numero);
    boolean existsByNumero(int numero);

}
