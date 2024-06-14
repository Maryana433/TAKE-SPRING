package com.take.project.service;

import com.take.project.controller.request.BucketAddRequest;
import com.take.project.entity.BucketEntity;
import com.take.project.model.Bucket;
import com.take.project.repository.BucketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BucketService {

    private final BucketRepository bucketRepository;
    private final FilmService filmService;

    public List<Bucket> getFilmsInBucket() {

        var bucketItems = bucketRepository.findAll();


        return bucketItems.stream().map(b -> {

            var bucketModel = new Bucket();
            bucketModel.setDateTime(b.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            bucketModel.setId(b.getId());
            bucketModel.setQty(b.getQty());
            bucketModel.setFilm(FilmConverter.convertFilmEntitiesToFilm(b.getFilm()));
            bucketModel.setPrice(b.getQty() * b.getFilm().getCost());

            return bucketModel;
        }).toList();
    }

    public void addFilmToBucket(BucketAddRequest request) {

        var filmEntity = filmService.getFilmEntityById(request.filmId());
        var bucketTypeEntity = bucketRepository.findBucketEntityByFilm(filmEntity);

        if (bucketTypeEntity.isEmpty()) {

            var bucketEntity = new BucketEntity();
            bucketEntity.setFilm(filmEntity);
            bucketEntity.setDateTime(LocalDateTime.now());
            bucketEntity.setQty(1);
            bucketRepository.save(bucketEntity);
        } else {

            bucketTypeEntity.get().setQty(bucketTypeEntity.get().getQty() + 1);
            bucketRepository.save(bucketTypeEntity.get());
        }

    }

    public void deleteBucket(Long bucketId) {

        var bucketEntity = bucketRepository.findById(bucketId);
        bucketEntity.ifPresentOrElse(b -> bucketRepository.delete(b), () -> log.error("bucket not exists"));
    }
}
