package com.example.films.processor;


public interface Processor<T> {

    boolean process(final T t);
}
