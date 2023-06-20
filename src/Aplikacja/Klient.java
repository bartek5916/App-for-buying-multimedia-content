package Aplikacja;

import Gatunki.Gatunek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Klient {
    private String nazwa;
    private double portfel;
    private Abonament abonament;
    private ListaZyczen listaZyczen;
    private KoszykLista koszykLista;
    private Koszyk koszyk;

    public Klient(String nazwa, int portfel, Abonament abonament) {
        this.nazwa = nazwa;
        this.portfel = portfel;
        this.abonament = abonament;
        this.listaZyczen = new ListaZyczen(this);
        this.koszykLista = new KoszykLista(this);
        this.koszyk = new Koszyk(this);
    }

    public void dodaj(Gatunek gatunek){
        listaZyczen.dodajDo(gatunek);
        koszykLista.dodajDo(gatunek);
    }
    public ListaZyczen pobierzListeZyczen() {
        return listaZyczen;
    }
    public Koszyk pobierzKoszyk() {
        return koszyk;
    }
    public double pobierzPortfel(){
        return portfel;
    }
    public String getNazwa() {
        return nazwa;
    }

    public void przepakuj(Koszyk kosz){
        this.koszyk = kosz;
        List<Gatunek> newList = new ArrayList<>(pobierzListeZyczen().getListaZyczen());
        for(Gatunek gat : newList){
            String gatunek = gat.getNazwaKlasy();
            String tytul = gat.getNazwa();
            for(Program program : Cennik.cennik.get(gatunek)){
                if(program.getTytul().equals(tytul)){
                    kosz.dodajDo(gat);
                    listaZyczen.getListaZyczen().remove(gat);
                }
            }
        }
    }

    public String getCena(String gatunek, String tytul){
        String gatunek2 = gatunek.toLowerCase();
        int liczbaUrzadzen = 0;
        boolean czyZnalezione = false;
        for(Program program : Cennik.cennik.get(gatunek2)){
            if(program.getTytul().equals(tytul)){
                for(Gatunek gatunekLista : koszykLista.getKoszykLista()){
                    if(gatunekLista.getNazwaKlasy().equals(gatunek2) && gatunekLista.getNazwa().equals(tytul)){
                        liczbaUrzadzen = gatunekLista.getLiczbaUrzadzen();
                        czyZnalezione = true;
                        gatunek2 = czyZnalezione ? String.valueOf(program.obliczCene(this.abonament, liczbaUrzadzen)) : "brak";
                        break;
                    }
                }
            }
        }
        if(gatunek2.equals(gatunek)){
            return "brak";
        }else{
            return gatunek2;
        }
    }
    public void zaplac(String sposobZaplaty, boolean czyOdlozyc){
        List<Double> listaCenKlienta = new ArrayList<>();
        List<Integer> listaUrzadzen = new ArrayList<>();
        double suma = 0;
        for(Gatunek gatunek : pobierzKoszyk().getKoszyk()){
            String gatunki = gatunek.getNazwaKlasy();
            String tytul = gatunek.getNazwa();
            for(Program program : Cennik.cennik.get(gatunki)){
                if(program.getTytul().equals(tytul)){
                    suma = suma + program.getCenaKlienta() * gatunek.getLiczbaUrzadzen();
                    listaCenKlienta.add(program.getCenaKlienta());
                    listaUrzadzen.add(gatunek.getLiczbaUrzadzen());
                }
            }
        }
        suma = sposobZaplaty.equals("karta") ? suma + suma * 0.02 : suma;
        if(suma > portfel){
            if(!czyOdlozyc){
                koszyk.getKoszyk().clear();
                koszykLista.getKoszykLista().clear();
                listaZyczen.getListaZyczen().clear();
            }else{
                List<Gatunek> zapasowyKoszyk = new ArrayList<>(koszyk.getKoszyk());

                //sortowanie

                for(int i = 0; i < listaCenKlienta.size(); i++){
                    for(int j = i + 1; j < listaCenKlienta.size(); j++){
                        if(listaCenKlienta.get(i) < listaCenKlienta.get(j)){
                            Collections.swap(listaCenKlienta, i , j);
                            Collections.swap(listaUrzadzen, i , j);
                            Collections.swap(zapasowyKoszyk, i , j);
                        }
                    }
                }

                koszyk.getKoszyk().clear();
                int counter = 1;
                for(int i = 0; i < listaCenKlienta.size() && suma > portfel;){
                    if(listaUrzadzen.get(i) > 0){
                        suma = suma - listaCenKlienta.get(i);
                        listaUrzadzen.set(i, listaUrzadzen.get(i)- 1);

                        Gatunek gat = zapasowyKoszyk.get(i);
                        gat.setLiczbaUrzadzen(counter++); // if
                        if(gat.getLiczbaUrzadzen() > 0 && !koszyk.getKoszyk().contains(gat)){
                            koszyk.getKoszyk().add(gat);
                        }
                    }else{
                        i++;
                        counter = 1;
                    }
                }
                portfel = portfel - suma;
            }
        }else{
            portfel = portfel - suma;
            koszyk.getKoszyk().clear();
        }
    }
}
