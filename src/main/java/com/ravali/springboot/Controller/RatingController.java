package com.ravali.springboot.Controller;

import com.ravali.springboot.Model.Rating;
import com.ravali.springboot.Model.RatingRequest;
import com.ravali.springboot.Service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    private static final Logger log = LoggerFactory.getLogger(RatingController.class);

    @GetMapping("/{name}")
    public ResponseEntity<Rating> getRating(@PathVariable String name){
       Rating rating = ratingService.fetchRating(name);
       log.info("Returning rating for movie: {}", name);
        return ResponseEntity.ok(rating);
    }

    @PostMapping
    public ResponseEntity<Rating> updateRating(@RequestBody RatingRequest ratingRequest){
       Rating rating = ratingService.updateRating(ratingRequest.getName(), ratingRequest.getStars());
       log.info("Returning new average for movie: {}", ratingRequest.getName());
        return ResponseEntity.ok(rating);
    }
}
