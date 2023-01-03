package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AvisDTO;
import com.bbb.rbnbperso.exceptions.AvisNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avis")
@AllArgsConstructor
public class AvisRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<AvisDTO> listAvis(){
        return gestationService.listAvis();
    }

    @GetMapping("/all/{id}")
    public AvisDTO getAvis(@PathVariable Long id) throws AvisNotFoundException {
        return gestationService.getAvis(id);
    }

    @PostMapping("/all")
    public AvisDTO saveAvis(@RequestBody AvisDTO avisDTO){
        return gestationService.saveAvis(avisDTO);
    }

    @PutMapping("/all/{id}")
    public AvisDTO updateAvis(@PathVariable Long id, @RequestBody AvisDTO avisDTO){
        avisDTO.setId(id);
        return gestationService.updateAvis(avisDTO);
    }

    @DeleteMapping("/all/{id}")
    public void deleteAvis(@PathVariable Long id){
        gestationService.deleteAvis(id);
    }
}
