package com.app.clinicaZeroBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String fecha_inicio;
    private String fecha_nacimiento;
    private int carnet_identidad;
    private int telefono_celular;
    private int edad;
    private String sexo;
    private String email;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String fecha_inicio, String fecha_nacimiento, int carnet_identidad, int telefono_celular, int edad, String sexo, String email) {
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
