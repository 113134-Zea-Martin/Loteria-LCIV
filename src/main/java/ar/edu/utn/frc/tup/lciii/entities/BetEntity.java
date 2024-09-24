package ar.edu.utn.frc.tup.lciii.entities;


import ar.edu.utn.frc.tup.lciii.models.Lottery;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bet")
public class BetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_sorteo", nullable = false)
    private String fechaSorteo;

    @Column(name = "id_cliente", nullable = false)
    private String idCliente;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "monto_apostado", nullable = false)
    private int montoApostado;

    // Relación con Lottery, usando @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lottery_id", referencedColumnName = "id_sorteo")
    private LotteryEntity lotteryEntity;

    @Column(name = "resultado", nullable = false)
    private String resultado;
}