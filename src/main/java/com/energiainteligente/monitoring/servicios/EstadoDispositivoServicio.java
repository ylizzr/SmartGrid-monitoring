package com.energiainteligente.monitoring.servicios;

import com.energiainteligente.monitoring.persistencia.modelo.estadoDispositivo;
import com.energiainteligente.monitoring.persistencia.repositorio.estadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoDispositivoServicio {

    @Autowired
    private estadoRepositorio repositorio;

    public estadoDispositivo guardar(estadoDispositivo estado) {
        return repositorio.save(estado);
    }

    public List<estadoDispositivo> obtenerTodos() {
        return repositorio.findAll();
    }

    public List<estadoDispositivo> obtenerPorDispositivo(String idDispositivo) {
        return repositorio.findByDispositivo_Id(idDispositivo);
    }
}
