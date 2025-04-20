package com.energiainteligente.monitoring.persistencia.modelo;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class dispositivo {

    @Id
    private String id;

    private String tipo;        // Ej: poste, panel solar, turbina
    private String ubicacion;   // Ej: nombre o referencia del lugar
    private double latitud;
    private double longitud;

    private boolean activo;
}
