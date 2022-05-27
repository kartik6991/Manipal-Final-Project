package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.AddFeedbackToMobileDTO;
import com.example.demo.entities.Feedback;
import com.example.demo.exception.FeedbackException;
import com.example.demo.exception.MobileException;

public interface IFeedbackService {

	public Feedback addFeedback(Feedback feedback) throws FeedbackException;

	public String cancelFeedback(String feedbackID)throws FeedbackException;

	public Feedback updateFeedback(Feedback feedback)throws FeedbackException;
	
	public Feedback getFeedbackByid(String feedbackId)throws FeedbackException;
	
	public List<Feedback> showAllFeedbacks()throws FeedbackException;

	public Feedback addFeedbackToMobile(AddFeedbackToMobileDTO feedbackDTO) throws MobileException, FeedbackException;
	
}
