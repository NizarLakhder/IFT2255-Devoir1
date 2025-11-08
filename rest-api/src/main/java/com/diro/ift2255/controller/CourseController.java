package com.diro.ift2255.controller;

import io.javalin.http.Context;
import com.diro.ift2255.model.Course;
import com.diro.ift2255.service.CourseService;
import java.util.*;

public class CourseController {

    private final CourseService courseService;

    // ✅ constructeur ajouté pour corriger l'erreur
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public void getAllCourses(Context ctx) {
        Map<String, List<String>> queryParams = ctx.queryParamMap();
        String sigle = queryParams.containsKey("sigle") ? queryParams.get("sigle").get(0) : "";
        List<Course> courses = courseService.getAllCourses(sigle);
        ctx.json(courses);
    }

    public void getCourseById(Context ctx) {
        String id = ctx.pathParam("id");
        Course course = courseService.getCourseById(id);
        if (course != null) {
            ctx.json(course);
        } else {
            ctx.status(404).result("Cours non trouvé");
        }
    }

    public void compareCourses(Context ctx) {
        String[] sigles = ctx.queryParam("ids").split(",");
        List<Course> courses = courseService.getCoursParCodes(sigles);
        ctx.json(courses);
    }
}