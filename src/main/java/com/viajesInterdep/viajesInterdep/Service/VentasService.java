package com.viajesInterdep.viajesInterdep.Service;

import com.viajesInterdep.viajesInterdep.Clases.Ventas;
import com.viajesInterdep.viajesInterdep.Repository.VentasRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class VentasService {

    @Autowired
    VentasRepository ventasRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String crearVenta(Ventas venta) throws NotFoundException {
        try{
            ventasRepository.save(venta);
            return "Venta creado correctamente";
        }catch (Exception e ){
            return e + " . La Venta no pudo ser creado";
        }

    }

    @GetMapping
    public List<Ventas> listarVentas(){
       return (List<Ventas>)ventasRepository.findAll();
    }

    @DeleteMapping
    public void borrarVenta(Long id){
        ventasRepository.deleteById(id);
    }
}
