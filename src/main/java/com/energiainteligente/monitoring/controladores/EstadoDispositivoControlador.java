package com.energiainteligente.monitoring.controladores;

import com.energiainteligente.monitoring.persistencia.modelo.estadoDispositivo;
import com.energiainteligente.monitoring.servicios.EstadoDispositivoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
@CrossOrigin(origins = "*")
public class EstadoDispositivoControlador {

    @Autowired
    private EstadoDispositivoServicio servicio;

    @PostMapping("/registrar")
    public estadoDispositivo registrar(@RequestBody estadoDispositivo estado) {
        return servicio.guardar(estado);
    }

    @GetMapping("/todos")
    public List<estadoDispositivo> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/dispositivo/{id}")
    public List<estadoDispositivo> obtenerPorDispositivo(@PathVariable String id) {
        return servicio.obtenerPorDispositivo(id);
    }
}

