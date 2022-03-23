package com.viajesInterdep.viajesInterdep.Controller;

import com.viajesInterdep.viajesInterdep.Clases.Viajes;
import com.viajesInterdep.viajesInterdep.Service.ViajeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ViajesController {

    @Autowired
   private final ViajeService viajeService;

    public ViajesController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping(value="/listarViajes")
    public ResponseEntity<List<Viajes>> listaViajes() { // Para futuro uso ---> @PathVariable("id") Long id donde @GetMapping("/{id}"
        List<Viajes> listaViajes = viajeService.listarViajes();
        return new ResponseEntity<>(listaViajes, HttpStatus.OK);
    }

    @PostMapping(value="/crearViaje")
    public ResponseEntity<String> crearViaje(@RequestBody Viajes viaje) throws NotFoundException {
        String respuesta = viajeService.crearViaje(viaje);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping(value="/{viajeId}")
    public void borrarViaje(@PathVariable("viajeId") Long viajeId){
        viajeService.borrarViaje(viajeId);

    }
}
