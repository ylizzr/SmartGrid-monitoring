package com.energiainteligente.monitoring.persistencia.repositorio;

import com.energiainteligente.monitoring.persistencia.modelo.estadoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface estadoRepositorio extends JpaRepository<estadoDispositivo, Long> {
    List<estadoDispositivo> findByDispositivo_Id(String idDispositivo);
}
