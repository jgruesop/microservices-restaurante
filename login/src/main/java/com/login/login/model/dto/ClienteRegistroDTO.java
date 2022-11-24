package com.login.login.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class ClienteRegistroDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    public ClienteRegistroDTO(String email) {
        super();
        this.email = email;
    }

    public ClienteRegistroDTO(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }
}
