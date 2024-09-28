package ar.edu.utn.frc.tup.lciii.dtos.common;

import lombok.Data;

import java.util.List;

@Data
public class InformacionSorteo {
    private int id_sorteo;
    private String fecha_sorteo;
    private List<ApuestoInfoSorteoDto> apuestoInfoSorteoDtos;
    private int totalEnReserva;
}
