package com.diro.ift2255.controller;

import com.diro.ift2255.service.ResultatService;
import io.javalin.http.Context;
import java.util.Map;

public class ResultatController {

    private final ResultatService service;

    public ResultatController(ResultatService service) {
        this.service = service;
    }

    public void getResultatByCourse(Context ctx) {
        String sigle = ctx.pathParam("sigle");

        service.getBySigle(sigle)
            .ifPresentOrElse(
                ctx::json,
                () -> ctx.status(404)
                          .json(Map.of(
                              "error",
                              "Aucun résultat académique pour ce cours"
                          ))
            );
    }
}