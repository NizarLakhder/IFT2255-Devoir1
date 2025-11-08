package com.diro.ift2255.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
    private String id;
    private String name;
    private String description;
    private double credits;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCredits() { return credits; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCredits(double credits) { this.credits = credits; }
}
    
