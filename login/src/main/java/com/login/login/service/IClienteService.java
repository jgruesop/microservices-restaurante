package com.login.login.service;

import com.login.login.model.dto.ClienteRegistroDTO;
import com.login.login.model.entity.Cliente;
import org.springframework.stereotype.Service;

public interface IClienteService {

    Cliente registrar(ClienteRegistroDTO registroDTO);
}
