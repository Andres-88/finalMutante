package com.example.final_mercado_libre.controllers;

import com.example.final_mercado_libre.entities.Mutante;
import com.example.final_mercado_libre.services.MutanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/mutant")
public class MutanteController {

    private MutanteService mutanteService;

    public MutanteController(MutanteService mutanteService){    //Inyección de dependencia
        this.mutanteService = mutanteService;
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Mutante entity) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mutanteService.save(entity));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error. Por favor inténtelo más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mutanteService.delete(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error. Por favor inténtelo más tarde\"}");
        }
    }
}
