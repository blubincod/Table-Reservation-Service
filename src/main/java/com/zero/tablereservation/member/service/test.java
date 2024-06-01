package com.zero.tablereservation.member.service;

import java.util.Optional;

public class test {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("HELLO");

        String name = optional.orElse("NOTHING");

        System.out.println(name);


        System.out.println(optional);


    }
}
