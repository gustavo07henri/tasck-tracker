package com.tasktracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        JsonConverter jsonConverter = new JsonConverter();
        
        

       while (true) {
            for (Task task : tasks) {
                jsonConverter.Serialization(task);
            }
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
                case "exit":
                    return;
                default:
                    System.out.println("Invalid insertion");
                    break;
        }
       }

    }
    public static void ConstrucaoTask(Scanner input, ArrayList<Task> tasks){
        Task task1 = new Task();
        int id = task1.getId() + 1;
        task1.setLastId(id);
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
        JsonConverter.Serialization(task);
    }
    public static void markInProgress(Scanner input, ArrayList<Task> tasks){
    
        int idUserInput = input.nextInt();
        try {
            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == idUserInput){
                    iterable_element.setStatus("In-Progress");
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
                    iterable_element.setStatus("Done");
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
}