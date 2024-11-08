package com.example.EcomerceRenewApp.controller;

import com.example.EcomerceRenewApp.models.Vinilo;
import com.example.EcomerceRenewApp.services.ViniloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vinilos")
public class ViniloControler {
    @Autowired
    private ViniloService viniloService;

    @PostMapping
    public ResponseEntity<Vinilo> guardarVinilo(@RequestBody Vinilo vinilo) {
        return ResponseEntity.ok(viniloService.guardarVinilo(vinilo));
    }

    @GetMapping
    public ResponseEntity<List<Vinilo>> obtenerTodosVinilos() {
        return ResponseEntity.ok(viniloService.obtenerTodosVinilos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vinilo> obtenerViniloPorId(@PathVariable Long id) {
        return ResponseEntity.ok(viniloService.obtenerViniloPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vinilo> actualizarVinilo(@PathVariable Long id, @RequestBody Vinilo viniloActualizado) {
        return ResponseEntity.ok(viniloService.actualizarVinilo(id, viniloActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVinilo(@PathVariable Long id) {
        viniloService.eliminarVinilo(id);
        return ResponseEntity.noContent().build();
    }
}
