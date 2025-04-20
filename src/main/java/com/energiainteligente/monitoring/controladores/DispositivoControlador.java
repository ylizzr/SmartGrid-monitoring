package com.energiainteligente.monitoring.controladores;

import com.energiainteligente.monitoring.persistencia.modelo.dispositivo;
import com.energiainteligente.monitoring.servicios.DispositivoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
@CrossOrigin(origins = "*")
public class DispositivoControlador {

    @Autowired
    private DispositivoServicio servicio;

    @PostMapping("/registrar")
    public dispositivo registrar(@RequestBody dispositivo dispositivo) {
        return servicio.guardar(dispositivo);
    }

    @GetMapping("/todos")
    public List<dispositivo> listarTodos() {
        return servicio.listarTodos();
    }

    @GetMapping("/{id}")
    public dispositivo buscarPorId(@PathVariable String id) {
        return servicio.buscarPorId(id);
    }
}
