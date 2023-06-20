package Aplikacja;

import Gatunki.Gatunek;

import java.util.ArrayList;
import java.util.List;

public class KoszykLista {
    private List<Gatunek> koszykLista = new ArrayList<>();
    Klient klient;

    public KoszykLista(Klient klient){
        this.klient = klient;
    }
    public void dodajDo(Gatunek gatunek){
        koszykLista.add(gatunek);
    }

    public Klient getKlient() {
        return klient;
    }

    public List<Gatunek> getKoszykLista() {
        return koszykLista;
    }

    @Override
    public String toString() {
        return "KoszykLista{" +
                "koszykLista=" + koszykLista +
                ", klient=" + klient +
                '}';
    }
}
