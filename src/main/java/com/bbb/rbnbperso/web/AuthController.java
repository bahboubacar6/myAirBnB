package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.dtos.AuthResponseDTO;
import com.bbb.rbnbperso.dtos.LoginDTO;
import com.bbb.rbnbperso.dtos.Response;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.security.JWTGenerator;
import com.bbb.rbnbperso.security.service.AccountService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
@Slf4j
public class AuthController {

    private final AccountService accountService;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AccountService accountService, AuthenticationManager authenticationManager, JWTGenerator jwtGenerator) {
        this.accountService = accountService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response login(@RequestBody LoginDTO loginDto){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getEmail(),
                            loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            log.info(token);
            return Response.builder()
                    .reason("")
                    .statusCode(200)
                    .message("success")
                    .status(HttpStatus.OK)
                    .data(Map.of("response", new AuthResponseDTO(token)))
                    .build();
        }catch (RuntimeException e){
            log.error(e.getMessage());
            return Response.builder()
                    .reason(e.getMessage())
                    .statusCode(403)
                    .message("failed")
                    .status(HttpStatus.FORBIDDEN)
                    .data(Map.of("respose", "null"))
                    .build();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping(value = "/register")
    public ResponseEntity<AppUserDTO> register(@Validated @RequestBody AppUserDTO appUserDTO) {
        try {
            AppUserDTO savedUser = accountService.saveUser(appUserDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/current-user")
    public ResponseEntity<AppUserDTO> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            AppUserDTO userDto = accountService.findByEmail(auth.getName());
            return ResponseEntity.ok(userDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();
        }

    }

    @GetMapping("/users")
    public List<AppUserDTO> listUsers(){
        return accountService.listUsers();
    }

   /* @PostMapping("/users")
    public AppUserDTO addUser(@RequestBody AppUserDTO appUserDTO){
        return accountService.saveUser(appUserDTO);
    }*/

    @GetMapping("/listusers")
    public List<AppUser> users(){
        return accountService.listeUsers();
    }
}
