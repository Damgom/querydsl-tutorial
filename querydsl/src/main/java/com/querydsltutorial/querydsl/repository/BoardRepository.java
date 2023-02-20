package com.querydsltutorial.querydsl.repository;

import com.querydsltutorial.querydsl.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
}
