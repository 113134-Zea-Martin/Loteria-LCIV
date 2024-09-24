package ar.edu.utn.frc.tup.lciii.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sorteos")
public class numerosSorteadosPorFecha {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public ResponseEntity<Object> getSorteadosPorFecha(@RequestParam String fecha) {
        Object object = restTemplate.getForObject("http://localhost:8080/sorteos?fecha=" + fecha, Object.class);
        return ResponseEntity.ok(object);
    }
}
