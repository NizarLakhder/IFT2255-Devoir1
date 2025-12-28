package com.diro.ift2255.model;

import java.util.List;

public class EligibilityResult {

    private boolean eligible;
    private List<String> missingPrerequisites;
    private String message;

    public EligibilityResult(
            boolean eligible,
            List<String> missingPrerequisites,
            String message
    ) {
        this.eligible = eligible;
        this.missingPrerequisites = missingPrerequisites;
        this.message = message;
    }

    public boolean isEligible() {
        return eligible;
    }

    public List<String> getMissingPrerequisites() {
        return missingPrerequisites;
    }

    public String getMessage() {
        return message;
    }
}
