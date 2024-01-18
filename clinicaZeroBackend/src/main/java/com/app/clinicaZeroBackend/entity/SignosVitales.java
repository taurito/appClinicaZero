package com.app.clinicaZeroBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignosVitales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVital;
    private int presionArterial;
    private String frecuenciaCardiaca;
    private String temperatura;
    private String tipoSangre;
}
