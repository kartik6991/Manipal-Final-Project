package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entities.AddFeedbackToMobileDTO;
import com.example.demo.entities.Feedback;
import com.example.demo.exception.FeedbackException;
import com.example.demo.exception.MobileException;
import com.example.demo.service.IFeedbackService;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class FeedbackController {
	@Autowired
	private IFeedbackService custService;
	
	@GetMapping("feedbacks")
	public List<Feedback> getAllFeedback()throws FeedbackException{
		return this.custService.showAllFeedbacks();
	}
	
	@PostMapping("addFeedback")
	public Feedback addFeedback(@RequestBody Feedback feedback)throws FeedbackException {
		return this.custService.addFeedback(feedback);
	}
	
	@DeleteMapping("cancelFeedback/{id}")
	public String cancelFeedback(@PathVariable("id")String feedbackID)throws FeedbackException {
		return this.custService.cancelFeedback(feedbackID);
	}
	
	@PutMapping("updateFeedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback)throws FeedbackException {
		return this.custService.updateFeedback(feedback);
	}
	
	@GetMapping("getFeedbackByid/{id}")
	public Feedback getFeedbackByid(@PathVariable("id") String feedbackId)throws FeedbackException{
		return this.custService.getFeedbackByid(feedbackId);
	}
	
	@PostMapping("addfeedbacktomobile")
	public Feedback addFeedbacktoMobile(@RequestBody AddFeedbackToMobileDTO feedbackDTO) throws MobileException, FeedbackException{
		return this.custService.addFeedbackToMobile(feedbackDTO);
	}
}
