package com.restaurant.rolservice.controller;

import com.restaurant.rolservice.entity.Rol;
import com.restaurant.rolservice.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService iRolService;

    @GetMapping
    public ResponseEntity<List<Rol>> listarRol(@RequestParam(name = "id", required = false) Integer id) {
        List<Rol> roles = new ArrayList<>();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findById(@PathVariable("id") int id){
        Rol rol = iRolService.findById(id);
        if(rol == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crearRol(@RequestBody Rol rol) {
        iRolService.guardar(rol);
    }
}
