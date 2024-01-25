package com.app.clinicaZeroBackend.controller;

import com.app.clinicaZeroBackend.dto.DienteDto;
import com.app.clinicaZeroBackend.dto.Mensaje;
import com.app.clinicaZeroBackend.entity.Diente;
import com.app.clinicaZeroBackend.service.DienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diente")
@CrossOrigin(origins = "http://localhost:4200")
public class DienteController {
    @Autowired
    DienteService dienteService;
    @GetMapping("/listar")
    public ResponseEntity<List<Diente>> listDiente(){
        List<Diente> dientes = dienteService.list();
        return new ResponseEntity<>(dientes, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Diente> getDienteById(@PathVariable("id") int id){
        if(!dienteService.existById(id)){
            return new ResponseEntity(new Mensaje("El diente no existe"), HttpStatus.NOT_FOUND);
        }else{
            Diente diente = dienteService.getById(id).get();
            return new ResponseEntity<>(diente, HttpStatus.OK);
        }
    }
    @GetMapping("/detail/name/{nombre}")
    public ResponseEntity<Diente> getDienteByNombre(@PathVariable("nombre") String nombre){
        if (!dienteService.existByNombre(nombre)){
            return new ResponseEntity(new Mensaje("El diente no existe"), HttpStatus.NOT_FOUND);
        }else{
            Diente diente = dienteService.getByNombre(nombre).get();
            return new ResponseEntity<>(diente, HttpStatus.OK);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createDiente(@RequestBody DienteDto dienteDto){

        Diente diente = new Diente(
                dienteDto.getNombre(),
                dienteDto.getNumero(),
                dienteDto.getPosicion(),
                dienteDto.getEstado(),
                dienteDto.getDescripcion(),
                dienteDto.getCosto(),
                dienteDto.getOdontograma(),
                dienteDto.getTipoTratamientos()
        );

        dienteService.create(diente);
        return new ResponseEntity<>(new Mensaje("diente creado exitosamente"), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDiente(@PathVariable("id") int id, @RequestBody DienteDto dienteDto){

        if(!dienteService.existById(id)){
            return new ResponseEntity<>(new Mensaje("este diente no existe"), HttpStatus.NOT_FOUND);
        }

        Diente diente = dienteService.getById(id).get();
        diente.setNombre(dienteDto.getNombre());
        diente.setNumero(dienteDto.getNumero());
        diente.setPosicion(dienteDto.getPosicion());
        diente.setEstado(dienteDto.getEstado());
        diente.setDescripcion(dienteDto.getDescripcion());
        diente.setCosto(dienteDto.getCosto());
        diente.setOdontograma(dienteDto.getOdontograma());
        diente.setTipoTratamientos(diente.getTipoTratamientos());

        dienteService.create(diente);
        return new ResponseEntity<>(new Mensaje("diente actualizado"), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteDiente(@PathVariable("id") int id){
        if(!dienteService.existById(id)){
            return new ResponseEntity<>(new Mensaje("este diente no existe"), HttpStatus.NOT_FOUND);
        }

        dienteService.delete(id);
        return new ResponseEntity<>(new Mensaje("diente eliminado"), HttpStatus.OK);
    }
}
