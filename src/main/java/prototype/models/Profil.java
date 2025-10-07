package prototype.models;

public class Profil {
    private String programme;
    private boolean prefereTheorie;
    private boolean preferePratique;
    private String interets;

    public Profil(String programme, boolean theorie, boolean pratique, String interets) {
        this.programme = programme;
        this.prefereTheorie = theorie;
        this.preferePratique = pratique;
        this.interets = interets;
    }

    public String getProgramme() {
        return programme;
    }

    public boolean isPrefereTheorie() {
        return prefereTheorie;
    }

    public boolean isPreferePratique() {
        return preferePratique;
    }

    public String getInterets() {
        return interets;
    }
}
