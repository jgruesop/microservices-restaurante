package com.login.login.service;

import com.login.login.model.dto.ClienteRegistroDTO;
import com.login.login.model.entity.Cliente;
import com.login.login.model.entity.Rol;
import com.login.login.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClienteServiceImplement implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public Cliente registrar(ClienteRegistroDTO registroDTO) {
        Cliente cliente = new Cliente(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(),
                registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_ADMIN")));
        return clienteRepository.save(cliente);
    }
}
