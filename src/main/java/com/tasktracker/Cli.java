package com.tasktracker;

import static java.lang.System.exit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cli {

    private Scanner input = new Scanner(System.in);
    private String option;
    private ArrayList<Task> tasks = new JsonConverter().deserialization();

    // metodo utilizao para iniciar o metodo CLI para o usuario (tirar essa responsabilidade da classe Main)
    public void startCli(){
        while (true) {
            optionsForUser();
            Switch();
        }
    }
    
    // metodo que exibe as opções que o usuário pode escolher, ela retorna um array de objetos 
    // posteriormente faço o cast deste dos objetos presentes para o tipo primitivo desejado
    public String optionsForUser(){

        System.out.println("""
                - add [description] : Add a new task
                - update [id] [description] : Update a task
                - delete [id] : Delete a task
                - mark-todo [id] : Mark a task as Todo
                - mark-in-progress [id] : Mark a task as In-Progress
                - mark-done [id] : Mark a task as Done
                - list : List all tasks
                - list-todo : List all Todo tasks
                - list-in-progress : List all In-Progress tasks
                - list-done : List all Done tasks
                - exit : Exit the program
                """);
            option = input.nextLine();
        
        
        return option;
    }

    // metodo feito para selecionara a opção desejada pelo usuário
    public void Switch(){
        

        switch (option) {
            case "add" -> add();
            case "update" -> update();
            case "delete" -> delete();
            case "mark-todo" -> markToDo();
            case "mark-in-progress" -> markInProgress();
            case "mark-done" -> markInDone();
            case "list" -> list();
            case "list-todo" -> listToDo();
            case "list-in-progress" -> listInProgress();
            case "list-done" -> listDone();
            case "exit" -> Exit();
            default -> System.out.println("Invalid option insert!!!!");
        }
    }

    public void add(){
        // utiliza operador ternário para atribuir valor ao id
        // caso o array estiver vazio o id = 0, caso contrario recebe o valor do ultimo id somado com 1
        // curiosidade é possivel chamar o metodo de uma classe presente em um array sem que precise instacia-lo
        int id = tasks.isEmpty() ? 0 : tasks.get(tasks.size() - 1).getId() + 1;
        String description = input.nextLine().trim();
        String status = "To-Do";
        String createdAT;
        String updatedAT;

        // bloco responsavel por atribuir data a criação da task
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatedDate = timeNow.format(formatter);
        createdAT = formatedDate;   
        updatedAT = formatedDate;

        Task task = new Task(id, description, status, createdAT, updatedAT);
        tasks.add(task);
        System.out.printf("Created successfully  ID: [%d]\n",id);
        System.out.println(tasks.size());
    }
    public void markInProgress(){
        
        try {
            int id = Integer.parseInt(input.nextLine().trim());

            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == id){
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
    public void markInDone(){
       
        try {
            int id = Integer.parseInt(input.nextLine().trim());

            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == id){
                    
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
    public void markToDo(){
        try {
            int id = Integer.parseInt(input.nextLine().trim());

            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == id){
                    LocalDateTime timeNow = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String formatedDate = timeNow.format(formatter);
                    String updatedAt = formatedDate;   

                    iterable_element.setStatus("To-Do");
                    iterable_element.setUpdatedAT(updatedAt);
                }
            }
        } catch (Exception e) {
            System.out.println("Error!! "+ e );
        }
    }
    public void list (){
        try {
            for (Task task : this.tasks) {
                System.out.println(task.toString());
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
    public void listDone(){
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
    public void listToDo(){
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
    public void listInProgress(){
        
        try {
            for (Task task : this.tasks) {
                if(task.getStatus().equals("In-Progress")){
                    System.out.println(task.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
    public void delete(){

        int index = Integer.parseInt(input.nextLine().trim());

        for (Task task : this.tasks) {
            if(task.getId() == index){
                this.tasks.remove(task);
                break;
            }
        }
        list();
    }
    public void update(){

        int id = Integer.parseInt(input.nextLine().trim());
        String description = input.nextLine().trim();

        for (Task task : this.tasks) {
            if(task.getId() == id){
                task.setDescription(description);
                break;
            }
        }
        list();
    }
    public void Exit(){
        JsonConverter json = new JsonConverter();
        json.setTasks(tasks);
        exit(0);
    }
}