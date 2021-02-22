package com.kwang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kwang.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
