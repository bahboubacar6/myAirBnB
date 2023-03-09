package com.bbb.rbnbperso.repositories;

import com.bbb.rbnbperso.entities.Announce;
import com.bbb.rbnbperso.entities.ImageModel;
import com.bbb.rbnbperso.enums.TypeAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageModelRepository extends JpaRepository<ImageModel, Long> {
}
