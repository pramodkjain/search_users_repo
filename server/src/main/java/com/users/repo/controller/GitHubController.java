package com.users.repo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.repo.converter.JsonConverter;
import com.users.repo.exception.NoRepoFoundForAUserException;
import com.users.repo.facade.impl.GitHubFacadeImpl;

@RestController
@RequestMapping("/api/github")
public class GitHubController {
	private Log log = LogFactory.getLog(GitHubController.class);

	@Autowired
	private GitHubFacadeImpl gitHubFacade;

	@Autowired
	private JsonConverter jsonConverter;

	@RequestMapping(value = "users/{userid}/repos", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllReposForAUser(@PathVariable String userid, @RequestParam boolean forkedOnly) {
		try {
			ResponseEntity responseEntity = new ResponseEntity(jsonConverter.toJson(gitHubFacade.getAllReposForAUser(userid,forkedOnly)), HttpStatus.OK);
			// log it
			gitHubFacade.saveUserSearchLog(userid);
			return responseEntity;
		} catch (NoRepoFoundForAUserException nex) {
			String errMsg = String.format("No repository found for user[%s]!", userid);
			log.error(errMsg, nex);
			return new ResponseEntity(errMsg, HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			log.error("Fatal Error!", ex);
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "users/{userid}/searchedCount", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> searchedCountInLastThreeMinutes(@PathVariable String userid) {
		try {
			ResponseEntity responseEntity = new ResponseEntity((gitHubFacade.searchedCountInLastThreeMinutes(userid)), HttpStatus.OK);
			return responseEntity;
		} catch (Exception ex) {
			log.error("Fatal Error!", ex);
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
	}

}
