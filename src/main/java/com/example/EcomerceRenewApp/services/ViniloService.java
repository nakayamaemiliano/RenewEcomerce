package com.example.EcomerceRenewApp.services;

import com.example.EcomerceRenewApp.exceptions.ResourceNotFoundException;
import com.example.EcomerceRenewApp.models.Vinilo;
import com.example.EcomerceRenewApp.repository.ViniloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViniloService {
    @Autowired
    private ViniloRepository viniloRepository;

    public Vinilo guardarVinilo(Vinilo vinilo) {
        return viniloRepository.save(vinilo);
    }

    public List<Vinilo> obtenerTodosVinilos() {
        return viniloRepository.findAll();
    }

    public Vinilo obtenerViniloPorId(Long id) {
        return viniloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vinilo no encontrado con ID: " + id));
    }

    public Vinilo actualizarVinilo(Long id, Vinilo viniloActualizado) {
        Vinilo vinilo = obtenerViniloPorId(id);
        vinilo.setNombre(viniloActualizado.getNombre());
        vinilo.setArtista(viniloActualizado.getArtista());
        vinilo.setDescripcion(viniloActualizado.getDescripcion());
        vinilo.setPrecio(viniloActualizado.getPrecio());
        vinilo.setStock(viniloActualizado.getStock());
        return viniloRepository.save(vinilo);
    }

    public void eliminarVinilo(Long id) {
        Vinilo vinilo = obtenerViniloPorId(id);
        viniloRepository.delete(vinilo);
    }


}
