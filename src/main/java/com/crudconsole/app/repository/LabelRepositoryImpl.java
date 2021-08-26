package com.crudconsole.app.repository;

import com.crudconsole.app.helpers.FileHelpers;
import com.crudconsole.app.model.Label;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class LabelRepositoryImpl implements LabelRepository {
    private static final String LABEL_FILE = "labels.json";

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Label getById(Long id) {
        return null;
    }

    public List<Label> getAll() {
        return null;
    }

    public void save(Label label) {
        String jsonString = gson.toJson(label);
        System.out.println(jsonString);
        FileHelpers.WriteInFile(jsonString, LABEL_FILE);
    }

    public Label update(Label label) {
        return null;
    }

    public void delete(Long id) {

    }

    public static void main(String[] args) {
        Label label = new Label();
        label.setId(1L);
        label.setName("Kek");
        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        labelRepository.save(label);
    }
}
