package com.diro.ift2255.service;

import com.diro.ift2255.model.Avis;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AvisServiceTest {

    private AvisService service;
    private static final String FILE_PATH = "data/avis.json";

    @BeforeEach
    void setUp() {
        // 🔥 RESET COMPLET avant chaque test
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
        service = new AvisService();
    }

    @Test
    void getByCourseReturnsOnlyMatchingCourse() {
        service.ajouterAvis(new Avis("IFT2255", 4, 4, "Bon cours", "Alice"));
        service.ajouterAvis(new Avis("IFT2255", 5, 5, "Difficile", "Bob"));
        service.ajouterAvis(new Avis("IFT1025", 3, 2, "Correct", "Charlie"));

        var avisIFT2255 = service.getByCourse("IFT2255");

        assertEquals(2, avisIFT2255.size());
        assertTrue(
            avisIFT2255.stream()
                .allMatch(a -> a.getCours().equalsIgnoreCase("IFT2255"))
        );
    }
}