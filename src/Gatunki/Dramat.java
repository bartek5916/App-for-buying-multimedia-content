package Gatunki;
public class Dramat extends Gatunek {
    public Dramat(String nazwa, int liczbaUrzadzen) {
        super(nazwa, liczbaUrzadzen);
    }

    @Override
    public String toString() {
        return getNazwa() + ", typ: " + getNazwaKlasy() + ", ile: " + getLiczbaUrzadzen() + " urzadzenia" + ", cena ";
    }
}
