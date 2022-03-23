package com.viajesInterdep.viajesInterdep.Service;

import com.viajesInterdep.viajesInterdep.Clases.Viajes;
import com.viajesInterdep.viajesInterdep.Repository.ViajeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    ViajeRepository viajeRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String crearViaje(Viajes viaje) throws NotFoundException {
        try{
            viajeRepository.save(viaje);
            return "Viaje creado correctamente";
        }catch (Exception e ){
            return e + " . El viaje no pudo ser creado";
        }

    }

    @GetMapping
    public List<Viajes> listarViajes(){
       return (List<Viajes>)viajeRepository.findAll();
    }

    @DeleteMapping
    public void borrarViaje(Long id){
        viajeRepository.deleteById(id);
    }
}
