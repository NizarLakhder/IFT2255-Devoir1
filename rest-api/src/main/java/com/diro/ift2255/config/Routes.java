package com.diro.ift2255.config;

import io.javalin.Javalin;
import com.diro.ift2255.controller.*;
import com.diro.ift2255.service.*;
import com.diro.ift2255.util.HttpClientApi;

public class Routes {

    public static void register(Javalin app) {
        // --- Page d'accueil stylisée ---
        

        // --- Routes REST ---
        CourseService courseService = new CourseService(new HttpClientApi());
        CourseController courseController = new CourseController(courseService);
        app.get("/courses/compare", courseController::compareCourses);
app.get("/courses", courseController::getAllCourses);
app.get("/courses/{id}", courseController::getCourseById);

        UserService userService = new UserService();
        UserController userController = new UserController(userService);
        app.get("/users", userController::getAllUsers);
        app.get("/users/{id}", userController::getUserById);

        AvisService avisService = new AvisService();
        AvisController avisController = new AvisController(avisService);
        app.post("/api/avis", avisController::addAvis);
        app.get("/api/avis", avisController::getAllAvis);
    }
}