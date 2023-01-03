package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
