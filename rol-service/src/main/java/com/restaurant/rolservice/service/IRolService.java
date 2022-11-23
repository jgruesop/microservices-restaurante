package com.restaurant.rolservice.service;

import com.restaurant.rolservice.entity.Rol;

import java.util.List;
public interface IRolService {

    List<Rol> listarRoles();

    Rol guardar(Rol rol);

    Rol findById(Integer id);
}
