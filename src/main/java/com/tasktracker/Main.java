package com.tasktracker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String caminhoArquivo = "Task.json";
        File arquivoJson = new File(caminhoArquivo);
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        try {
            if(!arquivoJson.exists()){
                if(arquivoJson.createNewFile()){
                    System.out.println("Arquivo criado.");
                }else{
                    System.out.println("Erro ao criar arquivo");
                }
            }else{
                System.out.println("Arquivo já existe!!!");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro de execução!!!" + e);
        }

        /*
        try {
            objectMapper.writeValue(arquivoJson, newTask);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erro de execução!!!" + e);
        }
        */
        System.out.println("""
                1. Add, Update, and Delete tasks
                2. Mark a task as in progress or done
                3. List all tasks
                4. List all tasks that are done
                5. List all tasks that are not done
                6. List all tasks that are in progress
                7. Exit.
                """);
        System.out.print("Choose one option: ");
        int entradaUsuario = input.nextInt();

        switch (input) {
            case value:
                
                break;
        
            default:
                break;
        }
    }
    
    
}