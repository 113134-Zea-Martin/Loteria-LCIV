package ar.edu.utn.frc.tup.lciii.dtos.common.Bet;

import lombok.Data;

@Data
public class PostAnswerBet {
/*    {
        "id_sorteo": 123,
            "fecha_sorteo": "2024-12-25",
            "id_cliente": "Lorem Ipsum",
            "numero": "9876",
            "resultado": "GANADOR"
    }*/
    private String id_sorteo;
    private String fecha_sorteo;
    private String id_cliente;
    private String numero;
    private String resultado;
}
