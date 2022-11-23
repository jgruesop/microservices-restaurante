package com.restaurant.reservaservice.service;

import com.restaurant.reservaservice.entity.Reserva;
import com.restaurant.reservaservice.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
public interface IReservaService {

    public List<Reserva> listarReservas();
    Reserva guardar(Reserva reserva);
    Reserva findById(Integer id);
}
