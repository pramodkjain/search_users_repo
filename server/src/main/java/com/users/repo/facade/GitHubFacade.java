package com.users.repo.facade;

import java.util.List;

import com.users.repo.dto.Repository;
import com.users.repo.exception.NoRepoFoundForAUserException;

public interface GitHubFacade {

	List<Repository> getAllReposForAUser(String userId) throws NoRepoFoundForAUserException;

	int searchedCountInLastThreeMinutes(String userId);

	void saveUserSearchLog(String userId);
}
