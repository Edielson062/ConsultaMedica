package com.senai.edielsonmariano.consultasmedicas.Controller;

import com.senai.edielsonmariano.consultasmedicas.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
}
