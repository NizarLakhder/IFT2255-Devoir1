package com.diro.ift2255.service;

import com.diro.ift2255.model.Course;
import com.diro.ift2255.util.HttpClientApi;
import com.diro.ift2255.util.HttpClientApiResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.*;

public class CourseService implements IService<Course> {
    private final HttpClientApi httpClient;
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String BASE_URL = "https://planifium-api.onrender.com/api/v1/courses";

    public CourseService(HttpClientApi httpClient) {
        this.httpClient = httpClient;
    }

    // Recherche un cours par sigle
    public List<Course> rechercherCours(String sigle) {
        try {
            String url = BASE_URL + "?sigle=" + sigle.toUpperCase();
            HttpClientApiResponse response = httpClient.get(URI.create(url));

            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return mapper.readValue(response.getBody(), new TypeReference<List<Course>>() {});
            } else {
                System.err.println("Erreur API (rechercheCours): " + response.getStatusMessage());
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
            String url = BASE_URL + "/" + sigle.toUpperCase();
            HttpClientApiResponse response = httpClient.get(URI.create(url));

            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return mapper.readValue(response.getBody(), Course.class);
            } else {
                System.err.println("Erreur API (getCoursParCode): " + response.getStatusMessage());
                return null;
            }
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du cours : " + e.getMessage());
            return null;
        }
    }

    // Compare plusieurs cours
    public List<Course> getCoursParCodes(String[] sigles) {
        List<Course> list = new ArrayList<>();
        for (String sigle : sigles) {
            Course c = getCoursParCode(sigle.trim());
            if (c != null) list.add(c);
        }
        return list;
    }

    public List<Course> getAllCourses(String sigle) {
        return rechercherCours(sigle);
    }

    public Course getCourseById(String id) {
        return getCoursParCode(id);
    }
   @Override
public List<Course> getAll() {
    return getAllCourses("");
}

@Override
public Course getById(String id) {
    return getCourseById(id);
}

@Override
public void create(Course entity) {
    throw new UnsupportedOperationException("Not supported.");
}

@Override
public void update(String id, Course entity) {
    throw new UnsupportedOperationException("Not supported.");
}

@Override
public void delete(String id) {
    throw new UnsupportedOperationException("Not supported.");
}

}