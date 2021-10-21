package com.company;

public class Node
{
    String key;
    Node left, right;
    Car car;
    // Constructor
    Node(String key, Car car)
    {
        this.key = key;
        this.car = car;
        left = null;
        right = null;
    }
}