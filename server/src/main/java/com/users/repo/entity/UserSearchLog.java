package com.users.repo.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserSearchLog {

	@Id
	@GeneratedValue
	private Long userSearchLogId;
	private String userId;
	private Timestamp searchedTime;

	public Long getUserSearchLogId() {
		return userSearchLogId;
	}

	public void setUserSearchLogId(Long userSearchLogId) {
		this.userSearchLogId = userSearchLogId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getSearchedTime() {
		return searchedTime;
	}

	public void setSearchedTime(Timestamp searchedTime) {
		this.searchedTime = searchedTime;
	}
}
