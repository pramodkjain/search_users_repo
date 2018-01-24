package com.users.repo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.repo.entity.UserSearchLog;

public interface UserSearchLogRepository extends CrudRepository<UserSearchLog, Long> {

	List<UserSearchLog> findByUserIdAndSearchedTimeGreaterThanEqual(String userId, Timestamp searchedTime);
}
