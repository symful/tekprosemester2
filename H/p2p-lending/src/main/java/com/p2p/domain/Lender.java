package com.p2p.domain;

public class Lender {
    private String id;
    private String name;

    public Lender(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public boolean canFundLoan() {
        return true;
    }
}