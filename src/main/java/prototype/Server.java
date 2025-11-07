package prototype;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.javalin.Javalin;
import io.javalin.http.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Server {

    // === model ===
    public static class Avis {
        public String cours;
        public int difficulte;
        public int charge;
        public String commentaire;
        public String auteur;

        public Avis() {}
    }

    // === config ===
    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT); 
    private static final File file = new File("data/avis.json");

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.http.defaultContentType = "application/json";
        }).start(7070);

        System.out.println(" API démarrée sur http://localhost:7070");

        // --- endpoints ---
        app.get("/", ctx -> ctx.result("API en ligne "));
        app.get("/api/avis", Server::getAvis);
        app.post("/api/avis", Server::addAvis);
    }

    // === GET /api/avis ===
    private static void getAvis(Context ctx) {
        try {
            if (!file.exists()) {
                ctx.json(List.of());
                return;
            }
            Avis[] avisList = mapper.readValue(file, Avis[].class);
            ctx.json(avisList);
        } catch (Exception e) {
            ctx.status(500).json(Map.of("error", e.getMessage()));
        }
    }

    // === POST /api/avis ===
    private static void addAvis(Context ctx) {
        try {
            Avis avis = ctx.bodyAsClass(Avis.class);

         
            List<Avis> avisList = new ArrayList<>();
            if (file.exists()) {
                Avis[] existing = mapper.readValue(file, Avis[].class);
                avisList = new ArrayList<>(List.of(existing));
            }

          
            avisList.add(avis);

            
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, avisList);

            System.out.println(" Avis ajouté : " + avis.cours);
            ctx.status(201).json(Map.of("status", "saved", "data", avis));
        } catch (Exception e) {
            ctx.status(400).json(Map.of("error", e.getMessage()));
        }
    }
}
