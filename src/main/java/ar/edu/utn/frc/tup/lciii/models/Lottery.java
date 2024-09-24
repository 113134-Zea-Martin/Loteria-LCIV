package ar.edu.utn.frc.tup.lciii.models;

import lombok.Data;

@Data
public class Lottery {
    private Long id_sorteo;
    private String fecha_sorteo;
    private int totalEnReserva;
}