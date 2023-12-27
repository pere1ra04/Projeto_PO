/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Professor implements Serializable {
    private String nomeProfessor;
    private String nMecanoProfessor;
    private String dataInicio;
    private ArrayList<UC> listaUCs= new ArrayList<>();
    private ArrayList<Sumario> listaSumarios= new ArrayList<>();

    public Professor(String nome, String nmecano, String dataInicio, ArrayList<UC> listaUC, ArrayList<Sumario> listaSumarios) {
        setNomeProfessor(nome);
        setNMecanoProfessor(nmecano);
        setDataInicio(dataInicio);
        setListaUCs(listaUC);
        setListaSumarios(listaSumarios); 
    }
    
    public Professor(String nome, String nmecano, String dataInicio) {
        setNomeProfessor(nome);
        setNMecanoProfessor(nmecano);
        setDataInicio(dataInicio);
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

    public ArrayList<UC> getListaUCs() {
        return listaUCs;
    }

    public void setListaUCs(ArrayList<UC> listaUCs) {
        this.listaUCs = listaUCs;
    }

    public ArrayList<Sumario> getListaSumarios() {
        return listaSumarios;
    }

    public void setListaSumarios(ArrayList<Sumario> listaSumarios) {
        this.listaSumarios = listaSumarios;
    }
    
    public void inserirServicoDocente(UC a) {
        listaUCs.add(a);
    }
    
    public void removerServicoDocente(UC a) {
        listaUCs.remove(a);
    }

    public void listaSumariosPorTipoUC(String Tipo,String UC) {
        for (Sumario a : listaSumarios) {
            if(a.getUC().equals(UC)){
                if(a.getTipo().equals(Tipo)){
                    System.out.printf("->Titulo: %s\n",a.getTitulo());
                    System.out.printf("->Tipo: %s\n",a.getTipo());
                    System.out.printf("->Data: %s\n",a.getData_hora());
                    System.out.printf("->Sumario: %s",a.getSumario());
                }
            }
        }
    }
    
    public void listaServicoDocente() {
        for (UC a : listaUCs) {
            System.out.printf("->UC: %s\n",a.getDesignacaoUC());
            System.out.printf("->Regente: %s\n",a.getRegenteUC());
        }
    }
    
    @Override
    public String toString() {
        return "Professor{" + "nomeProfessor=" + nomeProfessor + ", nMecanoProfessor=" + nMecanoProfessor + ", dataInicio=" + dataInicio + '}';
    }

}

