package com.viajesInterdep.viajesInterdep.Service;

import com.viajesInterdep.viajesInterdep.Clases.Departamento;
import com.viajesInterdep.viajesInterdep.Repository.DepartamentoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired DepartamentoRepository departamentoRepository;


    public Departamento crearDepartamento(String deptoNombre) throws NotFoundException {
        Departamento depto;

        if (deptoNombre.isEmpty()) {
            throw new NotFoundException("No puede agregar un departamento sin nombre");
        } else{
            depto = new Departamento();
            depto.setDepartamentoNombre(deptoNombre);
        }


        return departamentoRepository.save(depto);
    }

    @GetMapping
    public List<Departamento> findAll(){
       return (List<Departamento>) departamentoRepository.findAll();
    }

    @DeleteMapping
    public void borrarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }
}
