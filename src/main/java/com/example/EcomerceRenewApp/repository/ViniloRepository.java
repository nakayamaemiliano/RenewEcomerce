package com.example.EcomerceRenewApp.repository;

import com.example.EcomerceRenewApp.models.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViniloRepository extends JpaRepository<Vinilo,Long> {

}
