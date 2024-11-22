package com.tasktracker;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAT;
    private LocalDateTime updatedAT;

    public Task(){}
    public Task(int id, String description, String status, LocalDateTime createdAT, LocalDateTime updatedAT){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAT = createdAT;
        this.updatedAT = updatedAT;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
    public LocalDateTime getCreatedAT() {
        return createdAT;
    }
    public void setUpdatedAT(LocalDateTime updatedAT) {
        this.updatedAT = updatedAT;
    }
    public LocalDateTime getUpdatedAT() {
        return updatedAT;
    }
    public String toString() {
        return "Task{" +
                "\nid= " + id +
                "\n, description= '" + description + '\'' +
                "\n, status= '" + status + '\'' +
                "\n, createdAT= " + createdAT +
                "\n, updatedAT= " + updatedAT +
                '}';
    }
}
