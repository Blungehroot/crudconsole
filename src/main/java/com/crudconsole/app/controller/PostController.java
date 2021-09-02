package com.crudconsole.app.controller;

import com.crudconsole.app.model.Label;
import com.crudconsole.app.model.Post;
import com.crudconsole.app.repository.gson.GsonPostRepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class PostController {
    GsonPostRepositoryImpl postRepository;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public PostController(GsonPostRepositoryImpl postRepository) {
        this.postRepository = postRepository;
    }

    public String getAll() {
        return gson.toJson(postRepository.getAll());
    }

    public String getById(Long id) {
        return gson.toJson(postRepository.getById(id));
    }

    public void create(String name, String content, List<Label> labels) {
        Post post = new Post();
        post.setName(name);
        post.setContent(content);
        post.setLabels(labels);
        postRepository.save(post);
    }

    public void update(Long id, String name, String content, List<Label> labels) {
        Post post = new Post();
        post.setId(id);
        post.setName(name);
        post.setContent(content);
        post.setLabels(labels);
        postRepository.update(post);
    }

    public void delete(Long id) {
        postRepository.delete(id);
    }
}
