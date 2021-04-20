package com.viajesInterdep.viajesInterdep.Controller;

import com.viajesInterdep.viajesInterdep.Clases.Departamento;
import com.viajesInterdep.viajesInterdep.Service.DepartamentoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class DepartamentoController {

    @Autowired
   private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @RequestMapping(value="/listar" , method= RequestMethod.GET)
    public ResponseEntity<List<Departamento>> listaDepartamentos() { // Para futuro uso ---> @PathVariable("id") Long id donde @GetMapping("/{id}"
        List<Departamento> listaDepartamentos = departamentoService.findAll();
        return new ResponseEntity<>(listaDepartamentos, HttpStatus.OK);
    }

    @RequestMapping(value="/crear",method= RequestMethod.POST)
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento depto) throws NotFoundException {
        Departamento newDepartamento = departamentoService.crearDepartamento(depto);
        return new ResponseEntity<>(newDepartamento, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public void borrarDepartamento(@PathVariable("id") Long id){
        departamentoService.borrarDepartamento(id);
    }
}
