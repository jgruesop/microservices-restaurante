package com.restaurant.clienteservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    private String nombres;
    private String apellidos;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    private Integer identificacion;
    private String email;
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;
    @Column(name = "cantidad_personas")
    private int cantidadPersonas;
    private String descripcion;
    private String estado;
}
