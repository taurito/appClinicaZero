package com.app.clinicaZeroBackend.dto;

import com.app.clinicaZeroBackend.entity.Odontograma;
import com.app.clinicaZeroBackend.entity.TipoTratamiento;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DienteDto {

    @NotBlank
    private String nombre;
    private int numero;
    private int posicion;
    private String estado;
    private String descripcion;
    private int costo;
    Odontograma odontograma;
    private List<TipoTratamiento> tipoTratamientos;

    public DienteDto(String nombre, int numero, int posicion, String estado, String descripcion, int costo) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public DienteDto(int numero, int posicion, String estado, String descripcion, int costo, Odontograma odontograma, List<TipoTratamiento> tipoTratamientos) {
        this.numero = numero;
        this.posicion = posicion;
        this.estado = estado;
        this.descripcion = descripcion;
        this.costo = costo;
        this.odontograma = odontograma;
        this.tipoTratamientos = tipoTratamientos;
    }
}
