package com.app.clinicaZeroBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Odontograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOdontograma;
    private String detalle;

    @OneToMany(mappedBy = "odontograma", cascade = CascadeType.ALL)
    private List<Diente> dientes;

    public Odontograma(String detalle) {
        this.detalle = detalle;
    }

    public Odontograma(String detalle, List<Diente> dientes) {
        this.detalle = detalle;
        this.dientes = dientes;
    }
}
