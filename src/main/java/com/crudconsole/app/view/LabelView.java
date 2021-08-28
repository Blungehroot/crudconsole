package com.crudconsole.app.view;

import com.crudconsole.app.controller.LabelController;

import java.util.Scanner;

public class LabelView {
    LabelController labelController;
    Scanner sc;

    private final String menu = "Select action on label:\n" +
            "1. Add new label\n" +
            "2. Edit label\n" +
            "3. Display all labels\n" +
            "4. Display selected label\n" +
            "5. Delete label\n" +
            "6. Exit";

    private final String createMsg = "Creating label.\n";
    private final String editMsg = "Edit label.\n";
    private final String displayAllMsg = "Display all labels\n";
    private final String displayTargetMsg = "Display selected label.\n";
    private final String deleteMsg = "Delete label.\n";

    public LabelView(LabelController labelController, Scanner sc) {
        this.labelController = labelController;
        this.sc = sc;
    }

    void create() {
        System.out.println("Input label name");
        String name = sc.next();
        System.out.println(createMsg);
        labelController.create(name);
    }

    void update() {

    }

    void delete() {

    }

    void printSelected() {
        System.out.println("Input label id: ");
        String id = sc.next();
        System.out.println(displayTargetMsg);
        labelController.getById(Long.valueOf(id));
    }

    void printAll() {
        System.out.println(displayAllMsg);
        labelController.getAll();
    }

    void show() {

    }
}
