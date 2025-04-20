package com.energiainteligente.monitoring.persistencia.repositorio;

import com.energiainteligente.monitoring.persistencia.modelo.dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dispositivoRepositorio extends JpaRepository<dispositivo, String> {
}
