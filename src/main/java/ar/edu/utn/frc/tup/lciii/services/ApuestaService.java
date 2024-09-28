package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.common.ApuestaDTORequest;
import ar.edu.utn.frc.tup.lciii.dtos.common.ApuestaDTOResponse;
import ar.edu.utn.frc.tup.lciii.dtos.common.InformacionApuestasGanadasDto;
import ar.edu.utn.frc.tup.lciii.dtos.common.InformacionSorteo;
import org.springframework.stereotype.Service;

@Service
public interface ApuestaService {
    ApuestaDTOResponse createApuesta(ApuestaDTORequest apuestaDTORequest);
    InformacionSorteo ObtenerInformacionSorteo(int id_sorteo);
    InformacionApuestasGanadasDto ObtenerInformacionApuestasGanadas(int id_sorteo);
}
