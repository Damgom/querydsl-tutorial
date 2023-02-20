package com.querydsltutorial.querydsl.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsltutorial.querydsl.entity.Board;
import com.querydsltutorial.querydsl.util.SearchCondition;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

import static com.querydsltutorial.querydsl.entity.QBoard.board;

@RequiredArgsConstructor
public class BoardCustomRepositoryImpl implements BoardCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Board> search(SearchCondition condition) {
        return jpaQueryFactory.selectFrom(board)
                .where(isSearchable(condition.getContent()))
                .orderBy(board.id.desc())
                .fetch();
    }

    BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
        try {
            return new BooleanBuilder(f.get());
        } catch (Exception e) {
            return new BooleanBuilder();
        }
    }
    
    BooleanBuilder titleCt(String content) {
        return nullSafeBuilder(() -> board.title.contains(content));
    }

    BooleanBuilder contentCt(String content) {
        return nullSafeBuilder(() -> board.content.contains(content));
    }

    BooleanBuilder isSearchable(String content) {
        return titleCt(content).or(contentCt(content));
    }
}
