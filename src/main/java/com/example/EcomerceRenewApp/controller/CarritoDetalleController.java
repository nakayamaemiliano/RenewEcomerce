package com.example.EcomerceRenewApp.controller;

import com.example.EcomerceRenewApp.models.CarritoDetalle;
import com.example.EcomerceRenewApp.services.CarritoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carrito-detalles")
public class CarritoDetalleController {
    @Autowired
    private CarritoDetalleService carritoDetalleService;

    @PostMapping
    public ResponseEntity<CarritoDetalle> guardarCarritoDetalle(@RequestBody CarritoDetalle carritoDetalle) {
        return ResponseEntity.ok(carritoDetalleService.guardarCarritoDetalle(carritoDetalle));
    }

    @GetMapping
    public ResponseEntity<List<CarritoDetalle>> obtenerTodosCarritoDetalles() {
        return ResponseEntity.ok(carritoDetalleService.obtenerTodosCarritoDetalles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoDetalle> obtenerCarritoDetallePorId(@PathVariable Long id) {
        return ResponseEntity.ok(carritoDetalleService.obtenerCarritoDetallePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoDetalle> actualizarCarritoDetalle(@PathVariable Long id, @RequestBody CarritoDetalle carritoDetalleActualizado) {
        return ResponseEntity.ok(carritoDetalleService.actualizarCarritoDetalle(id, carritoDetalleActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarritoDetalle(@PathVariable Long id) {
        carritoDetalleService.eliminarCarritoDetalle(id);
        return ResponseEntity.noContent().build();
    }

}
