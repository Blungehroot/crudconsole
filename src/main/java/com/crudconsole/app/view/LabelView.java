package com.crudconsole.app.view;

import com.crudconsole.app.controller.LabelController;

import java.util.Scanner;

public class LabelView {
    LabelController labelController;
    Scanner sc;

    private final String menu = "Select action on label:\n" +
            "1. Add new label\n" +
            "2. Display all labels\n" +
            "3. Display selected label\n" +
            "4. Delete label\n" +
            "5. Edit label\n" +
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
        System.out.println("Input label id");
        String id = sc.next();
        System.out.println("Input label name");
        String name = sc.next();
        System.out.println(editMsg);
        labelController.update(Long.valueOf(id), name);
    }

    void delete() {
        System.out.println("Input id to delete label");
        String id = sc.next();
        System.out.println(deleteMsg);
        labelController.delete(Long.valueOf(id));
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
        boolean isExit = false;
        System.out.println(menu);
        while (true) {
            String action = sc.next();
            switch (action)
            {
                case "1":
                    create();
                    System.out.println(menu);
                    break;
                case "2":
                    printAll();
                    System.out.println(menu);
                    break;
                case "3":
                    printSelected();
                    System.out.println(menu);
                    break;
                case "4":
                    delete();
                    System.out.println(menu);
                    break;
                case "5":
                    update();
                    System.out.println(menu);
                    break;
                case "6":
                    isExit = true;
                    break;
                default:
                    System.out.println("some error occurred");
                    break;
            }
            if (isExit)
                break;
        }
    }
}
