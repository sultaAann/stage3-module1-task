//package com.mjc.school.repository;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NewsGenerator {
//    private DBEmulation dbEmulation;
//    private static final String AUTHOR_FILE = "/author.txt";
//    private static final String CONTENT_FILE = "/content.txt";
//    private static final String NEWS_FILE = "/news.txt";
//    private static final int DEFAULT_NEWS_COUNT = 20;
//
//    public void generate() {
//        dbEmulation = DBEmulation.getInstance();
//        List<String> authors = readLines(AUTHOR_FILE);
//        List<String> contents = readLines(CONTENT_FILE);
//        List<String> news = readLines(NEWS_FILE);
//
//        for (int i = 0; i < DEFAULT_NEWS_COUNT; i++) {
//            int authorIndex = (int) (Math.random() * authors.size());
//            int contentIndex = (int) (Math.random() * contents.size());
//            int newsIndex = (int) (Math.random() * news.size());
//
//            News n = new News();
//            n.setId(i);
//            n.setContent(contents.get(contentIndex));
//            dbEmulation.create(n);
//        }
//    }
//
//    private static List<String> readLines(String fileName) {
//        List<String> lines = new ArrayList<>();
//        try {
//            InputStream inputStream = NewsGenerator.class.getResourceAsStream(fileName);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                lines.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }
//}
//
