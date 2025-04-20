package com.energiainteligente.monitoring.persistencia.repositorio;

import com.energiainteligente.monitoring.persistencia.modelo.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepositorio extends JpaRepository<Alerta, Long> {
}
