package com.viajesInterdep.viajesInterdep.Controller;

import com.viajesInterdep.viajesInterdep.Service.ViajesService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ViajesController {

    @Autowired
   private final ViajesService viajesService;

    public ViajesController(ViajesService viajesService) {
        this.viajesService = viajesService;
    }

    @PostMapping(value="/crearViajes")
    public String crearViajes() throws NotFoundException {
        return viajesService.crearViajes();

    }
}
