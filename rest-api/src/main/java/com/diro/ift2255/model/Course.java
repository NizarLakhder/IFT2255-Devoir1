package com.diro.ift2255.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {

    private String id;
    private String name;
    private double credits;
    private String description;

    // Champs Planifium
    private Map<String, Boolean> available_terms;
    private Map<String, Boolean> available_periods;

    // Horaires bruts (pas de classe Schedule)
    private List<Object> schedules;

    // --- Getters ---
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCredits() {
        return credits;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Boolean> getAvailable_terms() {
        return available_terms;
    }

    public Map<String, Boolean> getAvailable_periods() {
        return available_periods;
    }

    public List<Object> getSchedules() {
        return schedules;
    }

    // --- Setters ---
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable_terms(Map<String, Boolean> available_terms) {
        this.available_terms = available_terms;
    }

    public void setAvailable_periods(Map<String, Boolean> available_periods) {
        this.available_periods = available_periods;
    }

    public void setSchedules(List<Object> schedules) {
        this.schedules = schedules;
    }
}