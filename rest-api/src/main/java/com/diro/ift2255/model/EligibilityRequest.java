package com.diro.ift2255.model;

import java.util.List;

public class EligibilityRequest {

    private List<String> completedCourses;
    private String cycle;

    public List<String> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(List<String> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}