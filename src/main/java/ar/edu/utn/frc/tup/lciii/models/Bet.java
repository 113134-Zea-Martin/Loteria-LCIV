package ar.edu.utn.frc.tup.lciii.models;

import lombok.Data;

@Data
public class Bet {
    private Long id;
    private String fecha_sorteo;
    private String id_cliente;
    private String numero;
    private int montoApostado;
    private Lottery lottery;
    private String resultado;
}