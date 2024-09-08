package com.pagatodo.test.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagatodo.test.security.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;

import com.pagatodo.test.dto.ErrorMessageDTO;
import com.pagatodo.test.dto.LoginDTO;
import com.pagatodo.test.dto.TokenDTO;
import com.pagatodo.test.exception.CustomLoginException;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenDTO> registerUser(@RequestBody LoginDTO login) throws CustomLoginException {
        log.info("Entrando al login");
        log.info(login.toString());
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            if (authentication.isAuthenticated()) {
                return new ResponseEntity<TokenDTO>(new TokenDTO(jwtUtil.generateToken(login.getUsername(), "admin")),
                        HttpStatus.OK);
            } else {
                throw new CustomLoginException("Usuario no autenticado", "USER_NOT_AUTH", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            throw new CustomLoginException("Usuario no encontrado", "USER_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(CustomLoginException.class)
    public ResponseEntity<ErrorMessageDTO> handleUserNotFoundException(CustomLoginException e) {
        ErrorMessageDTO error = new ErrorMessageDTO();
        error.setMessage(e.getMessage());
        error.setCode(e.getCode());
        return ResponseEntity.status(e.getStatus()).body(error);
    }

}
