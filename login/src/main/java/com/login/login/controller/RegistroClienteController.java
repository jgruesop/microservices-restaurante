package com.login.login.controller;

import com.login.login.model.dto.ClienteRegistroDTO;
import com.login.login.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/registro")
public class RegistroClienteController {
    
    @Autowired
    private IClienteService clienteService;

    @ModelAttribute("cliente")
    public ClienteRegistroDTO retornarNuevoClienteDTO() {
        return new ClienteRegistroDTO();
    }

    @GetMapping()
    public String formularioRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCliente(@ModelAttribute("cliente") ClienteRegistroDTO clienteRegistroDTO) {
        clienteService.registrar(clienteRegistroDTO);
        return "redirect:/registro?ok";
    }

}
