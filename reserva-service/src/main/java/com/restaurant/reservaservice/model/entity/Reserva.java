package com.restaurant.reservaservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
