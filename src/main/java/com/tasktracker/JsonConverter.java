package com.tasktracker;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

        ObjectMapper objectMapper = new ObjectMapper();
        String caminhoArquivo = "Task.json";
        File arquivoJson = new File(caminhoArquivo);
        Task task = new Task();

        public JsonConverter(){
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
        }
        public void Serialization(Task task){
            try {
                objectMapper.writeValue(arquivoJson, task);;
            } catch (Exception e) {
                System.out.println("Error!!! " + e);
            }
        }
        public Task deserialization(){
            try {
                String json = objectMapper.writeValueAsString(task);
                Task task = objectMapper.readValue(json, Task.class);
                return task;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            
        }
}

