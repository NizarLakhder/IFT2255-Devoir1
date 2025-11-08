package com.diro.ift2255.service;

import com.diro.ift2255.model.Avis;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;

public class AvisService {
    private static final String FILE_PATH = "dataDiscord/avis.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Avis> lireAvis() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println(" Aucun avis encore enregistré (" + file.getAbsolutePath() + ")");
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Avis>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void ajouterAvis(Avis avis) {
        List<Avis> avisList = lireAvis();
        avisList.add(avis);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), avisList);
            System.out.println(" Avis ajouté dans : " + new File(FILE_PATH).getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}