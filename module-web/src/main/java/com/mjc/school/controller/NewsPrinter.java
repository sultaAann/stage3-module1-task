package com.mjc.school.controller;


import com.mjc.school.service.NewsDTO;

import java.util.List;

public class NewsPrinter {

    public void printNews(List<NewsDTO> news) {
        for (NewsDTO article: news) {
            printArticle(article);
        }
    }

    public void printArticle(NewsDTO news) {
        news.toString();
    }
}
