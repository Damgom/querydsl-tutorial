package com.querydsltutorial.querydsl.util;

import lombok.Data;

@Data
public class SearchCondition {
    
    String title;
    String content;

    public SearchCondition(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
