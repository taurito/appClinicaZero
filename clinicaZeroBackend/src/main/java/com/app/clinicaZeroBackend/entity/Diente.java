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
public class Diente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiente;
    private String nombre;
    private int numero;
    private int posicion;
    private String estado;
    private String descripcion;
    private int costo;

    @ManyToOne
    @JoinColumn(name = "odontograma_id")
    private Odontograma odontograma;

    public Diente(String nombre, int numero, int posicion, String estado, String descripcion, int costo) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Diente(String nombre, int numero, int posicion, String estado, String descripcion, int costo, Odontograma odontograma) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.costo = costo;
        this.odontograma = odontograma;
    }
}
