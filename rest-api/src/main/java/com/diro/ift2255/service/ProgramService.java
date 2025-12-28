package com.diro.ift2255.service;

import com.diro.ift2255.util.HttpClientApi;
import com.diro.ift2255.util.HttpClientApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;

public class ProgramService {

    private static final String BASE_URL =
            "https://planifium-api.onrender.com/api/v1/programs";

    private final HttpClientApi httpClient;
    private final ObjectMapper mapper = new ObjectMapper();

    public ProgramService(HttpClientApi httpClient) {
        this.httpClient = httpClient;
    }

    public Object fetchProgram(
            String programId,
            boolean includeCoursesDetail,
            String responseLevel
    ) {
        try {
            StringBuilder url = new StringBuilder(BASE_URL + "?");
            url.append("programs_list=").append(programId);

            if (includeCoursesDetail) {
                url.append("&include_courses_detail=true");
            }

            if (responseLevel != null && !responseLevel.isBlank()) {
                url.append("&response_level=").append(responseLevel);
            }

            HttpClientApiResponse response =
                    httpClient.get(URI.create(url.toString()));

            if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return mapper.readValue(response.getBody(), Object.class);
            }

        } catch (Exception e) {
            System.err.println("Erreur API Planifium (programs): " + e.getMessage());
        }

        return null;
    }
}