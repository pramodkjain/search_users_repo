package com.users.repo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Repository {

	private long id;
	private String name;
	private boolean fork;
	@JsonProperty("forks_count")
	private int forksCount;
	private RepositoryOwner owner;
	private String description;
	@JsonProperty("stargazers_count")
	private int starGazersCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFork() {
		return fork;
	}

	public void setFork(boolean fork) {
		this.fork = fork;
	}

	public int getForksCount() {
		return forksCount;
	}

	public void setForksCount(int forksCount) {
		this.forksCount = forksCount;
	}

	public RepositoryOwner getOwner() {
		return owner;
	}

	public void setOwner(RepositoryOwner owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStarGazersCount() {
		return starGazersCount;
	}

	public void setStarGazersCount(int starGazersCount) {
		this.starGazersCount = starGazersCount;
	}
}
