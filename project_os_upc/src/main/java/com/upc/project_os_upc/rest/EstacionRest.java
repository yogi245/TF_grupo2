package com.upc.project_os_upc.rest;

import com.upc.project_os_upc.adapter.EstacionAdapter;
import com.upc.project_os_upc.dto.EstacionDTO;
import com.upc.project_os_upc.service.EstacionService;
import com.upc.project_os_upc.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EstacionRest {

    private final Logger logger = LoggerFactory.getLogger(EstacionRest.class);

    @Autowired
    public EstacionService estacionService;

    @Autowired
    public EstacionAdapter adapter;

    @GetMapping("/estacion")
    public ResponseEntity<?> obtenerEstaciones(){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo Lista de estaciones");
            List<EstacionDTO> dto = estacionService.findAll()
                    .stream()
                    .map(x->adapter.toEstacionDTO(x))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener las estaciones");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
