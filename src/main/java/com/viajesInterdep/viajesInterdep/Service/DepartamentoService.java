package com.viajesInterdep.viajesInterdep.Service;

import com.viajesInterdep.viajesInterdep.Clases.Departamento;
import com.viajesInterdep.viajesInterdep.Repository.DepartamentoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DepartamentoService {
    @Autowired DepartamentoRepository departamentoRepository;

    public Departamento crearDepartamento(Departamento depto) throws NotFoundException {
        if (depto.getDepartamentoNombre().isEmpty()) {
            throw new NotFoundException("No puede agregar un departamento sin nombre");
        }

        return departamentoRepository.save(depto);
    }


    public List<Departamento> findAll(){
       return (List<Departamento>) departamentoRepository.findAll();
    }
}
