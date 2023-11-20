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
    private String diretorCurso;
    private ArrayList<UC> listaUC;
    private ArrayList<Aluno> listaAlunos;

    public Curso(String designacao, String diretorCurso, ArrayList<UC> listaUC, ArrayList<Aluno> listaAlunos) {
        this.designacaoCurso = designacao;
        this.diretorCurso = diretorCurso;
        this.listaUC = listaUC;
        this.listaAlunos= listaAlunos;
    }

    public String getDesignacaoCurso() {
        return designacaoCurso;
    }

    public void setDesignacaoCurso(String designacao) {
        this.designacaoCurso = designacao;
    }

    public String getDiretorCurso() {
        return diretorCurso;
    }

    public void setDiretorCurso(String diretorCurso) {
        this.diretorCurso = diretorCurso;
    }

    public ArrayList<UC> getListaUC() {
        return listaUC;
    }

    public void setListaUC(ArrayList<UC> listaUC) {
        this.listaUC = listaUC;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
