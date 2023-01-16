package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    List<AppUser> findByLastNameContains(String keyword);
    @Query("Select u from AppUser u where u.lastName like:kw")
    List<AppUser> searchUsers(@Param("kw") String keyword);
}
