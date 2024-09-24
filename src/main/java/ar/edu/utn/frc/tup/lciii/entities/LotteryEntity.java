package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lottery")
public class LotteryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sorteo")
    private Long idSorteo;

    @Column(name = "fecha_sorteo", nullable = false)
    private String fechaSorteo;

    @Column(name = "total_en_reserva", nullable = false)
    private int totalEnReserva;
}