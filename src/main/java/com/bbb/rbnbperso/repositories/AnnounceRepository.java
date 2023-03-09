package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.AppUser;
import com.bbb.rbnbperso.enums.TypeAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnnounceRepository extends JpaRepository<Announce, Long> {
    List<Announce> findByAppUserIdUser(Long idUser);
    List<Announce> findByTypeAnnounceContains(String keyword);
    @Query("Select a from Announce a where a.typeAnnounce like:kw")
    List<Announce> searchAnnounces(@Param("kw") TypeAR keyword);
}
