package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AnnounceDTO;
import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.dtos.ReservationDTO;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("announces")
@AllArgsConstructor
@CrossOrigin("*")
public class AnnounceRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<AnnounceDTO> listAnnounce(){
        List<AnnounceDTO> announceDTOList = gestationService.listAnnounces();
        return announceDTOList;
    }

    @GetMapping("/all/{id}")
    public AnnounceDTO getAnnounce(@PathVariable Long id) throws AnnounceNotFoundException {
        return gestationService.getAnnounce(id);
    }

    @PostMapping("/all")
    public AnnounceDTO saveAnnounce(@RequestBody AnnounceDTO announceDTO){
        return gestationService.saveAnnounce(announceDTO);
    }
    @PutMapping("/all/{id}")
    public AnnounceDTO updateAnnounce(@PathVariable Long id, @RequestBody AnnounceDTO announceDTO){
        announceDTO.setIdAnnounce(id);
        return gestationService.updateAnnounce(announceDTO);
    }
    @DeleteMapping("/all/{id}")
    public void deleteAnnounce(@PathVariable Long id){
        gestationService.deleteAnnounce(id);
    }
    @GetMapping("/{idUser}/announce")
    public List<AnnounceDTO> announcesUser(@PathVariable Long idUser){
        return gestationService.announcesUser(idUser);
    }

}
