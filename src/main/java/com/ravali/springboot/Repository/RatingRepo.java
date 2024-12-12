package com.ravali.springboot.Repository;

import com.ravali.springboot.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {

    Rating findByName(String movieName);

   // List<Rating> findAllByAvgRatingBetween(double min, double max);
}
