
package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AddRatingToMobileDTO;
import com.example.demo.entities.Rating;
import com.example.demo.exception.MobileException;
import com.example.demo.exception.RatingException;
import com.example.demo.service.IRatingService;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class RatingController {
	@Autowired
	private IRatingService rateService;
	
	@GetMapping("Ratings")
	public List<Rating> getAllRating(){
		return this.rateService.showAllRatings();
	}
	
	@PostMapping("addRating")
	public Rating addRating(@RequestBody Rating rating) throws RatingException {
		return this.rateService.addRating(rating);
	}
	
	@DeleteMapping("cancelRating/{id}")
	public String cancelRating(@PathVariable("id") String RatingID) throws RatingException {
		return this.rateService.cancelRating(RatingID);
	}
	
	@PutMapping("updateRating")
	public Rating updateRating(@RequestBody Rating rating) throws RatingException {
		return this.rateService.updateRating(rating);
	}
	
	@GetMapping("getRatingByid/{id}")
	public Rating getRatingByid(@PathVariable("id") String RatingId) throws RatingException{
		return this.rateService.getRatingByid(RatingId);
	}
	
	@PostMapping("addratingtomobile")
	public Rating addRatingtoMobile(@RequestBody AddRatingToMobileDTO ratingDTO) throws MobileException, RatingException{
		return this.rateService.addRatingToMobile(ratingDTO);
	}
}

