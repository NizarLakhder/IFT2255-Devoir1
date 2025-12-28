package com.diro.ift2255.config;

import io.javalin.Javalin;
import com.diro.ift2255.controller.*;
import com.diro.ift2255.service.*;
import com.diro.ift2255.util.HttpClientApi;
import com.diro.ift2255.service.ProgramService;
import com.diro.ift2255.controller.ProgramController;
public class Routes {

    public static void register(Javalin app) {

    CourseService courseService = new CourseService(new HttpClientApi());
    CourseController courseController = new CourseController(courseService);
    ProgramService programService =
        new ProgramService(new HttpClientApi());
ProgramController programController =
        new ProgramController(programService);

app.get("/programs/{programId}", programController::getProgram);
    
    app.get("/courses/search", courseController::searchCourses);

    app.get("/courses/compare", courseController::compareCourses);
    app.get("/courses", courseController::getCourses);
    app.get("/courses/{id}", courseController::getCourseById);
   
    app.post("/courses/{id}/eligibility",
        courseController::checkEligibility);

    UserService userService = new UserService();
    UserController userController = new UserController(userService);
    app.get("/users", userController::getAllUsers);
    app.get("/users/{id}", userController::getUserById);

    AvisService avisService = new AvisService();
    AvisController avisController = new AvisController(avisService);
    app.post("/api/avis", avisController::addAvis);
    app.get("/api/avis", avisController::getAllAvis);
    app.get("/api/avis/{course}", avisController::getAvisByCourse);


    ResultatService resultatService = new ResultatService();
    ResultatController resultatController =
    new ResultatController(resultatService);

    app.get("/results/{sigle}", resultatController::getResultatByCourse);
   

}
}