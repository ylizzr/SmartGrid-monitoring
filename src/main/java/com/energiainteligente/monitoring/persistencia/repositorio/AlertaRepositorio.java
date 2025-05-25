package com.energiainteligente.monitoring.persistencia.repositorio;

import com.energiainteligente.monitoring.persistencia.modelo.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

public interface AlertaRepositorio extends JpaRepository<Alerta, Long> {
    List<Alerta> findByIdDispositivo(UUID dispositivoId);
}