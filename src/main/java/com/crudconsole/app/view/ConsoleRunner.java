package com.crudconsole.app.view;

import com.crudconsole.app.controller.LabelController;
import com.crudconsole.app.repository.LabelRepositoryImpl;

import java.util.Scanner;

public class ConsoleRunner {
    LabelView labelView;

    private Scanner sc = new Scanner(System.in);
    private static final String msg = "Select action:\n" +
            "1. Actions with labels.\n" +
            "2. Exit.";

    public ConsoleRunner() {
        LabelRepositoryImpl labelRepository = new LabelRepositoryImpl();
        LabelController labelController = new LabelController(labelRepository);
        labelView = new LabelView(labelController, sc);
    }

    public void run()  {
        boolean isExit = false;
        System.out.println(msg);
        while (true) {
            String action = sc.next();
            switch (action)
            {
                case "1":
                    labelView.show();
                    System.out.println(msg);
                    break;
                case "2":
                    isExit = true;
                    break;
                default:
                    System.out.println("some error occurred");
                    break;
            }
            if (isExit)
                break;
        }
        sc.close();
    }
}
