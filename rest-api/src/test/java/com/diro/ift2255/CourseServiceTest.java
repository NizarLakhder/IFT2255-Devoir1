package com.diro.ift2255;

import com.diro.ift2255.model.Course;
import com.diro.ift2255.util.HttpClientApi;
import com.diro.ift2255.util.HttpClientApiResponse;
import org.junit.jupiter.api.Test;
import com.diro.ift2255.service.CourseService;

import java.net.URI;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour CourseService.
 *
 * 12 tests sont réalisés , 3 par membre dequipe , de plus l'oracle des tests se situe dans la section évaluation . 
 * 
 * On réalise 
 * Cas d'utilisation couverts :
 *  - CU1 : Rechercher un cours
 *  - CU2 : Voir les détails d'un cours
 *  - CU3 : Comparer des cours
 *
 * On utilise un faux HttpClientApi pour ne appeler la vraie API Planifium.
 */
class CourseServiceTest {

    /**
     * Faux client HTTP qui renvoie une file de réponses préconfigurées.
     */
    static class FakeHttpClientApi extends HttpClientApi {
        private final Deque<HttpClientApiResponse> responses = new ArrayDeque<>();

        void addResponse(HttpClientApiResponse response) {
            responses.addLast(response);
        }

        @Override
        public HttpClientApiResponse get(URI uri) {
            if (responses.isEmpty()) {
                throw new IllegalStateException("Aucune réponse configurée pour " + uri);
            }
            return responses.removeFirst();
        }
    }

    // ============================================================
    // CU1 : RECHERCHER UN COURS
    // ============================================================

    // 1) Recherche simple : 1 cours trouvé
    @Test
    void rechercherCours_retourne_un_cours_quand_api_renvoie_un_seul_resultat() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            [
              {
                "id": "IFT1575",
                "name": "Modèles de recherche opérationnelle",
                "description": "Cours de RO",
                "credits": 3.0
              }
            ]
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        List<Course> result = service.rechercherCours("IFT1575");

