package com.querydsltutorial.querydsl.repository;

import com.querydsltutorial.querydsl.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select p from Board p join fetch p.content")
    List<Board> findAllInnerFetchJoin();
}
