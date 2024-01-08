package com.app.clinicaZeroBackend.controller;

import com.app.clinicaZeroBackend.dto.Mensaje;
import com.app.clinicaZeroBackend.dto.PacienteDto;
import com.app.clinicaZeroBackend.entity.Paciente;
import com.app.clinicaZeroBackend.service.PacienteService;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/lista")
    public ResponseEntity<List<Paciente>> listPacientes(){
        List<Paciente> pacientes = pacienteService.listPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") int id){
        if(!pacienteService.existById(id)){
            return new ResponseEntity(new Mensaje("El paciente no existe"), HttpStatus.NOT_FOUND);
        }else{
            Paciente paciente = pacienteService.getPacienteById(id).get();
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
    }

    @GetMapping("/detail/name/{nombre}")
    public ResponseEntity<Paciente> getPacienteByNombre(@PathVariable("nombre") String nombre){
        if(!pacienteService.existByNombre(nombre)){
            return new ResponseEntity(new Mensaje("El paciente no existe"), HttpStatus.NOT_FOUND);
        }else{
            Paciente paciente = pacienteService.getPacienteByNombre(nombre).get();
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> createPaciente(@RequestBody PacienteDto pacienteDto){
        if(StringUtils.isBlank(pacienteDto.getNombre())){
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(pacienteDto.getCarnet_identidad() <= 0){
            return new ResponseEntity<>(new Mensaje("el carnet de identidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }


    }
}
