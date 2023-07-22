package com.mjc.school;

import com.mjc.school.service.Starter;

public class Main {
    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.init();
        starter.start();
    }
}