/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Professor{
    private String nomeProfessor;
    private String nMecanoProfessor;
    private String dataInicio;
    private ArrayList<UC> listaUC;

    public Professor(String nome, String nmecano, String dataInicio, ArrayList<UC> listaUC) {
        this.nomeProfessor = nome;
        this.nMecanoProfessor = nmecano;
        this.dataInicio = dataInicio;
        this.listaUC = listaUC;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nome) {
        this.nomeProfessor = nome;
    }

    public String getNMecanoProfessor() {
        return nMecanoProfessor;
    }

    public void setNMecanoProfessor(String nmecano) {
        this.nMecanoProfessor = nmecano;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public ArrayList<UC> getListaUC() {
        return listaUC;
    }

    public void setListaUC(ArrayList<UC> listaUC) {
        this.listaUC = listaUC;
    }
    //MUDANÇAAAAAAAAAAAAAAAAAAAAA
    
    
}

