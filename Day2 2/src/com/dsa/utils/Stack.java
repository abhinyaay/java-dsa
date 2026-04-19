package com.dsa.utils;

public interface Stack<T> {
    boolean isEmpty();
    T peek();
    T pop();
    void push(T data);
}
