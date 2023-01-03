package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
