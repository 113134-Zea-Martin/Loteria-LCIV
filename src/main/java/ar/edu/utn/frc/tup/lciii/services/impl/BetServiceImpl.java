package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.dtos.common.Bet.PostAnswerBet;
import ar.edu.utn.frc.tup.lciii.dtos.common.Bet.PostRequestBet;
import ar.edu.utn.frc.tup.lciii.entities.BetEntity;
import ar.edu.utn.frc.tup.lciii.models.Bet;
import ar.edu.utn.frc.tup.lciii.models.InfoLottery;
import ar.edu.utn.frc.tup.lciii.models.Lottery;
import ar.edu.utn.frc.tup.lciii.repositories.BetRepository;
import ar.edu.utn.frc.tup.lciii.services.BetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetRepository betRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;

    private final String URL = "http://localhost:8080/sorteos?fecha=";

    public InfoLottery getSorteadosPorFecha(String fecha) {
        // Realiza la llamada y obtén la respuesta como ResponseEntity
        ResponseEntity<List<InfoLottery>> response = restTemplate.exchange(
                "http://localhost:8080/sorteos?fecha=" + fecha,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<InfoLottery>>() {}
        );

        // Verifica si la respuesta no está vacía y devuelve el primer elemento
        List<InfoLottery> sorteos = response.getBody();
        InfoLottery resultado = new InfoLottery();

        if (sorteos != null && !sorteos.isEmpty()) {
            resultado.setNumerosSorteados(sorteos.get(0).getNumerosSorteados());
        } else {
            resultado.setNumerosSorteados(Collections.emptyList()); // Devuelve una lista vacía si no hay resultados
        }

        return resultado; // Devuelve el objeto InfoLottery con solo los números sorteados
    }



    @Override
    public PostAnswerBet createBet(PostRequestBet postRequestBetDto) {
        Bet bet = new Bet();
        bet.setFecha_sorteo(postRequestBetDto.getFecha_sorteo());
        bet.setId_cliente(postRequestBetDto.getId_cliente());
        bet.setNumero(postRequestBetDto.getNumero());
        bet.setMontoApostado(postRequestBetDto.getMontoApostado());

        Lottery lottery = new Lottery();
        InfoLottery infoLottery = getSorteadosPorFecha(postRequestBetDto.getFecha_sorteo());
        lottery.setId_sorteo(infoLottery.getId_sorteo());

        bet.setLottery(lottery);
        bet.setResultado("PERDEDOR");

        if(coincidencias(postRequestBetDto.getNumero(),infoLottery.getNumerosSorteados())>0) {
            bet.setResultado("GANADOR");
        }

        BetEntity be= modelMapper.map(bet, BetEntity.class);
        betRepository.save(be);

        PostAnswerBet postAnswerBet = new PostAnswerBet();
        postAnswerBet.setId_sorteo(bet.getLottery().getId_sorteo().toString());
        postAnswerBet.setId_cliente(bet.getId_cliente());
        postAnswerBet.setNumero(bet.getNumero());
        postAnswerBet.setResultado(bet.getResultado());


        return postAnswerBet;
    }

    public int coincidencias(String numIngresado, List<Map.Entry<Integer, Integer>> numerosSorteados) {
        int maxCoincidencias = 0;

        char[] digitosIngresados = numIngresado.toCharArray();

        for (Map.Entry<Integer, Integer> entry : numerosSorteados) {
            String numeroSorteado = String.valueOf(entry.getValue());

            int coincidenciasActual = contarCoincidencias(digitosIngresados, numeroSorteado.toCharArray());

            if (coincidenciasActual > maxCoincidencias) {
                maxCoincidencias = coincidenciasActual;
            }
        }

        return maxCoincidencias;
    }

    private int contarCoincidencias(char[] digitosIngresados, char[] digitosSorteados) {
        int contador = 0;
        boolean[] coincidenciasContadas = new boolean[digitosSorteados.length];

        for (char digitoIngresado : digitosIngresados) {
            for (int i = 0; i < digitosSorteados.length; i++) {
                if (digitoIngresado == digitosSorteados[i] && !coincidenciasContadas[i]) {
                    contador++;
                    coincidenciasContadas[i] = true;
                    break;
                }
            }
        }
        return contador;
    }
}
