package com.bbb.rbnbperso.web;

import com.bbb.rbnbperso.dtos.AnnounceDTO;
import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.dtos.ImageModelDTO;
import com.bbb.rbnbperso.dtos.ReservationDTO;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.exceptions.AnnounceNotFoundException;
import com.bbb.rbnbperso.services.GestationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.SecondaryTable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/announces")
@AllArgsConstructor
@CrossOrigin("*")
public class AnnounceRestController {

    private GestationService gestationService;

    @GetMapping("/all")
    public List<AnnounceDTO> listAnnounce(){
        List<AnnounceDTO> announceDTOList = gestationService.listAnnounces();
        return announceDTOList;
    }
    @GetMapping("/search")
    public List<AnnounceDTO> searchAnnounces(@RequestParam(name = "keyword", defaultValue = "") TypeAR keyword){
        return gestationService.searchAnnounces(keyword);
    }

    @GetMapping("/all/{id}")
    public AnnounceDTO getAnnounce(@PathVariable Long id) throws AnnounceNotFoundException {
        return gestationService.getAnnounce(id);
    }

    @PostMapping("/all")
    public AnnounceDTO saveAnnounce(@RequestBody AnnounceDTO announceDTO){
        return gestationService.saveAnnounce(announceDTO);
    }

 /*   @PostMapping("/add")
    public AnnounceDTO saveAnnounceDB(@RequestParam( "file") MultipartFile file, @RequestBody AnnounceDTO announceDTO) throws IOException {
        return gestationService.saveAnnounceDB(file,announceDTO);
    }*/
     @PostMapping(value = {"/add"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
     public AnnounceDTO saveAnnounceDB(@RequestPart( "imageFile") MultipartFile[] file, @RequestPart("announceDTO") AnnounceDTO announceDTO) throws IOException {

         //return gestationService.saveAnnounceDB(file,announceDTO);
         try {
            Set<ImageModelDTO> images = uploadImage(file);
            announceDTO.setAnnounceImages(images);
            return  gestationService.saveAnnounceDB(announceDTO);
         }catch (Exception e){
             System.out.println(e.getMessage());
             return null;
         }
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

    public Set<ImageModelDTO> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModelDTO> imageModels = new HashSet<>();
        for (MultipartFile file: multipartFiles){
            ImageModelDTO imageModelDTO = new ImageModelDTO(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModelDTO);
        }
        return imageModels;
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
