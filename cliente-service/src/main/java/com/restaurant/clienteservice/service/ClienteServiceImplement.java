package com.restaurant.clienteservice.service;

import com.restaurant.clienteservice.entity.Cliente;
import com.restaurant.clienteservice.model.Reserva;
import com.restaurant.clienteservice.model.Rol;
import com.restaurant.clienteservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClienteServiceImplement implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findById(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Reserva obtenerReservas(int id) {
        Reserva reservas = restTemplate.getForObject("http://localhost:8001/api/reserva/" + id, Reserva.class);
        return reservas;
    }

    public Rol obtenerRoles(int id) {
        Rol roles = restTemplate.getForObject("http://localhost:8002/api/rol/" + id, Rol.class);
        return roles;
    }
}
