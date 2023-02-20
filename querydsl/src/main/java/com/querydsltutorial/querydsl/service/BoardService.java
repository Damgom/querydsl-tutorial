package com.querydsltutorial.querydsl.service;

import com.querydsltutorial.querydsl.entity.Board;
import com.querydsltutorial.querydsl.repository.BoardRepository;
import com.querydsltutorial.querydsl.util.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(String title, String content) {
        Board board = new Board(title, content);
        boardRepository.save(board);
    }

    public List<Board> findBoard(SearchCondition searchCondition) {
        return boardRepository.search(searchCondition);
    }
}
