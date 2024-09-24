package ar.edu.utn.frc.tup.lciii.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class InfoLottery {
    private Long id_sorteo;
    private String fecha_sorteo;
    private int totalEnReserva;
    private List<Map.Entry<Integer, Integer>> numerosSorteados;
}
