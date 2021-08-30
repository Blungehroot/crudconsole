package com.crudconsole.app.repository;

import com.crudconsole.app.helpers.FileHelpers;
import com.crudconsole.app.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
public class PostRepositoryImpl {
    private static final String POST_FILE = "posts.json";

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Long generateMaxId(List<Post> allExistingPosts) {
        Long id = Collections.max(allExistingPosts, Comparator.comparing(p -> p.getId())).getId();
        return id + 1;
    }

    public Post getById(Long id) {
        String postsStrings = FileHelpers.readFile(POST_FILE);
        List<Post> posts = gson.fromJson(postsStrings, new TypeToken<List<Post>>() {
        }.getType());
        return posts.stream().filter(p -> p.getId().equals(id)).findAny().get();
    }

    public List<Post> getAll() {
        String postsStrings = FileHelpers.readFile(POST_FILE);
        return gson.fromJson(postsStrings, new TypeToken<List<Post>>() {
        }.getType());
    }

    public void save(Post post) {
        String postsStrings = FileHelpers.readFile(POST_FILE);
        List<Post> posts = new ArrayList<>();
        if (postsStrings.isEmpty()) {
            post.setId(1L);
            posts.add(post);
        } else {
            posts = gson.fromJson(postsStrings, new TypeToken<List<Post>>() {
            }.getType());
            post.setId(generateMaxId(posts));
            posts.add(post);
        }
        String jsonString = gson.toJson(posts);
        FileHelpers.WriteInFile(jsonString, POST_FILE);
    }

    public void update(Post post) {
        String postsStrings = FileHelpers.readFile(POST_FILE);
        List<Post> labels = gson.fromJson(postsStrings, new TypeToken<List<Post>>() {
        }.getType());
        Post post1 = labels.stream().filter(l -> l.getId().equals(post.getId())).findAny().get();
        post1.setName(post.getName());
        String jsonString = gson.toJson(labels);
        FileHelpers.WriteInFile(jsonString, POST_FILE);
    }

    public void delete(Long id) {
        String postsStrings = FileHelpers.readFile(POST_FILE);
        List<Post> posts = gson.fromJson(postsStrings, new TypeToken<List<Post>>() {
        }.getType());
        posts.removeIf(post -> post.getId().equals(id));
        String jsonString = gson.toJson(posts);
        FileHelpers.WriteInFile(jsonString, POST_FILE);
    }
}
