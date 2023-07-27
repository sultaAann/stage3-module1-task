package com.mjc.school.controller;



import com.mjc.school.repository.impl.ModelDTO;

import java.util.List;

public class ModelPrinter {

    public void printNews(List<ModelDTO> news) {
        for (ModelDTO article: news) {
            printArticle(article);
        }
    }

    public void printArticle(ModelDTO news) {
        news.toString();
    }
}