        assertEquals(1, result.size());
        Course c = result.get(0);
        assertEquals("IFT1575", c.getId());
        assertEquals("Modèles de recherche opérationnelle", c.getName());
        assertEquals(3.0, c.getCredits(), 1e-6);
    }

    // 2) Recherche : plusieurs cours pour un sigle partiel
    @Test
    void rechercherCours_retourne_plusieurs_cours_pour_un_sigle_partiel() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            [
              {
                "id": "IFT2015",
                "name": "Structures de données",
                "description": "Listes, arbres, graphes",
                "credits": 3.0
              },
              {
                "id": "IFT2255",
                "name": "Génie logiciel",
                "description": "Intro GL",
                "credits": 3.0
              }
            ]
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        List<Course> result = service.rechercherCours("IFT");

        assertEquals(2, result.size());
        assertEquals("IFT2015", result.get(0).getId());
        assertEquals("IFT2255", result.get(1).getId());
    }

    // 3) Recherche insensible à la casse
    @Test
    void rechercherCours_est_insensible_a_la_casse() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            [
              {
                "id": "MAT1400",
                "name": "Calcul 1",
                "description": "Analyse",
                "credits": 4.0
              }
            ]
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        List<Course> result = service.rechercherCours("mat1400");  // minuscules

        assertEquals(1, result.size());
        assertEquals("MAT1400", result.get(0).getId());
    }

    // 4) Recherche : erreur serveur (500) -> liste vide
    @Test
    void rechercherCours_retourne_liste_vide_quand_api_en_erreur() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        fake.addResponse(new HttpClientApiResponse(500, "Erreur interne", "Internal error"));

        CourseService service = new CourseService(fake);

        List<Course> result = service.rechercherCours("IFT2255");

        assertTrue(result.isEmpty(), "En cas de code HTTP 5xx, on doit obtenir une liste vide");
    }

    // 5) Recherche : JSON vide -> liste vide
    @Test
    void rechercherCours_retourne_liste_vide_quand_json_vide() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = "[]";

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        List<Course> result = service.rechercherCours("IFT9999");

        assertTrue(result.isEmpty());
    }

    // 6) getAllCourses délègue bien à rechercherCours
    @Test
    void getAllCourses_delegue_a_rechercherCours() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            [
              { "id": "IFT2255", "name": "Génie logiciel", "description": "Intro", "credits": 3.0 },
              { "id": "IFT1015", "name": "Programmation 1", "description": "Base", "credits": 3.0 }
            ]
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        List<Course> courses = service.getAllCourses("IFT");

        assertEquals(2, courses.size());
        assertEquals("IFT2255", courses.get(0).getId());
        assertEquals("IFT1015", courses.get(1).getId());
    }

    // ============================================================
    // CU2 : VOIR LES DÉTAILS D’UN COURS
    // ============================================================

    // 7) Détails d’un cours : tout est bien mappé
    @Test
    void getCoursParCode_retourne_un_cours_quand_http_200() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            {
              "id": "MAT1600",
              "name": "Algèbre linéaire",
              "description": "Matrices, vecteurs…",
              "credits": 4.0
            }
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        Course cours = service.getCoursParCode("MAT1600");

        assertNotNull(cours);
        assertEquals("MAT1600", cours.getId());
        assertEquals("Algèbre linéaire", cours.getName());
        assertEquals(4.0, cours.getCredits(), 1e-6);
        assertEquals("Matrices, vecteurs…", cours.getDescription());
    }

    // 8) Détails d’un cours : 404 -> null
    @Test
    void getCoursParCode_retourne_null_quand_http_404() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        fake.addResponse(new HttpClientApiResponse(404, "Not Found", "Not found"));

        CourseService service = new CourseService(fake);

        Course cours = service.getCoursParCode("XXX0000");

        assertNull(cours);
    }

    // 9) getCourseById délègue à getCoursParCode
    @Test
    void getCourseById_appelle_getCoursParCode() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            {
              "id": "IFT2255",
              "name": "Génie logiciel",
              "description": "Intro",
              "credits": 3.0
            }
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        Course cours = service.getCourseById("IFT2255");

        assertNotNull(cours);
        assertEquals("IFT2255", cours.getId());
        assertEquals("Génie logiciel", cours.getName());
    }

    // ============================================================
    // CU3 : COMPARER DES COURS
    // ============================================================

    // 10) Comparer des cours : 2 valides, 1 invalide
    @Test
    void getCoursParCodes_retourne_les_cours_valides_et_ignore_les_inexistants() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String cours1 = """
            {
              "id": "IFT2015",
              "name": "Structures de données",
              "description": "Listes, arbres, graphes",
              "credits": 3.0
            }
            """;

        String cours2 = """
            {
              "id": "MAT1400",
              "name": "Calcul 1",
              "description": "Analyse",
              "credits": 4.0
            }
            """;

        // IFT2015 -> 200
        fake.addResponse(new HttpClientApiResponse(200, "OK", cours1));
        // XXX0000 -> 404
        fake.addResponse(new HttpClientApiResponse(404, "Not Found", "Not found"));
        // MAT1400 -> 200
        fake.addResponse(new HttpClientApiResponse(200, "OK", cours2));

        CourseService service = new CourseService(fake);

        List<Course> result = service.getCoursParCodes(
                new String[]{"IFT2015", "XXX0000", "MAT1400"});

        assertEquals(2, result.size());
        assertEquals("IFT2015", result.get(0).getId());
        assertEquals("MAT1400", result.get(1).getId());
    }

    // 11) Comparer des cours : tous invalides
    @Test
    void getCoursParCodes_retourne_liste_vide_si_tous_les_sigles_sont_invalides() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        fake.addResponse(new HttpClientApiResponse(404, "Not Found", "Not found"));
        fake.addResponse(new HttpClientApiResponse(404, "Not Found", "Not found"));

        CourseService service = new CourseService(fake);

        List<Course> result = service.getCoursParCodes(
                new String[]{"XXX0000", "YYY1111"});

        assertTrue(result.isEmpty());
    }

    // 12) Comparer des cours : trim des sigles avec espaces
    @Test
    void getCoursParCodes_gere_les_sigles_avec_espaces_autour() {
        FakeHttpClientApi fake = new FakeHttpClientApi();

        String body = """
            {
              "id": "IFT2255",
              "name": "Génie logiciel",
              "description": "Intro",
              "credits": 3.0
            }
            """;

        fake.addResponse(new HttpClientApiResponse(200, "OK", body));

        CourseService service = new CourseService(fake);

        List<Course> result = service.getCoursParCodes(new String[]{"   IFT2255   "});

        assertEquals(1, result.size());
        assertEquals("IFT2255", result.get(0).getId());
    }
}