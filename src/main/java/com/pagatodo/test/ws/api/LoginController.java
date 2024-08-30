package com.pagatodo.test.ws.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagatodo.test.dao.User;
import com.pagatodo.test.security.jwt.JwtUtil;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    //TODO Cambiar request body por una entidad Login
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return new ResponseEntity<String>("{ \"token\" : \"" + jwtUtil.generateToken(user.getUsername(), "admin") + "\"}", HttpStatus.OK);
        }
        return new ResponseEntity<String>("{ \"mensaje\" : \"Credenciales incorrectas\"}", HttpStatus.BAD_REQUEST);
    }
    
}
