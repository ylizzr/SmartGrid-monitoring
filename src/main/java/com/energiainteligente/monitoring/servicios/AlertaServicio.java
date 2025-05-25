package com.energiainteligente.monitoring.servicios;

import com.energiainteligente.monitoring.persistencia.modelo.Alerta;
import com.energiainteligente.monitoring.persistencia.repositorio.AlertaRepositorio;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AlertaServicio {

    private static final Logger log = LogManager.getLogger(AlertaServicio.class);

    private final AlertaRepositorio repositorio;

    public Alerta guardar(Alerta alerta) {
        try {
            return repositorio.save(alerta);
        } catch (Exception e) {
            log.error("Error al guardar alerta: {}", e.getMessage());
            throw new RuntimeException("Error al guardar alerta", e);
        }
    }

    public List<Alerta> findAll() {
        try {
            return repositorio.findAll();
        } catch (Exception e) {
            log.error("Error al obtener todas las alertas: {}", e.getMessage());
            throw new RuntimeException("Error al obtener alertas", e);
        }
    }

    public List<Alerta> buscarPorDispositivo(UUID dispositivoId) {
        try {
            return repositorio.findByIdDispositivo(dispositivoId);
        } catch (Exception e) {
            log.error("Error al buscar alertas por dispositivo {}: {}", dispositivoId, e.getMessage());
            throw new RuntimeException("Error al buscar alertas por dispositivo", e);
        }
    }

    public Alerta buscarPorId(Long id) {
        try {
            return repositorio.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error al buscar alerta por ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al buscar alerta", e);
        }
    }

    public Alerta actualizar(Long id, Alerta alertaActualizada) {
        try {
            return repositorio.findById(id)
                    .map(alertaExistente -> {
                        alertaActualizada.setId(id);
                        return repositorio.save(alertaActualizada);
                    })
                    .orElse(null);
        } catch (Exception e) {
            log.error("Error al actualizar alerta con ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al actualizar alerta", e);
        }
    }

    public boolean eliminarPorId(Long id) {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Error al eliminar alerta con ID {}: {}", id, e.getMessage());
            throw new RuntimeException("Error al eliminar alerta", e);
        }
    }
}