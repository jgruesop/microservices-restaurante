package com.login.login.service;

import com.login.login.model.dto.ClienteRegistroDTO;
import com.login.login.model.entity.Cliente;
import com.login.login.model.entity.Rol;
import com.login.login.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImplement implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Cliente registrar(ClienteRegistroDTO registroDTO) {
        Cliente cliente = new Cliente(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_ADMIN")));
        return clienteRepository.save(cliente);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new UsernameNotFoundException("Cliente o password incorrectos.");
        }
        return new User(cliente.getEmail(), cliente.getPassword(), maperaRoles(cliente.getRoles()));
    }

    private Collection<? extends GrantedAuthority> maperaRoles(Collection<Rol> roles) {
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
}
