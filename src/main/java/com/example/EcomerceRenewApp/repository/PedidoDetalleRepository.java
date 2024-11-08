package com.example.EcomerceRenewApp.repository;

import com.example.EcomerceRenewApp.models.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle,Long> {

}
