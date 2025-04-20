package com.energiainteligente.monitoring.persistencia.modelo;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class estadoDispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_dispositivo")
    private dispositivo dispositivo;

    private double voltaje;
    private double corriente;
    private double energiaEntrante;
    private double energiaSaliente;
    private double porcentajeAlmacenamiento;

    private LocalDateTime fechaHora;
}
