package Gatunki;
public abstract class Gatunek {
    private String nazwa;
    private int liczbaUrzadzen;
    private String nazwaKlasy;

    public Gatunek(String nazwa, int liczbaUrzadzen) {
        this.nazwa = nazwa;
        this.liczbaUrzadzen = liczbaUrzadzen;
        this.nazwaKlasy = getClass().getSimpleName().toLowerCase();
    }

    public String getNazwa(){
        return this.nazwa;
    }

    public int getLiczbaUrzadzen(){
        return this.liczbaUrzadzen;
    }

    public String getNazwaKlasy() {
        return nazwaKlasy;
    }

    public void setLiczbaUrzadzen(int liczbaUrzadzen) {
        this.liczbaUrzadzen = liczbaUrzadzen;
    }

    @Override
    public abstract String toString();

}
