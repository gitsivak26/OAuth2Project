package com.authentication.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.oauth.model.UserComments;

@Repository
public interface CommentsDAO extends JpaRepository<UserComments, Integer> {}
