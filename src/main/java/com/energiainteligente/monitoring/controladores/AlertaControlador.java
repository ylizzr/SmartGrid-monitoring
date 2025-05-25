package com.energiainteligente.monitoring.controladores;

import com.energiainteligente.monitoring.persistencia.modelo.Alerta;
import com.energiainteligente.monitoring.servicios.AlertaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/alertas")
public class AlertaControlador {

    private final AlertaServicio alertaServicio;

    public AlertaControlador(AlertaServicio alertaServicio) {
        this.alertaServicio = alertaServicio;
    }

    @PostMapping
    public ResponseEntity<Alerta> crearAlerta(@RequestBody Alerta alerta) {
        Alerta nuevaAlerta = alertaServicio.guardar(alerta);
        return new ResponseEntity<>(nuevaAlerta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Alerta>> listarAlertas() {
        return ResponseEntity.ok(alertaServicio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> obtenerAlertaPorId(@PathVariable Long id) {
        Alerta alerta = alertaServicio.buscarPorId(id);
        return alerta != null ? ResponseEntity.ok(alerta) : ResponseEntity.notFound().build();
    }

    @GetMapping("/dispositivo/{dispositivoId}")
    public ResponseEntity<List<Alerta>> obtenerAlertasPorDispositivo(@PathVariable UUID dispositivoId) {
        List<Alerta> alertas = alertaServicio.buscarPorDispositivo(dispositivoId);
        return ResponseEntity.ok(alertas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> actualizarAlerta(@PathVariable Long id, @RequestBody Alerta alerta) {
        Alerta actualizada = alertaServicio.actualizar(id, alerta);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlerta(@PathVariable Long id) {
        boolean eliminado = alertaServicio.eliminarPorId(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}