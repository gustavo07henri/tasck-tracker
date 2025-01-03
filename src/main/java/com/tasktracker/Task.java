package com.tasktracker;

public class Task {
    private int id;
    private String description;
    private String status;
    private String createdAT;
    private String updatedAT;

    public Task(){}
    public Task(int id, String description, String status, String createdAT, String updatedAT){
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
    public String getCreatedAT() {
        return createdAT;
    }
    public void setUpdatedAT(String updatedAT) {
        this.updatedAT = updatedAT;
    }
    public String getUpdatedAT() {
        return updatedAT;
    }
    @Override
    public String toString() {
        return "Task Details:\n" +
                "  ID: " + id + "\n" +
                "  Description: " + description + "\n" +
                "  Status: " + status + "\n" +
                "  Created At: " + createdAT + "\n" +
                "  Updated At: " + updatedAT + "\n";
    }

    public String toJson(){
        return "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"createdAT\": \"" + createdAT + "\",\n" +
                "  \"updatedAT\": \"" + updatedAT + "\"\n" +
                "}";
    }
}

