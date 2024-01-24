package com.app.clinicaZeroBackend.controller;

import com.app.clinicaZeroBackend.dto.ConsultaDto;
import com.app.clinicaZeroBackend.dto.Mensaje;
import com.app.clinicaZeroBackend.entity.Consulta;
import com.app.clinicaZeroBackend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/consulta")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;
    @GetMapping("/listar")
    public ResponseEntity<List<Consulta>> listConsulta(){
        List<Consulta> list = consultaService.listConsulta();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable("id") int id){
        if(!consultaService.existById(id)){
            return new ResponseEntity(new Mensaje("Esta consulta no existe"), HttpStatus.NOT_FOUND);
        }else {
            Consulta consulta = consultaService.getConsultaById(id).get();
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
    }
    @GetMapping("/detail/num/{numero}")
    public ResponseEntity<Consulta> getConsultaByNumero(@PathVariable("numero") int numero){
        if(!consultaService.existByNumero(numero)){
            return new ResponseEntity(new Mensaje("Esta consulta no existe"), HttpStatus.NOT_FOUND);
        }else {
            Consulta consulta = consultaService.getConsultaByNumero(numero).get();
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Mensaje> createConsulta(@RequestBody ConsultaDto consultaDto){
        if(consultaService.existByNumero(consultaDto.getNumero())){
            return new ResponseEntity<>(new Mensaje("Este numero de consulta ya existe"), HttpStatus.NOT_FOUND);
        }
        if(consultaDto.getNumero() != null && consultaDto.getNumero()>0){
            Consulta consulta = new Consulta(
                    consultaDto.getNumero(),
                    consultaDto.getFecha(),
                    consultaDto.getCosto()
            );
            consultaService.create(consulta);
            return new ResponseEntity<>(new Mensaje("consulta creado exitosamente"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Mensaje("El numero de consulta es obligatorio y mayor a 0"), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateConsulta(@PathVariable("id") int id, @RequestBody ConsultaDto consultaDto){
        if(!consultaService.existById(id)){
            return new ResponseEntity<>(new Mensaje("Esta consulta no existe"), HttpStatus.NOT_FOUND);
        }
        if(consultaDto.getNumero() != null && consultaDto.getNumero()>0){
            Consulta consulta = consultaService.getConsultaById(id).get();
            consulta.setNumero(consultaDto.getNumero());
            consulta.setFecha(consultaDto.getFecha());
            consulta.setCosto(consultaDto.getCosto());

            consultaService.create(consulta);
            return new ResponseEntity<>(new Mensaje("consulta actualizado exitosamente"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Mensaje("El numero de consulta es obligatorio y mayor a 0"), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteConsulta(@PathVariable("id") int id){
        if(!consultaService.existById(id)){
            return new ResponseEntity<>(new Mensaje("Esta consulta no existe"), HttpStatus.NOT_FOUND);
        }

        consultaService.delete(id);
        return new ResponseEntity<>(new Mensaje("Consulta eliminada"), HttpStatus.OK);
    }
}
