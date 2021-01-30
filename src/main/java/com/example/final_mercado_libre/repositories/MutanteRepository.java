package com.example.final_mercado_libre.repositories;

import com.example.final_mercado_libre.entities.Mutante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutanteRepository extends JpaRepository<Mutante, Long> {

}
