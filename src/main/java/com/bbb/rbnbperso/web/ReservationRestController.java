package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.ReservationDTO;
import com.bbb.rbnbperso.exceptions.ReservationNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<ReservationDTO> reservations(){
        return gestationService.listReservations();
    }

    @GetMapping("all/{id}")
    public ReservationDTO getReservation(@PathVariable Long id) throws ReservationNotFoundException {
        return gestationService.getReservation(id);
    }

    @PostMapping("/all")
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservationDTO){
        return gestationService.saveReservation(reservationDTO);
    }

    @PutMapping("/all/{id}")
    public ReservationDTO updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO){
        reservationDTO.setIdReservation(id);
        return gestationService.updateReservation(reservationDTO);
    }

    @DeleteMapping("/all/{id}")
    public void deleteReservation(@PathVariable Long id){
        gestationService.deleteReservation(id);
    }
}
