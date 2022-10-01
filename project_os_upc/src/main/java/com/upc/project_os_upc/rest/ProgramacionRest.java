package com.upc.project_os_upc.rest;

import com.upc.project_os_upc.adapter.ProgramacionAdapter;
import com.upc.project_os_upc.dto.ProgramacionDTO;
import com.upc.project_os_upc.service.ProgramacionService;
import com.upc.project_os_upc.entity.Programacion;
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
public class ProgramacionRest {

    private final Logger logger = LoggerFactory.getLogger(ProgramacionRest.class);

    @Autowired
    public ProgramacionService programacionService;

    @Autowired
    public ProgramacionAdapter adapter;

    @GetMapping("/programacion")
    public ResponseEntity<?> obtenerProgramaciones(){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo Lista de programaciones");
            List<ProgramacionDTO> dto = programacionService.findAll()
                    .stream()
                    .map(x->adapter.toProgramacionDTO(x))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(dto,HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener los programaciones");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/programacion/{id}")
    public ResponseEntity<?> obtenerProgramacion(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo programacion");
            Programacion programacion = programacionService.findById(id);
            if(programacion != null){
                ProgramacionDTO dto = adapter.toProgramacionDTO(programacion);
                return new ResponseEntity<>(dto,HttpStatus.OK);
            } else{
                logger.debug("No se encontro la programacion");
                response.put(Constants.RESPONSE_FIELD_MESSAGE,"No se encontro una programacion");
                return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener la programacion");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
