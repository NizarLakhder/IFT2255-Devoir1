package com.diro.ift2255.service;

import com.diro.ift2255.model.ResultatAcademique;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class ResultatService {

    private static final String FILE_PATH = "data/resultats.csv";

    public Optional<ResultatAcademique> getBySigle(String sigle) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line = br.readLine(); // header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[0].equalsIgnoreCase(sigle)) {
                    ResultatAcademique r = new ResultatAcademique();
                    r.setSigle(parts[0]);
                    r.setNom(parts[1]);
                    r.setMoyenne(parts[2]);
                    r.setScore(Double.parseDouble(parts[3]));
                    r.setParticipants(Integer.parseInt(parts[4]));
                    r.setTrimestres(Integer.parseInt(parts[5]));
                    return Optional.of(r);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}