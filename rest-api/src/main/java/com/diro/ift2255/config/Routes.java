package com.diro.ift2255.config;

import io.javalin.Javalin;
import com.diro.ift2255.controller.*;
import com.diro.ift2255.service.*;
import com.diro.ift2255.util.HttpClientApi;

public class Routes {

    public static void register(Javalin app) {
        // --- Page d'accueil stylisée ---
        app.get("/", ctx -> ctx.html("""
            <!DOCTYPE html>
            <html lang="fr">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>API REST IFT2255</title>
                <style>
                    body {
                        font-family: Arial, Helvetica, sans-serif;
                        background-color: #f6f8fa;
                        color: #222;
                        margin: 0;
                        padding: 0;
                    }
                    .container {
                        max-width: 800px;
                        margin: 60px auto;
                        background: white;
                        padding: 30px 40px;
                        border-radius: 12px;
                        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                    }
                    h1 {
                        color: #2563eb;
                        font-size: 28px;
                        text-align: center;
                        margin-bottom: 20px;
                    }
                    p {
                        text-align: center;
                        font-size: 18px;
                        color: #444;
                    }
                    ul {
                        list-style-type: none;
                        padding-left: 0;
                        margin-top: 25px;
                    }
                    li {
                        background: #eef2ff;
                        margin: 10px 0;
                        padding: 12px 16px;
                        border-radius: 8px;
                        transition: background 0.3s;
                    }
                    li:hover {
                        background: #dbeafe;
                    }
                    code {
                        color: #0d9488;
                        font-weight: bold;
                    }
                    footer {
                        text-align: center;
                        margin-top: 40px;
                        font-size: 14px;
                        color: #777;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Bienvenue sur l’API REST </h1>
                    <p>API universitaire – projet de gestion des cours et avis étudiants</p>

                    <ul>
                        <li><code>GET /courses</code> — Liste des cours (Planifium)</li>
                        <li><code>GET /courses/{id}</code> — Détails d’un cours</li>
                        <li><code>GET /courses/compare?ids=IFT2255,MAT1400</code> — Comparer plusieurs cours</li>
                        <li><code>GET /users</code> — Liste des utilisateurs</li>
                        <li><code>GET /users/{id}</code> — Détails d’un utilisateur</li>
                        <li><code>POST /api/avis</code> — Ajouter un avis (via Discord)</li>
                        <li><code>GET /api/avis</code> — Voir les avis sauvegardés</li>
                    </ul>

                    <footer>
                        <p>IFT2255 - Université de Montréal © 2025</p>
                    </footer>
                </div>
            </body>
            </html>
        """));

        // --- Routes REST ---
        CourseService courseService = new CourseService(new HttpClientApi());
        CourseController courseController = new CourseController(courseService);
        app.get("/courses", courseController::getAllCourses);
        app.get("/courses/{id}", courseController::getCourseById);
        app.get("/courses/compare", courseController::compareCourses);

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