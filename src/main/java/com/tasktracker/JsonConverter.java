package com.tasktracker;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

        private final ObjectMapper objectMapper = new ObjectMapper();
        private final String caminhoArquivo = "Task.json";
        private final File arquivoJson = new File(caminhoArquivo);

        private ArrayList<Task> tasks = new ArrayList<>();

        public void setTasks(ArrayList<Task> tasks) {
            this.tasks = tasks;
            Serialization(tasks);
        }
        public ArrayList<Task> getTasks() {
            return tasks;
        }

        public JsonConverter(){
            try {
                if(!arquivoJson.exists()){
                    if(arquivoJson.createNewFile()){
                        
                    }else{
                        System.out.println("Erro ao criar arquivo");
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro de execução!!!" + e);
            }
        }
        public void Serialization(ArrayList<Task> tasks){
            
            try {
                objectMapper.writeValue(arquivoJson, tasks);
            } catch (Exception e) {
                System.out.println("Error!!! " + e);
            }
        }
        public ArrayList<Task> deserialization(){
            try {
                
                this.tasks = objectMapper.readValue(arquivoJson, new TypeReference<ArrayList<Task>>(){});
                return this.tasks;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            
        }
}

