package com.login.login.service;

import com.login.login.model.dto.ClienteRegistroDTO;
import com.login.login.model.entity.Cliente;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface IClienteService extends UserDetailsService {

    Cliente registrar(ClienteRegistroDTO registroDTO);
}
