package com.app.clinicaZeroBackend.controller;

import com.app.clinicaZeroBackend.dto.Mensaje;
import com.app.clinicaZeroBackend.dto.PacienteDto;
import com.app.clinicaZeroBackend.entity.Paciente;
import com.app.clinicaZeroBackend.service.PacienteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create")
    public ResponseEntity<?> createPaciente(@RequestBody PacienteDto pacienteDto){
        if(StringUtils.isBlank(pacienteDto.getNombre())){
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(pacienteDto.getCarnet_identidad() <= 0){
            return new ResponseEntity<>(new Mensaje("el carnet de identidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Paciente paciente = new Paciente(
                pacienteDto.getNombre(),
                pacienteDto.getApellido(),
                pacienteDto.getFecha_inicio(),
                pacienteDto.getFecha_nacimiento(),
                pacienteDto.getCarnet_identidad(),
                pacienteDto.getTelefono_celular(),
                pacienteDto.getEdad(),
                pacienteDto.getSexo(),
                pacienteDto.getEmail()
        );
        pacienteService.createPaciente(paciente);
        return new ResponseEntity<>(new Mensaje("paciente creado exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable("id") int id, @RequestBody PacienteDto pacienteDto){
        if(!pacienteService.existById(id)){
            return  new ResponseEntity<>(new Mensaje("Este paciente no existe"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(pacienteDto.getNombre())){
            return new ResponseEntity<>(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(pacienteDto.getCarnet_identidad() <= 0){
            return new ResponseEntity<>(new Mensaje("el carnet de identidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Paciente paciente = pacienteService.getPacienteById(id).get();
        paciente.setNombre(pacienteDto.getNombre());
        paciente.setApellido(pacienteDto.getApellido());
        paciente.setFecha_inicio(pacienteDto.getFecha_inicio());
        paciente.setFecha_nacimiento(pacienteDto.getFecha_nacimiento());
        paciente.setCarnet_identidad(pacienteDto.getCarnet_identidad());
        paciente.setTelefono_celular(pacienteDto.getTelefono_celular());
        paciente.setEdad(pacienteDto.getEdad());
        paciente.setSexo(pacienteDto.getSexo());
        paciente.setEmail(pacienteDto.getEmail());

        pacienteService.createPaciente(paciente);
        return new ResponseEntity<>(new Mensaje("paciente actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable("id") int id){
        if(!pacienteService.existById(id)){
            return new ResponseEntity<>(new Mensaje("Este paciente no existe"), HttpStatus.NOT_FOUND);
        }
        pacienteService.deletePaciente(id);
        return new ResponseEntity<>(new Mensaje("Paciente eliminado"), HttpStatus.OK);
    }
}
