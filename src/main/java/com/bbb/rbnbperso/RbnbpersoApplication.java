package com.bbb.rbnbperso;

import com.bbb.rbnbperso.dtos.AppUserDTO;
import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.entities.Role;
import com.bbb.rbnbperso.enums.TypeAR;
import com.bbb.rbnbperso.exceptions.UserNotFoundException;
import com.bbb.rbnbperso.repositories.*;
import com.bbb.rbnbperso.security.service.AccountService;
import com.bbb.rbnbperso.services.GestationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class RbnbpersoApplication{

	/*@Value("${spring.profiles.active:}")
	private String activeProfiles;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private RoleRepository roleRepository;

    Random random = new Random();
	@Override
	public void run(String... args) {
		log.info(activeProfiles);

        List<AppUser> utilisateurList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String firstName = randomString(12).toUpperCase(Locale.ROOT);
            String lastName = randomString(12);
            String email = randomString(12) + "@gmail.com";
            String username = randomString(12) + "6";

            AppUser uitisateur = new AppUser(0L, lastName, firstName, email, username, "1234",
                    List.of(roleRepository.findByRoleName("USER")), List.of(), List.of(), List.of());
            utilisateurList.add(uitisateur);
            log.info("user number {}", i);
        }
        try {
            List<AppUser> utilisateurs = appUserRepository.saveAll(utilisateurList);
            log.info("utilisateurs list saved {}", utilisateurs.size());
        }catch (Exception e){
            log.error(e.getMessage());
        }

	}*/

	public static void main(String[] args) {
        log.info("application running ...");
		SpringApplication.run(RbnbpersoApplication.class, args);
	}

 /*   public String randomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
    public String randomInteger(int length) {
        String characters = "0123456789";
        char[] number = new char[length];
        for (int i = 0; i < length; i++) {
            number[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(number);
    }

    public LocalDate randomLocalDate() {
        int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2001, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }*/
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	/*@Bean
	CommandLineRunner startSecurity(AccountService accountService){
		return args -> {
			accountService.addNewRole(new Role(null,"ADMIN"));
			accountService.addNewRole(new Role(null,"USER"));
			accountService.addNewRole(new Role(null,"CUSTOMER_MANAGER"));
			accountService.addNewRole(new Role(null,"PRODUCT_MANAGER"));
			accountService.addNewRole(new Role(null,"BILLS_MANAGER"));

			accountService.saveUser(new AppUserDTO(null,"Aly","Camara","aly@gmail.com","user1","1234", new ArrayList<>()));
			accountService.saveUser(new AppUserDTO(null,"user2","Camara","user2@gmail.com","user2","1234", new ArrayList<>()));
			accountService.saveUser(new AppUserDTO(null,"user3","Camara","user3@gmail.com","user3","1234", new ArrayList<>()));
			accountService.saveUser(new AppUserDTO(null,"user4","Camara","user4@gmail.com","user4","1234", new ArrayList<>()));
			accountService.saveUser(new AppUserDTO(null,"user5","Camara","user5@gmail.com","user5","1234", new ArrayList<>()));

			accountService.addRoleToUser("user1", "ADMIN");
			accountService.addRoleToUser("user1", "USER");
			accountService.addRoleToUser("user2", "USER");
			accountService.addRoleToUser("user2", "CUSTOMER_MANAGER");
			accountService.addRoleToUser("user3", "USER");
			accountService.addRoleToUser("user3", "PRODUCT_MANAGER");
			accountService.addRoleToUser("user4", "USER");
			accountService.addRoleToUser("user4", "BILLS_MANAGER");
			accountService.addRoleToUser("user5", "USER");


		};
	}*/
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
	/*CommandLineRunner start(AppUserRepository appUserRepository,
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
	}*/

}
