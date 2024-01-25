package com.app.clinicaZeroBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoTratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int costo;
    private String color;

    @ManyToOne
    @JoinColumn(name = "diente_id")
    private Diente diente;

    public TipoTratamiento(String nombre, int costo, String color) {
        this.nombre = nombre;
        this.costo = costo;
        this.color = color;
    }

    public TipoTratamiento(String nombre, int costo, String color, Diente diente) {
        this.nombre = nombre;
        this.costo = costo;
        this.color = color;
        this.diente = diente;
    }
}
