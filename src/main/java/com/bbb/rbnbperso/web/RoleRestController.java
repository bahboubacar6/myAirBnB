package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.RoleDTO;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<RoleDTO> listRoles(){
        return gestationService.listRoles();
    }

    @GetMapping("/all/{id}")
    public RoleDTO getRole(@PathVariable Long id) throws RoleNotFoundException {
        return gestationService.getRole(id);
    }

    @PostMapping("/all")
    public RoleDTO saveRole(@RequestBody RoleDTO roleDTO){
        return gestationService.saveRole(roleDTO);
    }

    @PutMapping("/all/{id}")
    public RoleDTO updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        roleDTO.setIdRole(id);
        return gestationService.updateRole(roleDTO);
    }

    @DeleteMapping("/all/{id}")
    public void deleteRole(@PathVariable Long id){
        gestationService.deleteRole(id);
    }
}
