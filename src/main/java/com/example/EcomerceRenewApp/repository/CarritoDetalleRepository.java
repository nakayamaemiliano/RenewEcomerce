package com.example.EcomerceRenewApp.repository;

import com.example.EcomerceRenewApp.models.CarritoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoDetalleRepository extends JpaRepository<CarritoDetalle,Long> {

}
