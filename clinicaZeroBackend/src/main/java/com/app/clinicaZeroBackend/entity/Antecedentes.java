package com.app.clinicaZeroBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Antecedentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAntecedente;
    private String facial;
    private String enfermedad;
    private String alergia;
    private String hemorragia;
    private String heridas;
    private String mediamentos;
    private String otros;

}
