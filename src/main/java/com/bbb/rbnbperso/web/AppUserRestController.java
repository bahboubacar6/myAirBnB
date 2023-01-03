package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AppUserRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<AppUserDTO> users(){
        return gestationService.listUsers();
    }
    @GetMapping("/all/{id}")
    public AppUserDTO getUser(@PathVariable(name = "id") Long idUser) throws UserNotFoundException {
        return gestationService.getUser(idUser);
    }
    @PostMapping("/all")
    public AppUserDTO saveUser(@RequestBody AppUserDTO appUserDTO){
        return gestationService.saveUser(appUserDTO);
    }
    @PutMapping("/all/{idUser}")
    public AppUserDTO updateUser(@PathVariable Long idUser, @RequestBody AppUserDTO appUserDTO){
        appUserDTO.setIdUser(idUser);
        return gestationService.updateUser(appUserDTO);
    }
    @DeleteMapping("/all/{id}")
    public void deleteUser(@PathVariable Long id){
        gestationService.deleteAppUser(id);
    }
}
