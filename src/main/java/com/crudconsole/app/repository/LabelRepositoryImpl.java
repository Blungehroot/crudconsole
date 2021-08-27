package com.crudconsole.app.repository;

import com.crudconsole.app.helpers.FileHelpers;
import com.crudconsole.app.model.Label;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class LabelRepositoryImpl implements LabelRepository {
    private static final String LABEL_FILE = "labels.json";

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Label getById(Long id) {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        List<Label> labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
        }.getType());
        Label label = labels.stream().filter(l -> l.getId().equals(id)).findAny().get();
        System.out.println(label);
        return label;
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
            labels.add(label);
        } else {
            labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
            }.getType());
            labels.add(label);
        }
        String jsonString = gson.toJson(labels);
        FileHelpers.WriteInFile(jsonString, LABEL_FILE);
    }

    public void update(Label label) {
        delete(label.getId());
        save(label);
    }

    public void delete(Long id) {
        String labelsStrings = FileHelpers.readFile(LABEL_FILE);
        List<Label> labels = gson.fromJson(labelsStrings, new TypeToken<List<Label>>() {
        }.getType());
        labels.removeIf(label -> label.getId().equals(id));
        String jsonString = gson.toJson(labels);
        FileHelpers.WriteInFile(jsonString, LABEL_FILE);
    }

    public static void main(String[] args) {
        Label label = new Label();
        Label label2 = new Label();
        label.setName("Kek");
        label2.setName("Kek2");
        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        labelRepository.save(label);
        labelRepository.save(label2);
    }
}
