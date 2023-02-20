package com.querydsltutorial.querydsl.service;

import com.querydsltutorial.querydsl.entity.Board;
import com.querydsltutorial.querydsl.repository.BoardRepository;
import com.querydsltutorial.querydsl.util.SearchCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.querydsltutorial.querydsl.util.SearchCondition.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void findBoard() {
        //given
        Board board = new Board("테스트 제목", "내용");
        boardService.save(board.getTitle(), board.getContent());
        Board board2 = new Board("테스트 제목2", "내용2");
        boardService.save(board2.getTitle(), board2.getContent());
        Board board3 = new Board("제목1", "내용1");
        boardService.save(board3.getTitle(), board3.getContent());
        Board board4 = new Board("제목2", "내용2");
        boardService.save(board4.getTitle(), board4.getContent());
        //when
        List<Board> titleSearch = boardService.findBoard(new SearchCondition("테스트", SearchType.TIT));
        List<Board> titleAndContentSearch = boardService.findBoard(new SearchCondition("내용", SearchType.TITCONT));
        //then
        assertThat(titleSearch).extracting("title").containsExactlyInAnyOrder("테스트 제목", "테스트 제목2");
        assertThat(titleAndContentSearch).extracting("title")
                .containsExactlyInAnyOrder("테스트 제목", "테스트 제목2", "제목1", "제목2");
    }
}