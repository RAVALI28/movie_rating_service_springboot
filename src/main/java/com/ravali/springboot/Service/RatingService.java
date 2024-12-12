package com.ravali.springboot.Service;

import com.ravali.springboot.Exception.NotFoundException;
import com.ravali.springboot.Model.Rating;
import com.ravali.springboot.Repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public Rating updateRating(String name, double stars){
        Rating rating = ratingRepo.findByName(name);

        if(rating == null){
            rating = new Rating();
            rating.setName(name);
            rating.setAvgRating(stars);
            rating.setCount(1);
        }
        else {

            int count = rating.getCount();
            double newAverage = (rating.getAvgRating() * count + stars) / (count + 1);

            rating.setAvgRating(newAverage);
            rating.setCount(++count);
        }
         return ratingRepo.save(rating);

    }

    public Rating fetchRating(String name){
        Rating rating = ratingRepo.findByName(name);

        if(rating == null){
            throw new NotFoundException("Movie not found with name:" +name);
        }
        return rating;
    }
}
