package com.example.EcomerceRenewApp.controller;

import com.example.EcomerceRenewApp.models.PedidoDetalle;
import com.example.EcomerceRenewApp.services.PedidoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido-detalles")
public class PedidoDetalleController {
    @Autowired
    private PedidoDetalleService pedidoDetalleService;

    @PostMapping
    public ResponseEntity<PedidoDetalle> guardarPedidoDetalle(@RequestBody PedidoDetalle pedidoDetalle) {
        return ResponseEntity.ok(pedidoDetalleService.guardarPedidoDetalle(pedidoDetalle));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDetalle>> obtenerTodosPedidoDetalles() {
        return ResponseEntity.ok(pedidoDetalleService.obtenerTodosPedidoDetalles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDetalle> obtenerPedidoDetallePorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoDetalleService.obtenerPedidoDetallePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDetalle> actualizarPedidoDetalle(@PathVariable Long id, @RequestBody PedidoDetalle pedidoDetalleActualizado) {
        return ResponseEntity.ok(pedidoDetalleService.actualizarPedidoDetalle(id, pedidoDetalleActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedidoDetalle(@PathVariable Long id) {
        pedidoDetalleService.eliminarPedidoDetalle(id);
        return ResponseEntity.noContent().build();
    }
}
