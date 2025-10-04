package prototype.services;

import prototype.models.Cours;
import java.util.ArrayList;
import java.util.List;

public class CoursService {
    private List<Cours> coursDisponibles;

    public CoursService() {
        coursDisponibles = new ArrayList<>();
        
        coursDisponibles.add(new Cours("IFT2255 - Génie logiciel"));
        coursDisponibles.add(new Cours("IFT1015 - Programmation 1 "));
        coursDisponibles.add(new Cours("IFT1025 - Programmation 2 "));
        coursDisponibles.add(new Cours("MAT1400 - Calcul1"));
        coursDisponibles.add(new Cours("MAT1978 - Probabilité et statistique"));
        coursDisponibles.add(new Cours("MAT1600 - Algebre lineaire"));
        coursDisponibles.add(new Cours("IFT1227 - Architecture des ordinateurs "));
        coursDisponibles.add(new Cours("IFT2035 - Concepts des langages de programmation"));
        coursDisponibles.add(new Cours("IFT1215- Introduction aux Systemes informatiques"));
      
    
    }

    public List<Cours> getCoursDisponibles() {
        return coursDisponibles;
    }

    public void ajouterCours(Cours c) {
        coursDisponibles.add(c);
    }
}
