package Aplikacja;

import Gatunki.Gatunek;

import java.util.ArrayList;
import java.util.List;

public class Koszyk extends KoszykLista{
    private List<Gatunek> koszyk = new ArrayList<>();
    public Koszyk(Klient klient) {
        super(klient);
    }
    @Override
    public void dodajDo(Gatunek gatunek){
        koszyk.add(gatunek);
    }

    public List<Gatunek> getKoszyk() {
        return koszyk;
    }

    public String toString(){
        String klient = this.klient.getNazwa() +":" + "\n";
        if(koszyk.isEmpty()){
            return klient + "pusto" + "\n";
        }
        for(Gatunek gat : koszyk){
            klient = klient + gat + this.klient.getCena(gat.getNazwaKlasy(), gat.getNazwa()) + "\n";
        }
        return klient;
    }
}
