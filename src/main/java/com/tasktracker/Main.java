package com.tasktracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        JsonConverter jsonConverter = new JsonConverter();
        ConstrucaoTask(input, tasks);

        for (Task iterable_element : tasks) {
            jsonConverter.Serialization(iterable_element);
        }
        Task task = jsonConverter.deserialization();
        task.toString();

    }
    public static void ConstrucaoTask(Scanner input, ArrayList<Task> tasks){
        int id;
        String description;
        String status = "";
        LocalDateTime createdAT;
        LocalDateTime updatedAT;

        id = new Random().nextInt(1000+1);
        System.out.print("Insert the description of Task: ");
        description = input.nextLine();
        System.out.println("""
            Choose the option for status of your Task
            1. Done.
            2. To-Do.
            3. In-Progress.
            """);
        int option = input.nextInt();
        switch (option) {
            case 1:
                status = "done";
                break;
            case 2:
                status = "to-do";
                break;
            case 3:
                status = "in-progress";
                break;
            default:
                System.out.println("Incorrect option insert!!!");
                break;
        }
        createdAT = LocalDateTime.now();
        updatedAT = LocalDateTime.now();

        Task task = new Task(id, description, status, createdAT, updatedAT);
        tasks.add(task);
    }
    
}