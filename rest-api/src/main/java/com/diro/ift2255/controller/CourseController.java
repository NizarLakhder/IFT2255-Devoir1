package com.diro.ift2255.controller;

import io.javalin.http.Context;
import com.diro.ift2255.model.Course;
import com.diro.ift2255.service.CourseService;
import java.util.*;

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // /courses?sigle=IFT
    public void getAllCourses(Context ctx) {
        String sigle = ctx.queryParam("sigle");
        if (sigle == null) sigle = "";
        List<Course> courses = courseService.getAllCourses(sigle);

        if (courses.isEmpty()) {
            ctx.status(404).json(Map.of("message", "Aucun cours trouvé pour le sigle " + sigle));
        } else {
            ctx.json(courses);
        }
    }

    // /courses/IFT2255
    public void getCourseById(Context ctx) {
        String id = ctx.pathParam("id");
        Course course = courseService.getCourseById(id);

        if (course != null) {
            ctx.json(course);
        } else {
            ctx.status(404).json(Map.of("message", "Cours " + id + " non trouvé"));
        }
    }

    // /courses/compare?ids=IFT2255,MAT1400
    public void compareCourses(Context ctx) {
        String idsParam = ctx.queryParam("ids");

        if (idsParam == null || idsParam.isBlank()) {
            ctx.status(400).json(Map.of("error", "Paramètre 'ids' manquant (ex: ?ids=IFT2255,MAT1400)"));
            return;
        }

        String[] sigles = idsParam.split(",");
        List<Course> courses = courseService.getCoursParCodes(sigles);

        if (courses.isEmpty()) {
            ctx.status(404).json(Map.of("message", "Aucun cours trouvé pour la comparaison"));
        } else {
            ctx.json(courses);
        }
    }
}