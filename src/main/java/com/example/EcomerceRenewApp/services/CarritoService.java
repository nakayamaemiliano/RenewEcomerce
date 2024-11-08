package com.example.EcomerceRenewApp.services;

import com.example.EcomerceRenewApp.exceptions.ResourceNotFoundException;
import com.example.EcomerceRenewApp.models.Carrito;
import com.example.EcomerceRenewApp.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public Carrito guardarCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public List<Carrito> obtenerTodosCarritos() {
        return carritoRepository.findAll();
    }

    public Carrito obtenerCarritoPorId(Long id) {
        return carritoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado con ID: " + id));
    }

    public Carrito actualizarCarrito(Long id, Carrito carritoActualizado) {
        Carrito carrito = obtenerCarritoPorId(id);
        carrito.setTotal(carritoActualizado.getTotal());
        return carritoRepository.save(carrito);
    }

    public void eliminarCarrito(Long id) {
        Carrito carrito = obtenerCarritoPorId(id);
        carritoRepository.delete(carrito);
    }
}
