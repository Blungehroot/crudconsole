package com.crudconsole.app.repository;

import com.crudconsole.app.helpers.FileHelpers;
import com.crudconsole.app.model.Label;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
public class LabelRepositoryImpl implements LabelRepository {
    private static final String LABEL_FILE = "labels.json";

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Long generateMaxId(List<Label> allExistingLabels) {
        Long id = Collections.max(allExistingLabels, Comparator.comparing(l -> l.getId())).getId();
        return id + 1;
    }

    public Label getById(Long id) {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        List<Label> labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
        }.getType());
        return labels.stream().filter(l -> l.getId().equals(id)).findAny().get();
    }

    public List<Label> getAll() {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        System.out.println(labelsStrings);
        return gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
        }.getType());
    }

    public void save(Label label) {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        List<Label> labels = new ArrayList<>();
        if (labelsStrings.isEmpty()) {
            label.setId(1L);
            labels.add(label);
        } else {
            labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
            }.getType());
            label.setId(generateMaxId(labels));
            labels.add(label);
        }
        String jsonString = gson.toJson(labels);
        FileHelpers.WriteInFile(jsonString, LABEL_FILE);
    }

    public void update(Label label) {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        List<Label> labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
        }.getType());
        Label label1 = labels.stream().filter(l -> l.getId().equals(label.getId())).findAny().get();
        label1.setName(label.getName());
        String jsonString = gson.toJson(labels);
        FileHelpers.WriteInFile(jsonString, LABEL_FILE);
    }

    public void delete(Long id) {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        List<Label> labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
        }.getType());
        labels.removeIf(label -> label.getId().equals(id));
        String jsonString = gson.toJson(labels);
        FileHelpers.WriteInFile(jsonString, LABEL_FILE);
    }
}
