package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AddFeedbackToMobileDTO;
import com.example.demo.entities.Feedback;
import com.example.demo.entities.Mobile;
import com.example.demo.exception.FeedbackException;
import com.example.demo.exception.MobileException;
import com.example.demo.repository.IFeedbackRepository;
import com.example.demo.repository.IMobileRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
	@Autowired
	private IFeedbackRepository feedbackRepo;
	@Autowired
	private IMobileRepository mobileRepo;
	
	@Override
	public Feedback addFeedback(Feedback feedback)throws FeedbackException {
		Optional<Feedback> newFeedback = this.feedbackRepo.findById(feedback.getFeedbackId());
		if (newFeedback.isPresent())
			throw new FeedbackException("your account already exists");
		return this.feedbackRepo.save(feedback);
	}

	@Override
	public String cancelFeedback(String feedbackID) {
		this.feedbackRepo.deleteById(feedbackID);
		return "Feedback ID deleted successfully";
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		return this.feedbackRepo.save(feedback);
		
	}

	@Override
	public Feedback getFeedbackByid(String feedbackId) {
		Optional<Feedback> feedbackOptional = this.feedbackRepo.findById(feedbackId);
		return feedbackOptional.get();
	}

	@Override
	public List<Feedback> showAllFeedbacks() {
		return feedbackRepo.findAll();
	}
	
	@Override
	public Feedback addFeedbackToMobile(AddFeedbackToMobileDTO addFeedbackDTO)throws MobileException, FeedbackException{
		Optional<Feedback>feedbackOpt=this.feedbackRepo.findById(addFeedbackDTO.getFeedbackId());
		if (feedbackOpt.isEmpty())
			throw new FeedbackException("Feedback Id doesn't exist");
		Feedback feedback=feedbackOpt.get();
		Optional<Mobile>mobileOpt=this.mobileRepo.findById(addFeedbackDTO.getMobileId());
		if (mobileOpt.isEmpty())
			throw new MobileException("Mobile Id doesn't exist");
		Mobile mobile=mobileOpt.get();
		if(mobile.getFeedback()==null)
			mobile.setFeedback(feedback);
		this.mobileRepo.save(mobile);
		return mobile.getFeedback();
	}
}

	

