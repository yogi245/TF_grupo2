package com.upc.project_os_upc.security.rest;

import com.upc.project_os_upc.adapter.NuevoUsuarioAdapter;
import com.upc.project_os_upc.adapter.UsuarioAdapter;
import com.upc.project_os_upc.dto.NuevoUsuarioDTO;
import com.upc.project_os_upc.dto.UsuarioDTO;
import com.upc.project_os_upc.entity.Usuario;
import com.upc.project_os_upc.security.JWTUtil;
import com.upc.project_os_upc.security.dto.AuthenticationRequest;
import com.upc.project_os_upc.security.dto.AuthenticationResponse;
import com.upc.project_os_upc.security.service.AppUserDetailsService;
import com.upc.project_os_upc.service.UsuarioService;
import com.upc.project_os_upc.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthRest {

    private final Logger logger = LoggerFactory.getLogger(AuthRest.class);
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    public NuevoUsuarioAdapter nuevoUsuarioAdapter;

    @Autowired
    public UsuarioAdapter usuarioAdapter;

    @Autowired
    public UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            logger.debug("Verificando Login");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = appUserDetailsService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Credenciales Incorrectas");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado durante el Login");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registroUsuario(@RequestBody NuevoUsuarioDTO dto){
        Map<String, Object> response = new HashMap<>();
        try{
            logger.debug("Registrando nuevo usuario");
            String password = dto.getContrasena();
            password = passwordEncoder.encode(password);
            dto.setContrasena(password);
            dto.setFechaRegistro(new Date());
            Usuario usuario = nuevoUsuarioAdapter.toUsuarioEntity(dto);
            Usuario usuarioCreado = usuarioService.save(usuario);
            UsuarioDTO usuarioDTO = usuarioAdapter.toUsuarioDTO(usuarioCreado);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        } catch (Exception e){
            logger.error(e.getMessage());
            response.put(Constants.RESPONSE_FIELD_MESSAGE,"Error inesperado tratando de crear el usuario");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
