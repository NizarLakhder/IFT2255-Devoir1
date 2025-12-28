package com.diro.ift2255.controller;

import com.diro.ift2255.service.ProgramService;
import io.javalin.http.Context;

import java.util.Map;

public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    /**
     * GET /programs/{programId}
     * Exemples :
     *  /programs/117510
     *  /programs/117510?include_courses_detail=true
     *  /programs/117510?include_courses_detail=true&response_level=full
     */
    public void getProgram(Context ctx) {

        String programId = ctx.pathParam("programId");

        boolean includeDetails =
                "true".equalsIgnoreCase(ctx.queryParam("include_courses_detail"));

        String responseLevel = ctx.queryParam("response_level");
        if (responseLevel == null) {
            responseLevel = "reg";
        }

        Object result = programService.fetchProgram(
                programId,
                includeDetails,
                responseLevel
        );

        if (result == null) {
            ctx.status(404).json(
                    Map.of("message", "Programme " + programId + " non trouvé")
            );
        } else {
            ctx.json(result);
        }
    }
}