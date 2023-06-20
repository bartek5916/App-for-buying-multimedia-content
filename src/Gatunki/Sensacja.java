package Gatunki;

public class Sensacja extends Gatunek{
    public Sensacja(String nazwa, int liczbaUrzadzen) {
        super(nazwa, liczbaUrzadzen);
    }

    @Override
    public String toString() {
        return getNazwa() + ", typ: " + getNazwaKlasy() + ", ile: " + getLiczbaUrzadzen() + " urzadzenia" + ", cena ";
    }
}
