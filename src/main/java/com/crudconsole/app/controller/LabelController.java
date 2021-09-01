package com.crudconsole.app.controller;

import com.crudconsole.app.model.Label;
import com.crudconsole.app.repository.LabelRepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LabelController {
    LabelRepositoryImpl labelRepository;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public LabelController(LabelRepositoryImpl labelRepository) {
        this.labelRepository = labelRepository;
    }

    public String getAll() {
        return gson.toJson(labelRepository.getAll());
    }

    public String getById(Long id) {
        return gson.toJson(labelRepository.getById(id));
    }

    public Label create(String name) {
        Label label = new Label();
        label.setName(name);
        return labelRepository.save(label);
    }

    public Label update(Long id, String name) {
        Label label = new Label();
        label.setId(id);
        label.setName(name);
        return labelRepository.update(label);
    }

    public void delete(Long id) {
        labelRepository.deleteById(id);
    }
}
