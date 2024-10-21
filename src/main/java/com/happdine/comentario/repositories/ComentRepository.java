package com.happdine.comentario.repositories;

import com.happdine.comentario.models.ComentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentRepository extends JpaRepository<ComentModel, Long> {

}

