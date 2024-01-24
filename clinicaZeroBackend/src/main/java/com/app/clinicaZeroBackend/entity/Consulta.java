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
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;
    private int numero;
    private String fecha;
    private int costo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "odontograma_id",
            referencedColumnName = "idOdontograma"
    )
    private Odontograma odontograma;

    public Consulta(int numero, String fecha, int costo) {
        this.numero = numero;
        this.fecha = fecha;
        this.costo = costo;
    }

    public Consulta(int numero, String fecha, int costo, Odontograma odontograma) {
        this.numero = numero;
        this.fecha = fecha;
        this.costo = costo;
        this.odontograma = odontograma;
    }


}
