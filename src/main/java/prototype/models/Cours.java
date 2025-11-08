package prototype.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonAlias;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cours {

    @JsonAlias({"id", "sigle"})
    private String id;                // Exemple : "IFT2255"

    private String name;              // Exemple : "Génie logiciel"
    private double credits;           // Exemple : 3.0
    private String description;       // Description du cours

    // Champs optionnels d’après CourseComplete
    private String requirement_text;  // "Préalable : IFT1025"
    private String[] prerequisite_courses;
    private String[] equivalent_courses;

    // Constructeur vide requis par Jackson
    public Cours() {}

    public Cours(String id, String name, String description, double credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    // --- Getters ---
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getCredits() { return credits; }
    public String getRequirement_text() { return requirement_text; }
    public String[] getPrerequisite_courses() { return prerequisite_courses; }
    public String[] getEquivalent_courses() { return equivalent_courses; }

    // --- Setters ---
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCredits(double credits) { this.credits = credits; }
    public void setRequirement_text(String requirement_text) { this.requirement_text = requirement_text; }
    public void setPrerequisite_courses(String[] prerequisite_courses) { this.prerequisite_courses = prerequisite_courses; }
    public void setEquivalent_courses(String[] equivalent_courses) { this.equivalent_courses = equivalent_courses; }

    @Override
    public String toString() {
        return (id != null ? id : "(aucun sigle)") + " - " +
               (name != null ? name : "(nom manquant)") +
               " (" + credits + " crédits)";
    }
}
