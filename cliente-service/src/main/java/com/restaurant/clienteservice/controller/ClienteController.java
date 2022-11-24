package com.restaurant.clienteservice.controller;

import com.restaurant.clienteservice.model.entity.Cliente;
import com.restaurant.clienteservice.model.entity.Reserva;
import com.restaurant.clienteservice.model.entity.Rol;
import com.restaurant.clienteservice.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarCliente(@RequestParam(name = "id", required = false) Integer id) {
        List<Cliente> clientes = new ArrayList<>();
        if(id == null) {
            clientes = iClienteService.listarClientes();
        } else {
            if(clientes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") int id){
        Cliente cliente = iClienteService.findById(id);
        if(cliente == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<Reserva> obtenerReservas(@PathVariable("id") int id){
        Cliente cliente = iClienteService.findById(id);
        if(cliente == null)
            return ResponseEntity.notFound().build();
        Reserva reservas = iClienteService.obtenerReservas(id);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<Rol> obtenerRoles(@PathVariable("id") int id){
        Cliente cliente = iClienteService.findById(id);
        if(cliente == null)
            return ResponseEntity.notFound().build();
        Rol roles = iClienteService.obtenerRoles(id);
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crearCliente(@RequestBody Cliente cliente) {
        iClienteService.guardar(cliente);
    }

}
