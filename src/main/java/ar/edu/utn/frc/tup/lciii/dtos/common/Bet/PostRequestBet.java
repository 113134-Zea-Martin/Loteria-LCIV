package ar.edu.utn.frc.tup.lciii.dtos.common.Bet;

import ar.edu.utn.frc.tup.lciii.models.Bet;
import lombok.Data;

@Data
public class PostRequestBet {
/*    {
        "fecha_sorteo": "2024-12-25",
            "id_cliente": "Lorem Ipsum",
            "numero": "56789",
            "montoApostado": 100
    }  ```*/
    private String fecha_sorteo;
    private String id_cliente;
    private String numero;
    private int montoApostado;
}
