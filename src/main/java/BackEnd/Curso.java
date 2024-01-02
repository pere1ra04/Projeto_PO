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
public class Curso implements Serializable {
    private String designacaoCurso;
    private String diretorCurso;
    private ArrayList<UC> listaUCs= new ArrayList<>();
    private ArrayList<Aluno> listaAlunos= new ArrayList<>(); 
    

    public Curso(String designacaoCurso, String diretorCurso, ArrayList<UC> listaUC, ArrayList<Aluno> listaAlunos) {
        setDesignacaoCurso(designacaoCurso);
        setDiretorCurso(diretorCurso);
        setListaUCs(listaUC);
        setListaAlunos(listaAlunos);
    }
    
    public Curso(String designacaoCurso, String diretorCurso){
        setDesignacaoCurso(designacaoCurso);
        setDiretorCurso(diretorCurso);
    }

    public void adicionarUCs(UC a){
        listaUCs.add(a);
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
 
    public void inserirAlunoCurso(Aluno a) {
        listaAlunos.add(a);
    }
    

    @Override
    public String toString() {
        return "Curso{" + "designacaoCurso=" + designacaoCurso + ", diretorCurso=" + diretorCurso + '}';
    }

    
    
}
