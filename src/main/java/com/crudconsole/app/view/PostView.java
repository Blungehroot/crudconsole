//package com.crudconsole.app.view;
//
//import com.crudconsole.app.controller.PostController;
//
//import java.util.Scanner;
//
//public class PostView {
//    PostController postController;
//    Scanner sc;
//
//    private final String menu = "Select action on posts:\n" +
//            "1. Add new post\n" +
//            "2. Display all posts\n" +
//            "3. Display selected post\n" +
//            "4. Delete post\n" +
//            "5. Edit post\n" +
//            "6. Exit";
//
//    private final String createMsg = "Creating post.\n";
//    private final String editMsg = "Edit post.\n";
//    private final String displayAllMsg = "Display all posts\n";
//    private final String displayTargetMsg = "Display selected post.\n";
//    private final String deleteMsg = "Delete post.\n";
//
//    public PostView(PostController postController, Scanner sc) {
//        this.postController = postController;
//        this.sc = sc;
//    }
//
//    void create() {
//        System.out.println("Input post name");
//        String name = sc.next();
//        System.out.println("Input post content");
//        String content = sc.next();
//        //labels lists
//        System.out.println(createMsg);
//        postController.create(name, content);
//    }
//
//    void update() {
//        System.out.println("Input post id");
//        String id = sc.next();
//        System.out.println("Input post name");
//        String name = sc.next();
//        System.out.println("Input post content");
//        String content = sc.next();
//        //labels lists
//        System.out.println(editMsg);
//        postController.update(Long.valueOf(id), name, content);
//    }
//
//    void delete() {
//        System.out.println("Input id to delete post");
//        String id = sc.next();
//        System.out.println(deleteMsg);
//        postController.delete(Long.valueOf(id));
//    }
//
//    void printSelected() {
//        System.out.println("Input post id: ");
//        String id = sc.next();
//        System.out.println(displayTargetMsg);
//        postController.getById(Long.valueOf(id));
//    }
//
//    void printAll() {
//        System.out.println(displayAllMsg);
//        postController.getAll();
//    }
//
//    void show() {
//        boolean isExit = false;
//        System.out.println(menu);
//        while (true) {
//            String action = sc.next();
//            switch (action) {
//                case "1":
//                    create();
//                    System.out.println(menu);
//                    break;
//                case "2":
//                    printAll();
//                    System.out.println(menu);
//                    break;
//                case "3":
//                    printSelected();
//                    System.out.println(menu);
//                    break;
//                case "4":
//                    delete();
//                    System.out.println(menu);
//                    break;
//                case "5":
//                    update();
//                    System.out.println(menu);
//                    break;
//                case "6":
//                    isExit = true;
//                    break;
//                default:
//                    System.out.println("some error occurred");
//                    break;
//            }
//            if (isExit)
//                break;
//        }
//    }
//}
