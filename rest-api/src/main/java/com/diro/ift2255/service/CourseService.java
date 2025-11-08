package com.diro.ift2255.service;

import com.diro.ift2255.model.Course;
import com.diro.ift2255.util.HttpClientApi;
import com.diro.ift2255.util.HttpClientApiResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.*;

public class CourseService {
    private final HttpClientApi httpClient;
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String BASE_URL = "https://planifium-api.onrender.com/api/v1/courses";

    public CourseService(HttpClientApi httpClient) {
        this.httpClient = httpClient;
    }

    // Recherche un cours par sigle (ex: IFT2255)
    public List<Course> rechercherCours(String sigle) {
        try {
            String url = BASE_URL + "?sigle=" + sigle;
            HttpClientApiResponse response = httpClient.get(URI.create(url));

            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return mapper.readValue(response.getBody(), new TypeReference<List<Course>>() {});
            } else {
                System.err.println("Erreur API: " + response.getStatusMessage());
                return Collections.emptyList();
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche du cours : " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // Détails d’un cours
    public Course getCoursParCode(String sigle) {
        try {
            String url = BASE_URL + "/" + sigle;
            HttpClientApiResponse response = httpClient.get(URI.create(url));

            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return mapper.readValue(response.getBody(), Course.class);
            } else {
                System.err.println("Erreur API: " + response.getStatusMessage());
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du cours : " + e.getMessage());
            return null;
        }
    }

    // Compare plusieurs cours (utilise les méthodes précédentes)
    public List<Course> getCoursParCodes(String[] sigles) {
        List<Course> list = new ArrayList<>();
        for (String sigle : sigles) {
            Course c = getCoursParCode(sigle.trim());
            if (c != null) list.add(c);
        }
        return list;
    }

    // Liste de tous les cours (ou filtrée par sigle)
    public List<Course> getAllCourses(String sigle) {
        return rechercherCours(sigle);
    }

    // Alias pour compatibilité avec la route /courses/{id}
    public Course getCourseById(String id) {
        return getCoursParCode(id);
    }
}