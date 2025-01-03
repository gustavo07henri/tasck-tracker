package com.tasktracker;

import static java.lang.System.exit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cli {

    private Object options[];
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
    public Object[] optionsForUser(){
        Scanner input = new Scanner(System.in);

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
        String option = input.nextLine();
        this.options = option.split(" ");
        
        return this.options;
    }

    // metodo feito para selecionara a opção desejada pelo usuário
    public void Switch(){
        String index1OfOptions = (String) options[0];
        int index2OfOptionsINT = -1;
        String index2OfOptionsSTRING = "";
        String index3OfOptionsSTRING = "";

        // else if responsavel por fazer a tentativa do cast sem quebrar o programa
        // instanceof verifica se o cast é possivel, retornando boolean
        try {
            if(options[1] instanceof Integer){
                index2OfOptionsINT = (int) options[1];
            }else if(options[1] instanceof String){
                index2OfOptionsSTRING = (String) options[1];
            }else if(options[2] instanceof String){
                index3OfOptionsSTRING = (String) options[2];
            }
        } catch (Exception e) {
            // TODO: handle exception
        }        

        switch (index1OfOptions) {
            case "add" -> add(this.tasks, index2OfOptionsSTRING);
            case "update" -> update(index2OfOptionsINT, index3OfOptionsSTRING);
            case "delete" -> delete(index2OfOptionsINT);
            case "mark-todo" -> markToDo(index2OfOptionsINT);
            case "mark-in-progress" -> markInProgress(index2OfOptionsINT);
            case "mark-done" -> markInDone(index2OfOptionsINT);
            case "list" -> list();
            case "list-todo" -> listToDo(tasks);
            case "list-in-progress" -> listInProgress(tasks);
            case "list-done" -> listDone(tasks);
            case "exit" -> Exit();
            default -> System.out.println("Invalid option insert!!!!");
        }
    }

    public void add(ArrayList<Task> tasks, String index2OfOptionsSTRING){
        // utiliza operador ternário para atribuir valor ao id
        // caso o array estiver vazio o id = 0, caso contrario recebe o valor do ultimo id somado com 1
        // curiosidade é possivel chamar o metodo de uma classe presente em um array sem que precise instacia-lo
        int id = tasks.isEmpty() ? 0 : tasks.get(tasks.size() - 1).getId() + 1;
        String description = index2OfOptionsSTRING;
        String status = "";
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
    public void markInProgress(int index2OfOptionsINT){

        try {
            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == index2OfOptionsINT){
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
    public void markInDone(int index2OfOptionsINT){
       
        try {
            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == index2OfOptionsINT){
                    
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
    public void markToDo(int index2OfOptionsINT){
        try {
            for (Task iterable_element : tasks) {
                if(iterable_element.getId() == index2OfOptionsINT){
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
    public void list (){
        try {
            for (Task task : this.tasks) {
                System.out.println(task.toString());
            }
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
    }
    public void listDone(ArrayList<Task> tasks){
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
    public void listToDo(ArrayList<Task> tasks){
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
    public void listInProgress(ArrayList<Task> tasks){
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
    public void delete(int index){
        for (Task task : this.tasks) {
            if(task.getId() == index){
                this.tasks.remove(task);
                break;
            }
        }
        list();
    }
    public void update(int index2OfOptionsINT, String index3OfOptionsSTRING){
        for (Task task : this.tasks) {
            if(task.getId() == index2OfOptionsINT){
                task.setDescription(index3OfOptionsSTRING);
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