package com.diro.ift2255.controller;

import io.javalin.http.Context;
import com.diro.ift2255.model.Avis;
import com.diro.ift2255.service.AvisService;
import com.diro.ift2255.util.ResponseUtil;

public class AvisController {
    private final AvisService avisService;
    public AvisController(AvisService avisService) { this.avisService = avisService; }

    public void addAvis(Context ctx) {
        try {
            Avis avis = ctx.bodyAsClass(Avis.class);
            avisService.ajouterAvis(avis);
            ctx.status(201).json(avis);
        } catch (Exception e) {
            ctx.status(500).json(ResponseUtil.formatError("Erreur lors de l’ajout de l’avis : " + e.getMessage()));
        }
    }

    public void getAllAvis(Context ctx) {
        ctx.json(avisService.lireAvis());
    }
}