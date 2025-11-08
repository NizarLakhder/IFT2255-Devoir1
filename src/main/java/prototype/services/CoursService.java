package prototype.services;

import prototype.models.Cours;
import java.util.*;
import java.io.*;
import java.net.*;
import com.fasterxml.jackson.databind.*;

public class CoursService {

    private static final String API_BASE = "https://planifium-api.onrender.com/api/v1";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Cours> rechercherCours(String keyword) {
    try {
        if (keyword == null || keyword.isEmpty()) {
            return Collections.emptyList();
        }

        String query = URLEncoder.encode(keyword, "UTF-8");
        String urlStr;

        // Si l’utilisateur a saisi un sigle (ex : IFT2255)
        if (keyword.matches("^[A-Za-z]{3}\\d{4}$")) {
            urlStr = API_BASE + "/courses?sigle=" + query + "&response_level=reg";
        } else {
            // Recherche textuelle par nom du cours
            urlStr = API_BASE + "/courses?name=" + query + "&response_level=reg";
        }

        URL url = new URL(urlStr);
        System.out.println("→ Requête envoyée : " + url);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        if (conn.getResponseCode() != 200) {
            System.out.println("Erreur API recherche : code " + conn.getResponseCode());
            return Collections.emptyList();
        }

        try (InputStream is = conn.getInputStream()) {
            Cours[] coursArray = mapper.readValue(is, Cours[].class);
            return Arrays.asList(coursArray);
        }
    } catch (IOException e) {
        System.err.println("Erreur réseau : " + e.getMessage());
        return Collections.emptyList();
    }
}


    public Cours getCoursParCode(String code) {
        try {
            String urlStr = API_BASE + "/courses/" + URLEncoder.encode(code, "UTF-8");
            URL url = new URL(urlStr);
            System.out.println("→ Requête envoyée : " + url);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            if (conn.getResponseCode() != 200) {
                System.out.println("Erreur API détail : code " + conn.getResponseCode());
                return null;
            }

            try (InputStream is = conn.getInputStream()) {
                return mapper.readValue(is, Cours.class);
            }
        } catch (IOException e) {
            System.err.println("Erreur réseau : " + e.getMessage());
            return null;
        }
    }

    public List<Cours> getCoursParCodes(String[] codes) {
    try {
        String joined = String.join(",", codes);
        String urlStr = API_BASE + "/courses?courses_sigle=" + URLEncoder.encode(joined, "UTF-8") + "&response_level=full";
        URL url = new URL(urlStr);

        System.out.println("→ Requête envoyée : " + url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        if (conn.getResponseCode() != 200) {
            System.out.println("Erreur API comparaison : code " + conn.getResponseCode());
            return Collections.emptyList();
        }

        try (InputStream is = conn.getInputStream()) {
            Cours[] coursArray = mapper.readValue(is, Cours[].class);
            return Arrays.asList(coursArray);
        }
    } catch (IOException e) {
        System.err.println("Erreur réseau : " + e.getMessage());
        return Collections.emptyList();
    }
}


    public void comparerCours(List<Cours> coursList) {
    System.out.println("\n=== Comparaison de cours ===");

    for (Cours c : coursList) {
        System.out.printf("\nSigle : %s\nNom : %s\nCrédits : %.1f\n", 
                          c.getId(), c.getName(), c.getCredits());

        if (c.getDescription() != null)
            System.out.println("Description : " + c.getDescription());

        if (c.getRequirement_text() != null && !c.getRequirement_text().isEmpty())
            System.out.println("Préalables : " + c.getRequirement_text());

        

        if (c.getEquivalent_courses() != null && c.getEquivalent_courses().length > 0)
            System.out.println("Équivalents : " + String.join(", ", c.getEquivalent_courses()));
    }

    System.out.println("\n--- Fin de comparaison ---");
}

}
