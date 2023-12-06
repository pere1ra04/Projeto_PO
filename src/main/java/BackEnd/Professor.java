/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author user
 */
public class Professor{
    private String nomeProfessor;
    private String nMecanoProfessor;
    private String dataInicio;
    private ListaUCs listaUC;

    public Professor(String nome, String nmecano, String dataInicio, ListaUCs listaUC) {
        setNomeProfessor(nome);
        setNMecanoProfessor(nmecano);
        setDataInicio(dataInicio);
        setListaUC(listaUC);
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

    public ListaUCs getListaUC() {
        return listaUC;
    }

    public void setListaUC(ListaUCs listaUC) {
        this.listaUC = listaUC;
    }
    
    


}

