package com.brs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.FeedBack;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.service.IFeedBackService;

/**
 * Description:This is feedbackController Layer
 **/
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("rest/api/")
public class FeedBackController {
	Logger log = Logger.getLogger("FeedBackController");
	@Autowired
	IFeedBackService feedbackService;

	/**
	 * Description :To insert feedback details into the database Return Value
	 * :feedback object of the feedback been fetched
	 * @throws FeedBackNotFoundException 
	 **/

	@PostMapping("/feedbacks")
	public ResponseEntity<FeedBack> addFeedBack(@Valid @RequestBody FeedBack feedback) throws FeedBackNotFoundException {
		log.info("addfeedback method");
		FeedBack newVal = feedbackService.addFeedBack(feedback);
		return new ResponseEntity<>(newVal, HttpStatus.OK);

	}

	/**
	 * Description :To update feedback details into the database Return Value
	 * :feedback object of the feedback been fetched
	 * @throws FeedBackNotFoundException 
	 **/

	@PutMapping("/employees/{id}")
	public ResponseEntity<FeedBack> updateFeedBack(@Valid @RequestBody FeedBack feedback) throws FeedBackNotFoundException {
		log.info("updatefeedback method");
		FeedBack newVal = feedbackService.updateFeedBack(feedback);
		return new ResponseEntity<>(newVal, HttpStatus.OK);

	}

	/**
	 * Description :To view feedback details by id in the database Return Value
	 * :feedback object of the feedback been fetched
	 * @throws FeedBackNotFoundException 
	 **/

	@GetMapping("/feedbacks/{id}")
	public ResponseEntity<FeedBack> viewFeedBack(@PathVariable("fbid") int id) throws FeedBackNotFoundException {
		log.info("viewfeedback method");
		return new ResponseEntity<FeedBack>(feedbackService.viewFeedBack(id), HttpStatus.OK);

	}

	/**
	 * Description :To view all feedback details in the database Return Value :list
	 * of feedback object of the feedback been fetched
	 * @throws FeedBackNotFoundException 
	 **/

	@GetMapping("/feedbacks")
	public ResponseEntity<List<FeedBack>> viewAllFeedBack() throws FeedBackNotFoundException {
		log.info("viewAllfeedback method");
		List<FeedBack> firstFeedBack = feedbackService.viewAllFeedBack();
		return new ResponseEntity<List<FeedBack>>(firstFeedBack, HttpStatus.OK);
	}

	/**
	 * Description :To delete feedback details from the database Return Value
	 * :feedback object of the feedback been fetched
	 * @throws FeedBackNotFoundException 
	 **/

	@DeleteMapping("/feedbacks/{id}")
	public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("id") int id) throws FeedBackNotFoundException {
		log.info("deleteFeedback method");
		FeedBack deleted = feedbackService.deleteFeedBack(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);

	}

}