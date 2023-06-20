package Gatunki;

public class Obyczaj extends Gatunek{
    public Obyczaj(String nazwa, int liczbaUrzadzen) {
        super(nazwa, liczbaUrzadzen);
    }

    @Override
    public String toString() {
        return getNazwa() + ", typ: " + getNazwaKlasy() + ", ile: " + getLiczbaUrzadzen() + " urzadzenia" + ", cena ";
    }
}
