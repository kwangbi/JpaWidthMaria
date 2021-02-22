package com.kwang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwang.entity.PostsEntity;

public interface PostsRepository extends JpaRepository<PostsEntity, Long> {

}
