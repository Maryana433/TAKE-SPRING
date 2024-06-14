package com.take.project.repository;

import com.take.project.entity.BucketEntity;
import com.take.project.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BucketRepository extends JpaRepository<BucketEntity, Long> {

    Optional<BucketEntity> findBucketEntityByFilm(FilmEntity film);
}
