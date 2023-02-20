package com.querydsltutorial.querydsl.service;

import com.querydsltutorial.querydsl.entity.Board;
import com.querydsltutorial.querydsl.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(String title, String content) {
        Board board = new Board(title, content);
        boardRepository.save(board);
    }
}
