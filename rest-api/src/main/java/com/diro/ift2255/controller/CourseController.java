package com.diro.ift2255.controller;

import io.javalin.http.Context;
import com.diro.ift2255.model.Course;
import com.diro.ift2255.service.CourseService;
import com.diro.ift2255.model.EligibilityRequest;
import com.diro.ift2255.model.EligibilityResult;
import java.util.List;
import java.util.Map;

public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public void searchCourses(Context ctx) {
    getCourses(ctx);
}
    
    
    /**
 * POST /courses/{id}/eligibility
 */
public void checkEligibility(Context ctx) {

    String courseId = ctx.pathParam("id");

    EligibilityRequest request =
            ctx.bodyAsClass(EligibilityRequest.class);

    Course course = courseService.fetchCourseById(
            courseId,
            false,
            null,
            "full"
    );

    EligibilityResult result =
            courseService.checkEligibility(course, request);

    ctx.json(result);
}











/**
     * GET /courses
     * Exemples :
     *  - /courses?courses_sigle=ift1015,ift1025
     *  - /courses?name=logiciel
     *  - /courses?description=java
     *  - /courses?courses_sigle=ift1015&include_schedule=true
     *  - /courses?courses_sigle=ift1015&include_schedule=true&schedule_semester=a25
     */
    public void getCourses(Context ctx) {

    // ==========================
    // PARAMÈTRES FRONTEND (WRAPPER)
    // ==========================

    // Paramètre simplifié côté frontend
    String ids = ctx.queryParam("ids");

    // Paramètres Planifium natifs (compatibilité)
    String coursesSigle = ctx.queryParam("courses_sigle");
    String name = ctx.queryParam("name");
    String description = ctx.queryParam("description");

    // Priorité au paramètre frontend "ids"
    if (ids != null && !ids.isBlank()) {
        coursesSigle = ids;
    }

    // include_schedule (false par défaut)
    boolean includeSchedule =
            "true".equalsIgnoreCase(ctx.queryParam("include_schedule"));

    // schedule_semester (optionnel)
    String semester = ctx.queryParam("schedule_semester");

    // response_level (reg par défaut)
    String responseLevel = ctx.queryParam("response_level");
    if (responseLevel == null || responseLevel.isBlank()) {
        responseLevel = "reg";
    }

   
    
   
   
   
   
   
   
    // ==========================
    // APPEL AU SERVICE
    // ==========================
    List<Course> courses = courseService.fetchCourses(
            coursesSigle,
            name,
            description,
            includeSchedule,
            semester,
            responseLevel
    );

    // ==========================
    // RÉPONSE HTTP
    // ==========================
    if (courses.isEmpty()) {
        ctx.status(404).json(
                Map.of("message", "Aucun cours trouvé")
        );
    } else {
        ctx.json(courses);
    }
}
    /**
     * GET /courses/{id}
     * Exemples :
     *  - /courses/ift2255
     *  - /courses/ift2255?include_schedule=true
     *  - /courses/ift2255?include_schedule=true&schedule_semester=a25
     */
    public void getCourseById(Context ctx) {

        String id = ctx.pathParam("id");

        boolean includeSchedule =
                "true".equalsIgnoreCase(ctx.queryParam("include_schedule"));

        String semester = ctx.queryParam("schedule_semester");

        String responseLevel = ctx.queryParam("response_level");
        if (responseLevel == null) {
            responseLevel = "reg";
        }

        Course course = courseService.fetchCourseById(
                id,
                includeSchedule,
                semester,
                responseLevel
        );

        if (course == null) {
            ctx.status(404).json(
                    Map.of("message", "Cours " + id + " non trouvé")
            );
        } else {
            ctx.json(course);
        }
    }

    /**
     * GET /courses/compare?ids=IFT1015,IFT1025
     */
    public void compareCourses(Context ctx) {

        String idsParam = ctx.queryParam("ids");

        if (idsParam == null || idsParam.isBlank()) {
            ctx.status(400).json(
                    Map.of("error", "Paramètre ids manquant (ex: ?ids=IFT1015,IFT1025)")
            );
            return;
        }

        String[] sigles = idsParam.split(",");

        List<Course> courses = courseService.getCoursParCodes(sigles);

        if (courses.isEmpty()) {
            ctx.status(404).json(
                    Map.of("message", "Aucun cours trouvé pour la comparaison")
            );
        } else {
            ctx.json(courses);
        }
    }
}