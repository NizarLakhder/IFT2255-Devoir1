package prototype.services;

import prototype.models.Etudiant;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private Map<String, String> comptes;
    private Map<String, Etudiant> utilisateurs;

    public AuthService() {
        comptes = new HashMap<>();
        utilisateurs = new HashMap<>();
    }

    public boolean creerCompte(String nom, String email, String motDePasse) {
        if (comptes.containsKey(email)) return false;
        comptes.put(email, motDePasse);
        utilisateurs.put(email, new Etudiant(nom));
        return true;
    }

    public Etudiant authentifier(String email, String motDePasse) {
        if (comptes.containsKey(email) && comptes.get(email).equals(motDePasse)) {
            return utilisateurs.get(email);
        }
        return null;
    }
}
