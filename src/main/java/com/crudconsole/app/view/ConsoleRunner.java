package com.crudconsole.app.view;

import com.crudconsole.app.controller.LabelController;
import com.crudconsole.app.controller.PostController;
import com.crudconsole.app.repository.gson.GsonLabelRepositoryImpl;
import com.crudconsole.app.repository.gson.GsonPostRepositoryImpl;

import java.util.Scanner;

public class ConsoleRunner {
    private final LabelView labelView;
    //private final PostView postView;

    private Scanner sc = new Scanner(System.in);
    private static final String msg = "Select action:\n" +
            "1. Actions with labels.\n" +
            "2. Actions with posts.\n" +
            "3. Exit.";

    public ConsoleRunner() {
        LabelController labelController = new LabelController();
        labelView = new LabelView(labelController, sc);

        GsonPostRepositoryImpl postRepository = new GsonPostRepositoryImpl();
        PostController postController = new PostController(postRepository);
        //postView = new PostView(postController, sc);
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
                /*case "2":
                    postView.show();
                    System.out.println(msg);
                    break;*/
                case "3":
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
