package com.app.clinicaZeroBackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PacienteDto {

    @NotBlank
    private String nombre;
    private String apellido;
    private String fecha_inicio;
    private String fecha_nacimiento;
    @NotBlank
    private int carnet_identidad;
    private int telefono_celular;
    private int edad;
    private String sexo;
    private String email;

    public PacienteDto() {
    }

    public PacienteDto(String nombre, String apellido, String fecha_inicio, String fecha_nacimiento, int carnet_identidad, int telefono_celular, int edad, String sexo, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_inicio = fecha_inicio;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carnet_identidad = carnet_identidad;
        this.telefono_celular = telefono_celular;
        this.edad = edad;
        this.sexo = sexo;
        this.email = email;
    }
}
