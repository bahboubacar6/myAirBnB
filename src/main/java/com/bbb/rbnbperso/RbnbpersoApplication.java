package com.bbb.rbnbperso;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.repositories.*;
import com.bbb.rbnbperso.services.GestationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootApplication
public class RbnbpersoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbnbpersoApplication.class, args);
	}
	//@Bean
	/*CommandLineRunner start2(GestationService gestationService) {
		return arg -> {
			Stream.of("Bart","Lisa","Omer").forEach(name->{
				AppUserDTO appUserDTO = new AppUserDTO();
                appUserDTO.setLastName(name);
                appUserDTO.setFirstName("Simpson");
                appUserDTO.setEmail(name+"@gmail.com");
                appUserDTO.setUsername(name+"5");
                appUserDTO.setPassword("1234");
				gestationService.saveUser(appUserDTO);
			});
			gestationService.listUsers().forEach(user ->{
				Announce announce = new Announce();
				announce.setTypeAnnounce(Math.random()>0.5?TypeAR.CHAMBRE:TypeAR.MAISON);
				announce.setDate(LocalDate.of(2022,12,27).atStartOfDay());
				announce.setStartDate(LocalDateTime.of(2023,01, 25,17,25));
				announce.setEndDate(LocalDateTime.of(2023,01, 30,17,25));
				announce.setImage("https://media.istockphoto.com/id/1272128530/fr/photo/maison-avec-la-voie-d%C3%A9vitement-bleue-et-la-fa%C3%A7ade-en-pierre-sur-la-base-de-la-maison.jpg?b=1&s=170667a&w=0&k=20&c=3f94Y0nyR5prWiR0qVJ946oFyNhiweGNFg_Yne7w1uU=");
				announce.setAppUser(user);
				try {
					gestationService.saveAnnounce(Math.random()>0.5?TypeAR.CHAMBRE:TypeAR.MAISON,LocalDate.of(2022,12,28).atStartOfDay(),
							LocalDateTime.of(2023,02, 25,17,15),LocalDateTime.of(2023,02, 20,17,25),
							"https://media.istockphoto.com/id/1272128530/fr/photo/maison-avec-la-voie-d%C3%A9vitement-bleue-et-la-fa%C3%A7ade-en-pierre-sur-la-base-de-la-maison.jpg?b=1&s=170667a&w=0&k=20&c=3f94Y0nyR5prWiR0qVJ946oFyNhiweGNFg_Yne7w1uU=",
							user.getIdUser());
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
			});
		};
	}*/

	//@Bean
	CommandLineRunner start(AppUserRepository appUserRepository,
							AnnounceRepository announceRepository,
							AvisRepository avisRepository,
							ReservationRepository reservationRepository,
							RoleRepository roleRepository){
		return arg -> {
			Stream.of("Bart","Lisa","Omer").forEach(name->{
				AppUser appUser = new AppUser();
				appUser.setLastName(name);
				appUser.setFirstName("Simpson");
				appUser.setEmail(name+"@gmail.com");
				appUser.setUsername(name+"6");
				appUser.setPassword("1234");
				appUserRepository.save(appUser);
			});
			appUserRepository.findAll().forEach(user ->{
				Announce announce = new Announce();
				announce.setTypeAnnounce(Math.random()>0.5?TypeAR.CHAMBRE:TypeAR.MAISON);
				announce.setDate(LocalDate.of(2022,12,27).atStartOfDay());
				announce.setStartDate(LocalDateTime.of(2023,01, 25,17,25));
				announce.setEndDate(LocalDateTime.of(2023,01, 30,17,25));
				announce.setImage("https://media.istockphoto.com/id/1272128530/fr/photo/maison-avec-la-voie-d%C3%A9vitement-bleue-et-la-fa%C3%A7ade-en-pierre-sur-la-base-de-la-maison.jpg?b=1&s=170667a&w=0&k=20&c=3f94Y0nyR5prWiR0qVJ946oFyNhiweGNFg_Yne7w1uU=");
				announce.setAppUser(user);
				announceRepository.save(announce);
			});
		};
	}

}
