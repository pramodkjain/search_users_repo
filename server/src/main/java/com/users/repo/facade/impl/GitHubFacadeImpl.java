package com.users.repo.facade.impl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.users.repo.dto.Repository;
import com.users.repo.entity.UserSearchLog;
import com.users.repo.exception.NoRepoFoundForAUserException;
import com.users.repo.facade.GitHubFacade;
import com.users.repo.repository.UserSearchLogRepository;

@Component
public class GitHubFacadeImpl implements GitHubFacade {

	private Log log = LogFactory.getLog(GitHubFacadeImpl.class);

	@Value("${github.ws.get.repo}")
	private String getRepoAPIUrl;

	@Autowired
	private UserSearchLogRepository userSearchLogRepository;

	@Override
	public List<Repository> getAllReposForAUser(String userId, boolean forkedOnly) throws NoRepoFoundForAUserException {
		try {
			if (StringUtils.isBlank(userId)) {
				throw new IllegalArgumentException("userId is null!");
			}
			List<Repository> repositoryDTOList = callWebService(userId);
			if (forkedOnly) {
				repositoryDTOList = repositoryDTOList.stream().filter(p -> p.isFork()).collect(Collectors.toList());
			}
			return repositoryDTOList;
		} catch (HttpClientErrorException ex) {
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NoRepoFoundForAUserException();
			}
			throw ex;
		}
	}

	@Override
	public int searchedCountInLastThreeMinutes(String userId) {
		//ToDo: Brainstorm below logic when running in a cluster and nodes are in different time-zones.
		long milliSeconds = System.currentTimeMillis() - (3 * 60 * 1000);
		List<UserSearchLog> userSearchLogList = userSearchLogRepository.findByUserIdAndSearchedTimeGreaterThanEqual(userId, new Timestamp(milliSeconds));
		if (userSearchLogList != null)
			return userSearchLogList.size();
		return 0;
	}

	@Override
	public void saveUserSearchLog(String userId) {
		UserSearchLog userSearchLog = new UserSearchLog();
		userSearchLog.setUserId(userId);
		userSearchLog.setSearchedTime(new Timestamp(System.currentTimeMillis()));
		userSearchLogRepository.save(userSearchLog);
	}

	private List<Repository> callWebService(String userId) {
		String url = String.format(getRepoAPIUrl, userId);
		RestTemplate restTemplate = new RestTemplate();
		Repository[] repository = restTemplate.getForObject(url, Repository[].class);
		// repository[0] = createSampleRepository();
		log.info(repository.toString());
		return Arrays.asList(repository);
	}

	/*
	 * private Repository createSampleRepository(){
	 * Repository repository = new Repository();
	 * repository.setDescription("A B C");
	 * repository.setName("myRepo");
	 * RepositoryOwner repositoryOwner = new RepositoryOwner();
	 * repositoryOwner.setLogin("ballunano");
	 * repositoryOwner.setAvatarUrl("http://hello");
	 * repository.setOwner(repositoryOwner);
	 * return repository;
	 * }
	 */

}
