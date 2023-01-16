package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByAnnounce(Optional<Announce> announce);
}
