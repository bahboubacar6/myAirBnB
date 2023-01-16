package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnounceRepository extends JpaRepository<Announce, Long> {
    List<Announce> findByAppUserIdUser(Long idUser);
}
