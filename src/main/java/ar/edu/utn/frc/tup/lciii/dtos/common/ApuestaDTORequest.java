package ar.edu.utn.frc.tup.lciii.dtos.common;

import lombok.Data;

@Data
public class ApuestaDTORequest {
    private String fecha_sorteo;
    private String id_cliente;
    private String numero;
    private int montoApostado;
}