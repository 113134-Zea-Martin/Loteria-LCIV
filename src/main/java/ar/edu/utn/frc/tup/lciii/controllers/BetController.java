package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.Bet.PostAnswerBet;
import ar.edu.utn.frc.tup.lciii.dtos.common.Bet.PostRequestBet;
import ar.edu.utn.frc.tup.lciii.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loteria")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping("/apuesta")
    private ResponseEntity<PostAnswerBet> createBet(@RequestBody PostRequestBet postRequestBet) {

        PostAnswerBet postAnswerBet = betService.createBet(postRequestBet);
        return ResponseEntity.ok(postAnswerBet);

    }

}
