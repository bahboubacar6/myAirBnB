package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.ReservationDTO;
import com.bbb.rbnbperso.dtos.ReservationFormDTO;
import com.bbb.rbnbperso.exceptions.ReservationNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/reservations")
@AllArgsConstructor
@CrossOrigin("*")
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

    @PostMapping("/all/add")
    public ResponseEntity<ReservationDTO> addReservationToUser(@RequestBody ReservationFormDTO reservationFormDTO){

        try {
            ReservationDTO addResToUser = gestationService.addReservationToUser(reservationFormDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addResToUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

    @GetMapping("/get-image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        // Récupérer les données de l'image à partir de la base de données
        byte[] imageData = gestationService.getImageOfAnnonce(id);

        // Créer une réponse HTTP contenant les données de l'image
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Remplacez par le type MIME de votre image
        headers.setContentLength(imageData.length);
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }
}
