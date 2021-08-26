package com.crudconsole.app.model;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    private Long id;
    private String name;
    private String content;
    private List<Label> labels;
}
