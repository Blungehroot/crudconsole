package com.crudconsole.app.model;

import lombok.Data;


import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Label implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Long id;
    private String name;

    public Label() {
        id = (long) count.incrementAndGet();
    }
}
