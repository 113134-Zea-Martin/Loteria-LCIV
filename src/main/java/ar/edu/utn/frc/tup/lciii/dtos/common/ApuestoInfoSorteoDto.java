package ar.edu.utn.frc.tup.lciii.dtos.common;

import lombok.Data;

@Data
public class ApuestoInfoSorteoDto {
    private String id_cliente;
    private String numero;
    private String resultado;
    private int montoApostado;
    private int premio;
}
