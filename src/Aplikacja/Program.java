package Aplikacja;

public class Program {
    private String gatunek;
    private String tytul;
    private double cenaUrzAb;
    private double cenaUrzBAb;
    private double liczbaUrz;
    private double cenaUrzBAbwpp;
    private double cenaKlienta;

    public Program() {
    }

    public Program(String gatunek, String tytul) {
        this.gatunek = gatunek;
        this.tytul = tytul;
    }

    public Program(String gatunek, String tytul, double cenaUrzAb, double cenaUrzBAb) {
        this(gatunek, tytul);
        this.cenaUrzAb = cenaUrzAb;
        this.cenaUrzBAb = cenaUrzBAb;
    }

    public Program(String gatunek, String tytul ,double liczbaUrz, double cenaUrzAb, double cenaUrzBAb) {
        this(gatunek,tytul,cenaUrzAb,cenaUrzBAb);
        this.liczbaUrz = liczbaUrz;
    }

    public Program(String gatunek, String tytul, double cenaUrzAb, double liczbaUrz, double cenaUrzBAb, double cenaUrzBAbwpp) {
        this(gatunek, tytul, liczbaUrz, cenaUrzAb, cenaUrzBAb);
        this.cenaUrzBAbwpp = cenaUrzBAbwpp;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getTytul() {
        return tytul;
    }

    public double obliczCene(Abonament abonament, int liczbaUrzadzen){
        return switch (licznikWarunkow()){
            case 2 ->{
                if(abonament == Abonament.TAK){
                    cenaKlienta = cenaUrzAb;
                    yield cenaUrzAb;
                }else{
                    cenaKlienta = cenaUrzBAb;
                    yield cenaUrzBAb;
                }
            }
            case 3 -> {
                if(liczbaUrzadzen <= 2){
                    cenaKlienta = cenaUrzAb;
                    yield cenaUrzAb;
                }
                else{
                    cenaKlienta = cenaUrzBAb;
                    yield cenaUrzBAb;
                }
            }
            case 4 ->{
                if(abonament == Abonament.TAK){
                    cenaKlienta = cenaUrzAb;
                    yield cenaUrzAb;
                }else if(liczbaUrzadzen <= liczbaUrz){
                    cenaKlienta = cenaUrzBAb;
                    yield cenaUrzBAb;
                }else{
                    cenaKlienta = cenaUrzBAbwpp;
                    yield cenaUrzBAbwpp;
                }
            }
            default -> {
                cenaKlienta = 0;
                yield 0;
            }
        };
    }

    int licznikWarunkow(){
        int licznik = 0;
        if(cenaUrzAb != 0){
            licznik++;
        }
        if(cenaUrzBAb != 0){
            licznik++;
        }
        if(liczbaUrz != 0){
            licznik++;
        }
        if(cenaUrzBAbwpp != 0){
            licznik++;
        }
        return licznik;
    }

    public double getCenaKlienta() {
        return cenaKlienta;
    }

    public double getLiczbaUrz() {
        return liczbaUrz;
    }
}
