package com.viajesInterdep.viajesInterdep.Controller;

import com.viajesInterdep.viajesInterdep.Clases.Ventas;
import com.viajesInterdep.viajesInterdep.Service.VentasService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class VentasController {

    @Autowired
   private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping(value="/listarVentas")
    public ResponseEntity<List<Ventas>> listaVentas() { // Para futuro uso ---> @PathVariable("id") Long id donde @GetMapping("/{id}"
        List<Ventas> listarVentas = ventasService.listarVentas();
        return new ResponseEntity<>(listarVentas, HttpStatus.OK);
    }

    @PostMapping(value="/crearVenta")
    public ResponseEntity<String> crearVenta(@RequestBody Ventas venta) throws NotFoundException {
        String respuesta = ventasService.crearVenta(venta);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @DeleteMapping(value="/{ventaId}")
    public void borrarVenta(@PathVariable("ventaId") Long ventaId){
        ventasService.borrarVenta(ventaId);

    }
}
