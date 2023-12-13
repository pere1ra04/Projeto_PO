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
public class Curso{
    private String designacaoCurso;
    private Professor diretorCurso;
    private ArrayList<UC> listaUCs= new ArrayList<>();
    private ArrayList<Aluno> listaAlunos= new ArrayList<>(); 
    private ArrayList<Sumario> listaSumarios= new ArrayList<>();

    public Curso(String designacaoCurso, Professor diretorCurso, ArrayList<UC> listaUC, ArrayList<Aluno> listaAlunos, ArrayList<Sumario> sumario) {
        setDesignacaoCurso(designacaoCurso);
        setDiretorCurso(diretorCurso);
        setListaUCs(listaUC);
        setListaAlunos(listaAlunos);
        setListaSumarios(sumario);
    }

    public String getDesignacaoCurso() {
        return designacaoCurso;
    }

    public void setDesignacaoCurso(String designacao) {
        this.designacaoCurso = designacao;
    }

    public Professor getDiretorCurso() {
        return diretorCurso;
    }

    public void setDiretorCurso(Professor diretorCurso) {
        this.diretorCurso = diretorCurso;
    }

    public ArrayList<UC> getListaUCs() {
        return listaUCs;
    }

    public void setListaUCs(ArrayList<UC> listaUCs) {
        this.listaUCs = listaUCs;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public ArrayList<Sumario> getListaSumarios() {
        return listaSumarios;
    }

    public void setListaSumarios(ArrayList<Sumario> listaSumarios) {
        this.listaSumarios = listaSumarios;
    }

    
    
}
