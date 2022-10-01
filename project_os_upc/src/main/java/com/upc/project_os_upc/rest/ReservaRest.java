package com.upc.project_os_upc.rest;

import com.upc.project_os_upc.adapter.ReservaAdapter;
import com.upc.project_os_upc.dto.ReservaDTO;
import com.upc.project_os_upc.entity.Reserva;
import com.upc.project_os_upc.service.ReservaService;
import com.upc.project_os_upc.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class ReservaRest {

    private final Logger logger = LoggerFactory.getLogger(ReservaRest.class);

    @Autowired
    public ReservaService reservaService;

    @Autowired
    public ReservaAdapter adapter;

    @GetMapping("/reserva")
    public ResponseEntity<?> obtenerReservas(){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo Lista de reservas");
            List<ReservaDTO> dto = reservaService.findAll()
                    .stream()
                    .map(x->adapter.toReservaDTO(x))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(dto,HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener las reservas");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reserva/{id}")
    public ResponseEntity<?> obtenerReserva(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo reserva");
            Reserva reserva = reservaService.findById(id);
            if(reserva != null){
                ReservaDTO dto = adapter.toReservaDTO(reserva);
                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else{
                logger.debug("No se encontro la reserva");
                response.put(Constants.RESPONSE_FIELD_MESSAGE,"No se encontro la reserva");
                return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener la reserva");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("/reserva")
    public ResponseEntity<?> guardarRerva(@RequestBody ReservaDTO dto){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Registrando reserva");
            dto.setFechaHora(new Date());
            Reserva reserva = adapter.toReservaEntity(dto);
            reservaService.save(reserva);
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Guardado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de registrar la reserva");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/reserva/{id}")
    public ResponseEntity<?> eliminarReserva(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Eliminando reserva");
            reservaService.deleteById(id);
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Se elimino la reserva");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de eliminar la reserva");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
