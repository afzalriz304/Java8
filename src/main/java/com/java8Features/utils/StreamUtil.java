package com.java8Features.utils;

import java.util.Arrays;
import java.util.List;

public class StreamUtil<T> {

    public void print(List<T> t) {
        t.stream().forEach(System.out::println);
        System.out.println("----------------ends here-------------");
    }
}
