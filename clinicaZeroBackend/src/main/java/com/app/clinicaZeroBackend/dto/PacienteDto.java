package com.app.clinicaZeroBackend.dto;

import com.app.clinicaZeroBackend.entity.Antecedentes;
import com.app.clinicaZeroBackend.entity.SignosVitales;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private Antecedentes antecedentes;
    private SignosVitales signosVitales;

}
