package com.food.ordering.system.messaging;

public enum DebeziumOp {
    CREATE("c"), UPDATE("u"), DELETE("d");

    private String val;

    DebeziumOp(String val) {
        this.val = val;
    }

    public String getValue() {
        return val;
    }
}
