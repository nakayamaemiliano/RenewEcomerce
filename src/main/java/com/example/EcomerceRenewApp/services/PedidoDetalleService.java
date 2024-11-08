package com.example.EcomerceRenewApp.services;

import com.example.EcomerceRenewApp.exceptions.ResourceNotFoundException;
import com.example.EcomerceRenewApp.models.PedidoDetalle;
import com.example.EcomerceRenewApp.repository.PedidoDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoDetalleService {
    @Autowired
    private PedidoDetalleRepository pedidoDetalleRepository;

    public PedidoDetalle guardarPedidoDetalle(PedidoDetalle pedidoDetalle) {
        return pedidoDetalleRepository.save(pedidoDetalle);
    }

    public List<PedidoDetalle> obtenerTodosPedidoDetalles() {
        return pedidoDetalleRepository.findAll();
    }

    public PedidoDetalle obtenerPedidoDetallePorId(Long id) {
        return pedidoDetalleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PedidoDetalle no encontrado con ID: " + id));
    }

    public PedidoDetalle actualizarPedidoDetalle(Long id, PedidoDetalle pedidoDetalleActualizado) {
        PedidoDetalle pedidoDetalle = obtenerPedidoDetallePorId(id);
        pedidoDetalle.setCantidad(pedidoDetalleActualizado.getCantidad());
        pedidoDetalle.setSubtotal(pedidoDetalleActualizado.getSubtotal());
        return pedidoDetalleRepository.save(pedidoDetalle);
    }

    public void eliminarPedidoDetalle(Long id) {
        PedidoDetalle pedidoDetalle = obtenerPedidoDetallePorId(id);
        pedidoDetalleRepository.delete(pedidoDetalle);
    }

}
