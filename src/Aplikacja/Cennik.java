package Aplikacja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cennik{

    private static Cennik instance = null;

    public static Cennik pobierzCennik(){
        if(instance == null){
            instance = new Cennik();
        }
        return instance;
    }

    static Map<String, List<Program>> cennik = new HashMap<>();


    public void dodaj(String gatunek, String nazwa, double cenaUrzAb, double liczbaUrz, double cenaUrzBab, double cenaUrzBAbwpp ) {
        Program prg = new Program(gatunek,nazwa, cenaUrzAb,liczbaUrz, cenaUrzBab ,cenaUrzBAbwpp);
        if(cennik.containsKey(gatunek)){
            cennik.get(gatunek).add(prg);
        }else{
            cennik.put(prg.getGatunek(), new ArrayList<Program>());
            cennik.get(gatunek).add(prg);
        }
    }
    public void dodaj(String gatunek, String nazwa, double liczbaUrz, double cenaUrzAb, double cenaUrzBAb ) {
        Program prg = new Program(gatunek,nazwa, liczbaUrz, cenaUrzAb ,cenaUrzBAb);
        if(cennik.containsKey(gatunek)){
            cennik.get(gatunek).add(prg);
        }else{
            cennik.put(prg.getGatunek(), new ArrayList<Program>());
            cennik.get(gatunek).add(prg);
        }
    }
    public void dodaj(String gatunek, String nazwa, double cenaUrzAb, double cenaUrzBAb ) {
        Program prg = new Program(gatunek,nazwa, cenaUrzAb, cenaUrzBAb);
        if(cennik.containsKey(gatunek)){
            cennik.get(gatunek).add(prg);
        }else{
            cennik.put(prg.getGatunek(), new ArrayList<Program>());
            cennik.get(gatunek).add(prg);
        }
    }
    public void dodaj(String gatunek, String nazwa) {
        Program prg = new Program(gatunek,nazwa);
        if(cennik.containsKey(gatunek)){
            cennik.get(gatunek).add(prg);
        }else{
            cennik.put(prg.getGatunek(), new ArrayList<Program>());
            cennik.get(gatunek).add(prg);
        }
    }
}
