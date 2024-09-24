package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.common.Bet.PostAnswerBet;
import ar.edu.utn.frc.tup.lciii.dtos.common.Bet.PostRequestBet;
import org.springframework.stereotype.Service;

@Service
public interface BetService {
    PostAnswerBet createBet(PostRequestBet postRequestBetDto);
}
