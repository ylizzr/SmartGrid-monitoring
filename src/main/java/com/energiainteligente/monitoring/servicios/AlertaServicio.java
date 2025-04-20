package com.energiainteligente.monitoring.servicios;


import com.energiainteligente.monitoring.persistencia.modelo.Alerta;
import com.energiainteligente.monitoring.persistencia.repositorio.AlertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaServicio {

    private final AlertaRepositorio repositorio;

    public AlertaServicio(AlertaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Alerta guardar(Alerta alerta) {
        return repositorio.save(alerta);
    }

    public List<Alerta> findAll() {
        return repositorio.findAll();
    }

    public Alerta buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }
}

