package com.energiainteligente.monitoring.servicios;


import com.energiainteligente.monitoring.persistencia.modelo.dispositivo;
import com.energiainteligente.monitoring.persistencia.repositorio.dispositivoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoServicio {

    @Autowired
    private dispositivoRepositorio repositorio;

    public dispositivo guardar(dispositivo dispositivo) {
        return repositorio.save(dispositivo);
    }

    public List<dispositivo> listarTodos() {
        return repositorio.findAll();
    }

    public dispositivo buscarPorId(String id) {
        return repositorio.findById(id).orElse(null);
    }
}
