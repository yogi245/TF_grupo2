package com.upc.project_os_upc.rest;

import com.upc.project_os_upc.adapter.UsuarioAdapter;
import com.upc.project_os_upc.dto.UsuarioDTO;
import com.upc.project_os_upc.dto.UsuarioReservasDTO;
import com.upc.project_os_upc.entity.Usuario;
import com.upc.project_os_upc.service.UsuarioService;
import com.upc.project_os_upc.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioRest {

    private final Logger logger = LoggerFactory.getLogger(UsuarioRest.class);
    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    UsuarioAdapter adapter;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo usuario");
            Usuario usuario = usuarioService.findById(id);
            if(usuario != null){
                UsuarioDTO dto = adapter.toUsuarioDTO(usuario);
                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else{
                logger.debug("No se encontro el usuario en bd");
                response.put(Constants.RESPONSE_FIELD_MESSAGE,"No se encontro el usuario");
                return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener el usuario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario-reservas/{id}")
    public ResponseEntity<?> obtenerUsuarioReservas(@PathVariable("id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Obteniendo usuario reservas");
            Usuario usuario = usuarioService.findById(id);
            if(usuario != null){
                UsuarioReservasDTO dto = adapter.toUsuarioReservasDTO(usuario);
                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else{
                logger.debug("No se encontro el usuario-reservas en bd");
                response.put(Constants.RESPONSE_FIELD_MESSAGE,"No se encontro las reservas del usuario");
                return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de obtener el usuario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
