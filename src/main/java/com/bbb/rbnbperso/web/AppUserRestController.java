package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.security.service.AccountService;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
@CrossOrigin("*")
public class AppUserRestController {

    private GestationService gestationService;
    private AccountService accountService;

    @GetMapping("/all")
    public List<AppUserDTO> users(){
        return gestationService.listUsers();
    }
    @GetMapping("/search")
    public List<AppUserDTO> searchUser(@RequestParam(name = "keyword", defaultValue = "") String keyword){
        //return gestationService.searchUsers("%" + keyword + "%");
        return gestationService.searchUsers(keyword);
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
    public AppUserDTO updateUser(@PathVariable Long idUser, @RequestBody AppUserDTO appUserDTO) throws UserNotFoundException {
        appUserDTO.setIdUser(idUser);
        return accountService.updateUser(appUserDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        gestationService.deleteAppUser(id);
    }
}
