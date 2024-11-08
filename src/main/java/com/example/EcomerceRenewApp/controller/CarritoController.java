package com.example.EcomerceRenewApp.controller;

import com.example.EcomerceRenewApp.models.Carrito;
import com.example.EcomerceRenewApp.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carritos")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @PostMapping
    public ResponseEntity<Carrito> guardarCarrito(@RequestBody Carrito carrito) {
        return ResponseEntity.ok(carritoService.guardarCarrito(carrito));
    }

    @GetMapping
    public ResponseEntity<List<Carrito>> obtenerTodosCarritos() {
        return ResponseEntity.ok(carritoService.obtenerTodosCarritos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarritoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(carritoService.obtenerCarritoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long id, @RequestBody Carrito carritoActualizado) {
        return ResponseEntity.ok(carritoService.actualizarCarrito(id, carritoActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}
