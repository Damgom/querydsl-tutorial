package com.querydsltutorial.querydsl.repository;

import com.querydsltutorial.querydsl.entity.Board;
import com.querydsltutorial.querydsl.util.SearchCondition;

import java.util.List;

public interface BoardCustomRepository {
    public List<Board> search(SearchCondition searchCondition);
}
