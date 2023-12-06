/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author user
 */
public class Curso{
    private String designacaoCurso;
    private Professor diretorCurso;
    private ListaUCs listaUC;
    private ListaAlunos listaAlunos;
    private ListaSumarios sumario;

    public Curso(String designacaoCurso, Professor diretorCurso, ListaUCs listaUC, ListaAlunos listaAlunos, ListaSumarios sumario) {
        setDesignacaoCurso(designacaoCurso);
        setDiretorCurso(diretorCurso);
        setListaUC(listaUC);
        setListaAlunos(listaAlunos);
        setSumario(sumario);
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

    public ListaUCs getListaUC() {
        return listaUC;
    }

    public void setListaUC(ListaUCs listaUC) {
        this.listaUC = listaUC;
    }

    public ListaAlunos getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ListaAlunos listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public ListaSumarios getSumario() {
        return sumario;
    }

    public void setSumario(ListaSumarios sumario) {
        this.sumario = sumario;
    }
    
    
}
