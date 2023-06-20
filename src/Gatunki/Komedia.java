package Gatunki;

public class Komedia extends Gatunek{
    public Komedia(String nazwa, int liczbaUrzadzen) {
        super(nazwa, liczbaUrzadzen);
    }

    @Override
    public String toString() {
        return getNazwa() + ", typ: " + getNazwaKlasy() + ", ile: " + getLiczbaUrzadzen() + " urzadzenia" + ", cena ";
    }
}
