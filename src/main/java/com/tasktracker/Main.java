package com.tasktracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cli cli = new Cli();
        cli.startCli();
        /* 
        ArrayList<Task> tasks = new JsonConverter().deserialization();
        Scanner input = new Scanner(System.in);
        
        for (Task iterable_element : tasks) {
            System.out.println(iterable_element.toString());
        }

        while (true) {
            String inputUser = input.nextLine();
            switch (inputUser) {
                case "add":
                    ConstrucaoTask(input, tasks);
                    break;
                case "mark-in-progress":
                    markInProgress(input, tasks);
                    break;
                case "mark-done":
                    markInDone(input, tasks);
                    break;
                case "list":
                    list(tasks);
                    break;
                case "list-Done":
                    listDone(tasks);
                    break;
                case "list-ToDo":
                    listToDo(tasks);
                    break;
                case "list-InProgress":
                    listInProgress(tasks);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid insertion");
                    break;
            }
        }
        */
    }
    /*
    public static void ConstrucaoTask(Scanner input, ArrayList<Task> tasks){
        Task task1 = new Task();
        int id = 0;
        if(tasks.size() != 0){
            int ultimoIndex = tasks.size() -1;
            id = tasks.get(ultimoIndex).getId() +1;
        }
        String description;
        String status = "To-Do";
        String createdAT;
        String updatedAT;

        description = input.nextLine();

        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatedDate = timeNow.format(formatter);
        createdAT = formatedDate;   
        updatedAT = formatedDate;

        Task task = new Task(id, description, status, createdAT, updatedAT);
        tasks.add(task);
        JsonConverter JsonConverter = new JsonConverter();
        JsonConverter.Serialization(tasks);

        System.out.printf("Description of Task: %s [%d]\n",description, id);
    }
    public static void markInProgress(Scanner input, ArrayList<Task> tasks){
    
        int idUserInput = input.nextInt();
        try {
            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == idUserInput){
                    LocalDateTime timeNow = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String formatedDate = timeNow.format(formatter);
                    String updatedAt = formatedDate;   

                    iterable_element.setStatus("In-Progress");
                    iterable_element.setUpdatedAT(updatedAt);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!! "+ e );
        }
    }
    public static void markInDone(Scanner input, ArrayList<Task> tasks){
        input.nextLine();
        int idUserInput = input.nextInt();
        try {
            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == idUserInput){
                    
                    LocalDateTime timeNow = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String formatedDate = timeNow.format(formatter);
                    String updatedAt = formatedDate;

                    iterable_element.setStatus("Done");
                    iterable_element.setUpdatedAT(updatedAt);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!! "+ e );
        }
    }
    public static void list (ArrayList<Task> tasks){
        try {
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
    public static void listDone(ArrayList<Task> tasks){
        try {
            for (Task task : tasks) {
                if(task.getStatus().equals("Done")){
                    System.out.println(task.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
    public static void listToDo(ArrayList<Task> tasks){
        try {
            for (Task task : tasks) {
                if(task.getStatus().equals("To-Do")){
                    System.out.println(task.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
    public static void listInProgress(ArrayList<Task> tasks){
        try {
            for (Task task : tasks) {
                if(task.getStatus().equals("In-Progress")){
                    System.out.println(task.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
        */
}
    