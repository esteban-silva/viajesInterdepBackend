package com.viajesInterdep.viajesInterdep.Controller;

import com.viajesInterdep.viajesInterdep.Clases.Departamento;
import com.viajesInterdep.viajesInterdep.Service.DepartamentoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartamentoController {

    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/departamentos")
    public ResponseEntity<List<Departamento>> getDepartamento() {
        return ResponseEntity.status(HttpStatus.OK).body(departamentoService.findAll());
    }

    @PostMapping("/departamentos")
    public ResponseEntity<Departamento> postDepartamento(@RequestBody Departamento depto) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.crearDepartamento(depto));
    }
}
