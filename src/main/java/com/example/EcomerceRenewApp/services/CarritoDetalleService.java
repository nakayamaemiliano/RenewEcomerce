package com.example.EcomerceRenewApp.services;

import com.example.EcomerceRenewApp.exceptions.ResourceNotFoundException;
import com.example.EcomerceRenewApp.models.CarritoDetalle;
import com.example.EcomerceRenewApp.repository.CarritoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoDetalleService {
    @Autowired
    private CarritoDetalleRepository carritoDetalleRepository;

    public CarritoDetalle guardarCarritoDetalle(CarritoDetalle carritoDetalle) {
        return carritoDetalleRepository.save(carritoDetalle);
    }

    public List<CarritoDetalle> obtenerTodosCarritoDetalles() {
        return carritoDetalleRepository.findAll();
    }

    public CarritoDetalle obtenerCarritoDetallePorId(Long id) {
        return carritoDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CarritoDetalle no encontrado con ID: " + id));
    }

    public CarritoDetalle actualizarCarritoDetalle(Long id, CarritoDetalle carritoDetalleActualizado) {
        CarritoDetalle carritoDetalle = obtenerCarritoDetallePorId(id);
        carritoDetalle.setCantidad(carritoDetalleActualizado.getCantidad());
        carritoDetalle.setSubtotal(carritoDetalleActualizado.getSubtotal());
        return carritoDetalleRepository.save(carritoDetalle);
    }

    public void eliminarCarritoDetalle(Long id) {
        CarritoDetalle carritoDetalle = obtenerCarritoDetallePorId(id);
        carritoDetalleRepository.delete(carritoDetalle);
    }
}
