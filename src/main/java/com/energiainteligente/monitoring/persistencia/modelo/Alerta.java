package com.energiainteligente.monitoring.persistencia.modelo;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "id_dispositivo", nullable = false)
    private UUID idDispositivo;

    @Column(name = "tipo_alerta", nullable = false)
    private String tipoAlerta;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nivel_severidad")
    private String nivelSeveridad;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "estado")
    private String estado;
}