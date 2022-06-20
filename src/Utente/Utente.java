package Utente;

import Enumerator.Caschi;
import Enumerator.Patenti;

import java.util.List;

public class Utente {
    private String ID;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String CF;
    private List<Patenti> patenti;
    private List<Caschi> caschi;
    private int credito;

    public Utente(String ID, String nome, String cognome, String dataDiNascita, String CF, List<Patenti> patenti, List<Caschi> caschi, int credito) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.CF = CF;
        this.patenti = patenti;
        this.caschi = caschi;
        this.credito = credito;
    }
}
