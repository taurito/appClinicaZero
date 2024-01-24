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
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;
    private int numero;
    private String fecha;
    private int costo;

    public Consulta(int numero, String fecha, int costo) {
        this.numero = numero;
        this.fecha = fecha;
        this.costo = costo;
    }
}
