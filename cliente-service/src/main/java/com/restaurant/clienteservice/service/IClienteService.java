package com.restaurant.clienteservice.service;

import com.restaurant.clienteservice.entity.Cliente;
import com.restaurant.clienteservice.model.Reserva;
import com.restaurant.clienteservice.model.Rol;

import java.util.ArrayList;
import java.util.List;
public interface IClienteService {

    List<Cliente> listarClientes();
    Cliente guardar(Cliente cliente);
    Cliente findById(int id);
    Reserva obtenerReservas(int id);
    Rol obtenerRoles(int id);

}
