package com.example.demo.model;

import java.util.List;

public class DemoResult {

    public final int n;
    public final List<Integer> primes;
    public final List<List<Integer>> multiplesLists;

    public DemoResult(
        int n,
        List<Integer> primes,
        List<List<Integer>> multiplesLists
    ) {
        this.n = n;
        this.primes = primes;
        this.multiplesLists = multiplesLists;
    }
}
