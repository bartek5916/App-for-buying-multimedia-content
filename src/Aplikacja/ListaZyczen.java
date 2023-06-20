package Aplikacja;

import Gatunki.Gatunek;

import java.util.ArrayList;
import java.util.List;

public class ListaZyczen extends KoszykLista{
    private List<Gatunek> listaZyczen = new ArrayList<>();
    public ListaZyczen(Klient klient){
        super(klient);
    }

    @Override
    public void dodajDo(Gatunek gatunek){
        listaZyczen.add(gatunek);
    }

    public List<Gatunek> getListaZyczen() {
        return listaZyczen;
    }

    @Override
    public String toString() {
        String klient2 = this.klient.getNazwa() + ":" + "\n";
        if(listaZyczen.isEmpty()){
            return klient2 + "pusto" + "\n";
        }

        for(Gatunek gat : listaZyczen){
            klient2 = klient2 + gat + klient.getCena(gat.getNazwaKlasy(), gat.getNazwa()) + "\n";
        }

        return klient2;
    }
}
