package com.querydsltutorial.querydsl.util;

import lombok.Data;

@Data
public class SearchCondition {

    String content;
    SearchType type;

    public SearchCondition(String content, SearchType type) {
        this.content = content;
        this.type = type;
    }
    public enum SearchType {
        TIT, TITCONT
    }
}
