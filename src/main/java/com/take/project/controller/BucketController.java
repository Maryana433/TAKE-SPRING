package com.take.project.controller;

import com.take.project.controller.request.BucketAddRequest;
import com.take.project.controller.response.BucketResponse;
import com.take.project.service.BucketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/buckets")
@RequiredArgsConstructor
@Slf4j
public class BucketController {

    private final BucketService bucketService;


    @GetMapping
    public ResponseEntity<BucketResponse> getBucket() {

        var bucketModels = bucketService.getFilmsInBucket();
        var bucketResponse = new BucketResponse(bucketModels);
        return ResponseEntity.ok(bucketResponse);
    }


    @PostMapping
    public void addFilmToBucket(@RequestBody BucketAddRequest request){

        log.info(String.valueOf(request.filmId()));
        bucketService.addFilmToBucket(request);

    }

    @DeleteMapping("/{bucketId}")
    public void deleteBucket(@PathVariable Long bucketId){

        log.info("Delete bucket with Id : " + bucketId);
        bucketService.deleteBucket(bucketId);

    }
}
