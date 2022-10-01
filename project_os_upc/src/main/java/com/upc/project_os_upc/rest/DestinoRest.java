package com.upc.project_os_upc.rest;

import com.upc.project_os_upc.adapter.DestinoAdapter;
import com.upc.project_os_upc.dto.DestinoDTO;
import com.upc.project_os_upc.service.DestinoService;
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
public class DestinoRest {

    private final Logger logger = LoggerFactory.getLogger(DestinoRest.class);
    @Autowired
    public DestinoService destinoService;

    @Autowired
    public DestinoAdapter adapter;

    @GetMapping("/destino")
    public ResponseEntity<?> obtenerDestinos(){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo Lista de destinos");
            List<DestinoDTO> dto = destinoService.findAll()
                    .stream()
                    .map(x->adapter.toDestinoDTO(x))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(dto,HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener los destinos");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
