package com.energiainteligente.monitoring.controladores;

import com.energiainteligente.monitoring.persistencia.modelo.Alerta;
import com.energiainteligente.monitoring.servicios.AlertaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerta")
public class AlertaControlador {


    private final AlertaServicio alertarServicio;

    public AlertaControlador(AlertaServicio alertarServicio) {
        this.alertarServicio = alertarServicio;
    }

    @PostMapping("/registrar")
    public Alerta registrar(@RequestBody Alerta alerta) {
        return alertarServicio.guardar(alerta);
    }

    @GetMapping
    public List<Alerta> findAll() {
        return alertarServicio.findAll();
    }

    @GetMapping("/{id}")
    public Alerta buscarPorId(@PathVariable Long id) {
        return alertarServicio.buscarPorId(id);
    }
}
